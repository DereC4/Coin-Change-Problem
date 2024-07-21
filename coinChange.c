#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int min(int a, int b) {
    return (a < b) ? a : b;
}

int coinChange(int* coins, int coinsSize, int amount) {
    // Initialize a DP array to an array of length = (our target amount + 1)
    // Fill the array to amount + 1, leaving index 0 as 0
    int* counts = (int*)malloc((amount + 1) * sizeof(int));
    for (int i = 0; i <= amount; i++) {
        counts[i] = amount + 1;
    }
    counts[0] = 0;

    // Searching through each index to find the OPTIMAL coin value
    for (int i = 0; i <= amount; i++) {
        for (int j = 0; j < coinsSize; j++) {
            if (i - coins[j] >= 0) {
                counts[i] = min(counts[i], counts[i - coins[j]] + 1);
            }
        }
    }

    int result = (counts[amount] >= amount + 1) ? -1 : counts[amount];
    free(counts);

    return result;
}