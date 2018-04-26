#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>

int main() {
    printf("~~testing function whoseTurn~~");
    int testsPassed, testsFailed = 0;
    struct gameState gs1, gs2, gs3, gs4, gs5, testState;
    int numPlayers;
    int k[10] = {adventurer, embargo, village, minion, mine, cutpurse,sea_hag, tribute, smithy, council_room};
    int seed = 100;

    //initializeGame(numPlayers, k, seed, &gs);

    //printf("%d\n", whoseTurn(&gs));

    // always return an integer
    // range btwn 2 - 4
    // test for 1 player. test for 5 players
    // test 1, 4, 0, 5

    printf("Testing Edge Cases for Number of Players\n");
    printf("Testing 0 Players\n");
    numPlayers = 0;
    int gameCreated = initializeGame(numPlayers, k, seed, &gs1);
    printf("Return value of initializeGame...%d", gameCreated);
    assert(gameCreated == -1);
    printf("gameCreated == -1 passed\n");
    numPlayers = 1;
    int gameCreated2 = initializeGame(numPlayers, k, seed, &gs2);
    assert(gameCreated2 == -1);
    printf("gameCreated with 1 player not possible - test passed\n");
    numPlayers = 2;
    int gameCreated3 = initializeGame(numPlayers, k, seed, &gs3);
    assert(gameCreated3 == 0);
    printf("gameCreated with 1 player possible - test passed\n");
    gs3.whoseTurn = 1;
    int pTurn;
    pTurn = whoseTurn(&gs3);
    assert(pTurn == 1);
    printf("Player 1's turn...test passed\n");
    gs3.whoseTurn = 0;
    pTurn = whoseTurn(&gs3);
    assert(pTurn == 0);
    printf("Player 0's turn...test passed\n");



    return 0;
}
