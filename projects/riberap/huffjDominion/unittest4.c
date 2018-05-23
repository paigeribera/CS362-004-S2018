#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>
#include <math.h>

int main() {
    printf("~~testing function supplyCount~~\n");
    int testsPassed, testsFailed = 0;
    int i, n, p, r, randomCardCount;

     struct gameState G;

     SelectStream(2);
     PutSeed(3);

       randomCardCount = floor(Random() * MAX_HAND);
       //p = floor(Random() * 2);
       G.deckCount[1] = floor(Random() * MAX_DECK);
       G.discardCount[1] = floor(Random() * MAX_DECK);
       G.handCount[1] = randomCardCount;

       srand(time(NULL));
       int randomNumForCard;
       int randomNumOfCards;
       int sc;

       printf("Testing cases....");
       for (i = 0; i < 10000; i++) {
         randomNumForCard = rand() % 27;
         randomNumOfCards = rand() % 101;
         G.supplyCount[randomNumForCard] = randomNumOfCards;
         sc = supplyCount(randomNumForCard, &G);
         assert(randomNumOfCards == sc);
       }

     printf("All 10000 tests passed");
       return 0;
}
