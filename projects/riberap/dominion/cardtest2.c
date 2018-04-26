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
  printf("~~testing smithy card~~\n");
  int testsPassed, testsFailed = 0;
  struct gameState gs;
  int numPlayers = 2;
  int seed = 100;
  int handPos = 0;
  int bonus = 0;
  int choice1, choice2, choice3 = 0;
  int k[10] = {adventurer, embargo, village, minion, mine, cutpurse,sea_hag, tribute, smithy, council_room};

  initializeGame(numPlayers, k, seed, &gs);

  int handCountBeforeCard = numHandCards(&gs);
  int deckCountBeforeCard = gs.deckCount[0];
  int result = cardEffect(smithy, choice1, choice2, choice3, &gs, handPos, &bonus);
  int handCountAfterCard = numHandCards(&gs);
  int deckCountAfterCard = gs.deckCount[0];

  // expected behavior: 3 cards drawn from deck...
  // but then player played 1 card. so +2 CARDS
  // for player and deck +4 cards
  printf("testing that hand has +2 cards\n");
  assertTrue(handCountAfterCard - handCountBeforeCard == 2);
  printf("testing that deck has +4 cards\n");
  assertTrue(deckCountAfterCard - deckCountBeforeCard == 4);
  // above doesn't account for the discarded card


  return 0;
}
