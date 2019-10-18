
def search(arr, x):
    l = 0
    r = len(arr)-1
    while l <= r:

        mid = l + (r - l) // 2

        if arr[mid] == x:
            return mid

        elif arr[mid] < x:
            l = mid + 1

        else:
            r = mid - 1

    return -1


def sortedHasSum(S, n, x):
    r = n - 1
    l = 0

    while l < r:
        if S[l] + S[r] == x:
            return True
        elif S[l] + S[r] < x:
            l += 1
        else:
            r -= 1
    return False


def hasSum(S, n, x):
    quicksort(S, 0, n - 1)
    r = n - 1
    l = 0

    while l < r:
        if S[l] + S[r] == x:
            return True
        elif S[l] + S[r] < x:
            l += 1
        else:
            r -= 1
    return False


def quicksort(arr, l, h):
    while l < h:
        p = partition(arr, l, h)

        if (p - l) < (h - p):
            quicksort(arr, l, p - 1)
            l = p + 1
        else:
            quicksort(arr, p + 1, h)
            h = p -1


def partition(arr, low, high):
    i = (low - 1)
    pivot = arr[high]

    for j in range(low, high):

        if arr[j] <= pivot:
            i = i + 1
            arr[i], arr[j] = arr[j], arr[i]

    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return i + 1

