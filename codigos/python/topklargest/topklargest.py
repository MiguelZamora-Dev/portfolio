def findklargest(elements, top):
    elements.sort()
    for i in range(top):
        print(elements[-1 * (i + 1)])

if __name__ == "__main__":
    elements = [10, 24, 45, 2, 43, 65, 87, 34, 22, 12, 64, 98, 100, 55]
    findklargest(elements, 7)