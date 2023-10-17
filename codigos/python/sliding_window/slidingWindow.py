
def slidingWindow(k, window, numbers, sum = None):
    if sum:
        print(sum)
    if k < (len(numbers) - window + 1) and window <= len(numbers):
        if sum == None:
            sum = 0
            for i in range(window):
                sum += numbers[k+i]
            slidingWindow(k+1, window, numbers, sum)
        else:
            slidingWindow(k+1, window, numbers, sum - numbers[k-1] + numbers[k+window-1])

if __name__ == "__main__":
    numbers = [2, 21, 45, 3, 14, 10, 9, 6, 17, 15]
    k = 0
    window = 4
    slidingWindow(k, window, numbers)
