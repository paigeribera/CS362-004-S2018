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

int assertTrue(int statement) {
    if (statement == 1) {
        return 1;
    } else {
        return 0;
    }
}

int main() {

  srand(time(NULL));
  int passesHand = 0;
  int passesDeck = 0;
  int i, result = 0, numPlayers = 0, currentPlayer = 0;
  int handCount = 0, deckCount = 0, playerCoins = 0;
  int handPos = 0;
  int bonus = 0;
  int seed;
  //int choice1, choice2, choice3 = 0; not used for smithy
  int k[10] = {adventurer, embargo, village, minion, mine, cutpurse,sea_hag, great_hall, smithy, council_room};
  struct gameState gs;
  for (i = 0; i < TOTAL_TESTS; i++) {
    seed = rand();
    // need btwn 2 - 4 players to play
    numPlayers = rand() % 3 + 2;

    initializeGame(numPlayers, k, seed, &gs);

    //Initiate valid state variables
    gs.deckCount[currentPlayer] = rand() % MAX_DECK; // use max sizes to assign random values
    gs.discardCount[currentPlayer] = rand() % MAX_DECK;
    gs.handCount[currentPlayer] = rand() % MAX_HAND;

    playerCoins = gs.coins;

    int handBefore = 0, coins = 0;
    handBefore = numHandCards(&gs);
    int deckBefore = 0, deckAfter = 0;
    deckBefore = gs.deckCount[0];
    coins = playerCoins;

		gs.hand[currentPlayer][0] = smithy;

    int returnValue = 0;
    returnValue = cardEffect(smithy, 0, 0, 0, &gs, handPos, &bonus);

    int handAfter = 0;
    handAfter = numHandCards(&gs);
    deckAfter = gs.deckCount[0];
    // never going to pass bc of the bug i introduced

    // + 2
    passesHand += assertTrue((handAfter - handBefore) == 2);

    // + 4
    passesDeck += assertTrue((deckBefore - deckAfter) == 4);
    // didn't introduce bug here...is discard not working properly?
    // potential unexpected bug here.


  }
  printf("total hand passed tests: %d\n", passesHand);
  printf("total deck passed tests: %d\n", passesDeck);
  //printf("total fails: %d\n", fails);
  return 0;
}
