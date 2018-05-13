#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>
#include <math.h>
#include <time.h>

#define TOTAL_TESTS 5000

int main() {

  srand(time(NULL));
  int passes = 0, fails = 0;
  int i, result = 0, numPlayers = 0, currentPlayer = 0;
  int handCount = 0, deckCount = 0, playerCoins = 0;
  int seed = 100;
  int handPos = 0;
  int bonus = 0;
  //int choice1, choice2, choice3 = 0;
  int k[10] = {adventurer, embargo, village, minion, mine, cutpurse,sea_hag, great_hall, smithy, council_room};
  struct gameState gs = {};
  for (i = 0; i < TOTAL_TESTS; i++) {

    // need btwn 2 - 4 players to play
    numPlayers = rand() % 3 + 2;

    initializeGame(numPlayers, k, seed, &gs);

    //Initiate valid state variables
    gs.deckCount[currentPlayer] = rand() % MAX_DECK; //Pick random deck size out of MAX DECK size
    gs.discardCount[currentPlayer] = rand() % MAX_DECK;
    gs.handCount[currentPlayer] = rand() % MAX_HAND;

    handCount = gs.handCount[currentPlayer];
    deckCount = gs.deckCount[currentPlayer];

    playerCoins = gs.coins;

    int card = 0, coins = 0;
    card = handCount;
    int actionsBefore = 0, actionsAfter = 0;
    actionsBefore = gs.numActions;
    coins = playerCoins;

		gs.hand[currentPlayer][0] = great_hall;

    int returnValue = cardEffect(great_hall, 0, 0, 0, &gs, handPos, &bonus);		//Run Adventurer card

    handCount = gs.handCount[currentPlayer];

    actionsAfter = gs.numActions;
    if (handCount == card) {
      passes++;
    }

    if (actionsAfter - actionsBefore == 1) {
      // printf("actions inc by one\n");
      // printf("TEST PASSED\n");
      passes++;
    }


    //memset(&gs, '\0', sizeof(gs));
  }
  printf("total passes: %d\n", passes);
  printf("total fails: %d\n", fails);
  return 0;
}
