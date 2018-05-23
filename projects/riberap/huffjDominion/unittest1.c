/*
testing isGameOver
game ends when:
> 0 provinces

*/

#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>
#include <math.h>

int main() {
    printf("~~testing function isGameOver~~");
    int i, n, p, r, randomCardCount;

     struct gameState G;

     SelectStream(2);
     PutSeed(3);

     // initialize hand
     // taken from betterTestDrawCard.c
     for (n = 0; n < 10000; n++) {
       for (i = 0; i < sizeof(struct gameState); i++) {
         ((char*)&G)[i] = floor(Random() * 256);
       }
       // create a random but sane game state
       randomCardCount = floor(Random() * MAX_HAND);
       p = floor(Random() * 2);
       G.deckCount[p] = floor(Random() * MAX_DECK);
       G.discardCount[p] = floor(Random() * MAX_DECK);
       G.handCount[p] = randomCardCount;


       // test if game ends with 0 provices
       G.supplyCount[province] = 0;
       r = isGameOver(&G);
       assert(r == 1);

       // test if game ends with > 0 provinces
       G.supplyCount[province] = 1;
       r = isGameOver(&G);
       assert (r == 0);

       // test if game ends with 1 empty pile
       G.supplyCount[feast] = 0;
       r =  isGameOver(&G);
       assert(r == 0);

       // test if game ends with 2 empty pile
       G.supplyCount[smithy] = 0;
       r = isGameOver(&G);
       assert(r == 0);

       // test if game ends with 3 empty pile
       G.supplyCount[adventurer] = 0;
       r = isGameOver(&G);
       assert(r == 1);
   }

     printf("All tests passed!\n");

    return 0;
  }
