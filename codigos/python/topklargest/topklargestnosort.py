def findklargest(elements, top):
    if (top > 0 and top < len(elements)):
        if (top < 2):
            print(max(elements))
        else:
            print(max(elements), end=" > ")
        elements.pop(elements.index(max(elements)))
        findklargest(elements, top - 1)

if __name__ == "__main__":
    elements = [10, 24, 45, 2, 43, 65, 87, 34, 22, 12, 64, 98, 100, 55]
    findklargest(elements, 7)