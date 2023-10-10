# Program to find simetrical difference between two arrays

def simDiff(arr1, arr2):
    arrDiff = []
    while (len(arr1) > 0):
        if arr1[0] in arr2:
            arrDiff.append(arr1[0])
        arr1.pop(0)
    return arrDiff

if __name__ == "__main__":
    arr1 = [1, 2, 3]
    arr2 = [2, 3, 6, 7]
    arr3 = [2, 4, 7, 9, 10]
    arrDiff = simDiff(arr1, arr2)
    print(arrDiff)
    arrDiff = simDiff(arrDiff, arr3)
    print(arrDiff)