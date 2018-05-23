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
    printf("~~testing adventurer card~~\n");
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
    int result = cardEffect(adventurer, choice1, choice2, choice3, &gs, handPos, &bonus);
    int handCountAfterCard = numHandCards(&gs);
    printf("Testing that +2 cards get added to hand...\n");
    // this will fail because of the bug i introduced in assignment2
    assertTrue(handCountAfterCard - handCountBeforeCard == 2);



    return 0;

}
