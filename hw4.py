def max2(x, y):
    return ((x+y)+abs(x-y))*.5


def fSelect(arr, i):
    arr.sort()
    return arr[i-1]


def iSelect(arr, i):
    return iSelectHelper(arr, 0, len(arr)-1, i)


def iSelectHelper(arr, l, h, i):
    if i > 0 and i <= h - l + 1:
        index = partition(arr, l, h)
        if index - l == i - 1:
            return arr[index]
        if index - l > i - 1:
            return iSelectHelper(arr, l, index - 1, i)
        return iSelectHelper(arr, index + 1, h, i - index + l - 1)
    return "Error"


def partition(arr, low, high):
    i = (low - 1)
    pivot = arr[high]

    for j in range(low, high):

        if arr[j] <= pivot:
            i = i + 1
            arr[i], arr[j] = arr[j], arr[i]

    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return i + 1
