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

// void assertTrue(int statement) {
//     if (statement == 1) {
//         printf("Test passed\n");
//     } else {
//         printf("Test failed\n");
//     }
// }

int main() {

  srand(time(NULL));
  int passes = 0, fails = 0;
  int i, result = 0, numPlayers = 0, currentPlayer = 0;
  int handCount = 0, deckCount = 0, playerCoins = 0;
  int seed = 100;
  int handPos = 0;
  int bonus = 0;
  //int choice1, choice2, choice3 = 0;
  int k[10] = {adventurer, embargo, village, minion, mine, cutpurse,sea_hag, tribute, smithy, council_room};
  struct gameState gs;
  for (i = 0; i < TOTAL_TESTS; i++) {

    // need btwn 2 - 4 players to play
    numPlayers = rand() % 3 + 2;

    initializeGame(numPlayers, k, seed, &gs);

    //Initiate valid state variables
    gs.deckCount[currentPlayer] = rand() % MAX_DECK; //Pick random deck size out of MAX DECK size
    gs.discardCount[currentPlayer] = rand() % MAX_DECK;
    gs.handCount[currentPlayer] = rand() % MAX_HAND;

    //Copy state variables
    handCount = gs.handCount[currentPlayer];
    deckCount = gs.deckCount[currentPlayer];

    playerCoins = gs.coins;

    int card = 0, coins = 0;
    card = handCount;
    coins = playerCoins;

		gs.hand[currentPlayer][0] = adventurer;

    int returnValue;
    returnValue = cardEffect(adventurer, 0, 0, 0, &gs, handPos, &bonus);		//Run Adventurer card

    handCount = gs.handCount[currentPlayer];


    // never going to pass bc of the bug i introduced
    if (handCount > card) {
      //printf("cards increased incorrectly\n");
      //printf("fail\n");
      fails++;
    } else {
      //printf("pass\n");
      passes++;
    }

    discardCard(handPos, 1, &gs, 0);

    returnValue = cardEffect(adventurer, 0, 0, 0, &gs, handPos, &bonus);		//Run Adventurer card

    if (returnValue != 0) {
      //printf("return value of adventurer is bad\n");
      //printf("fail\n");
      fails++;
    } else {
      //printf("pass\n");
      passes++;
    }
    //memset(&gs, '\0', sizeof(gs));
  }
  printf("total passes: %d\n", passes);
  printf("total fails: %d\n", fails);
  return 0;
}
