#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>

#define MAX_CARD_NUMBER 27

int main() {
    printf("~~testing function getCost~~\n");
    int testsPassed, testsFailed = 0;
    // generate random card numbers to be in deck
    // pass it a card number that doesn't exist

    int cardCost;
    int cardCosts[27] = {0, 2, 5, 8, 0, 3, 6, 6, 5, 4, 4, 5, 4, 4, 3, 4, 3, 5, 3, 5, 3, 4, 2, 5, 4, 4, 4};

    // test a negative number
    // can't have negative index in enum
    printf("Checking for a card at a negative index\n");
    printf("Expected return value: -1\n");
    cardCost = getCost(-5);

    assert(cardCost == -1);
    printf("Actual return value: %d\n", cardCost);
    printf("Test passed...\n");


    // checking for number higher than max enum index
    printf("Checking for a card at a higher index than exists\n");
    printf("Expected return value: -1\n");
    cardCost = getCost(30);
    assert(cardCost == -1);
    printf("Actual return value: %d\n", cardCost);
    printf("Test passed...\n");

    printf("Checking for a card at first index that exists\n");
    printf("Expected return value: 0\n");
    cardCost = getCost(0);
    assert(cardCost == 0);
    printf("Actual return value: %d\n", cardCost);
    printf("Test passed...\n");

    printf("Checking for a card at first index that exists\n");
    printf("Expected return value: 0\n");
    cardCost = getCost(26);
    assert(cardCost == cardCosts[26]);
    printf("Actual return value: %d\n", cardCost);
    printf("Test passed...\n");

    srand(time(NULL));
    int randomNum;
    int i;
    for (i = 0; i < 10; i++) {
      randomNum = rand() % 28;
      printf("Random card selected corresponding to enum CARD...%d\n", randomNum);
      printf("Testing the randomly selected card against its expected cost\n");
      printf("Expected cost returned: %d\n", cardCosts[randomNum]);
      cardCost = getCost(randomNum);
      assert(cardCost == cardCosts[randomNum]);
      printf("Actual cost returned: %d\n", cardCost);
      printf("Test passed...\n");
    }

    return 0;
}
