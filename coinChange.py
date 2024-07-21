def coinChange(coins, amount):
    counts = [amount + 1] * [amount + 1]
    counts[0] = 0

    for i in range(amount + 1):
        for j in range(coins):
            counts[i] = min(counts[i], 1 + counts[i - coins[j]])
    return -1 if counts[amount] >= amount + 1 else counts[amount]