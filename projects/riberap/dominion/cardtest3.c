#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>
#include <math.h>

void assertTrue(int statement) {
    if (statement == 1) {
        printf("Test passed\n");
    } else {
        printf("Test failed\n");
    }
}


int main() {

  printf("~~testing village card~~\n");
  int testsPassed, testsFailed = 0;
  struct gameState gs;
  int numPlayers = 2;
  int seed = 100;
  int handPos = 0;
  int bonus = 0;
  int choice1, choice2, choice3 = 0;
  int k[10] = {adventurer, embargo, village, minion, mine, cutpurse,sea_hag, tribute, smithy, council_room};

  initializeGame(numPlayers, k, seed, &gs);

  // what does village do?
  // +1 card to player
  // +2 Actions
  // -1 card from player

  int handCountBeforeCard = numHandCards(&gs);
  int deckCountBeforeCard = gs.deckCount[0];
  int actionsBefore = gs.numActions;
  int result = cardEffect(village, choice1, choice2, choice3, &gs, handPos, &bonus);
  int handCountAfterCard = numHandCards(&gs);
  int actionsAfter = gs.numActions;
  int deckCountAfterCard = gs.deckCount[0];

  printf("Testing that there is a net gain of 0 cards\n");
  assertTrue(handCountBeforeCard == handCountAfterCard);
  printf("Testing that actions have increased by 2\n");
  assertTrue(actionsAfter - actionsBefore == 2);
  // village card gets played, card also discared, so -1 +1 -1 = -1 to deck
  printf("Testing that the deck card difference after village is played is 1\n");
  assertTrue(deckCountAfterCard - deckCountBeforeCard == 1);

  printf("all tests passed\n");
  return 0;
}
