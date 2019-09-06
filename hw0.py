def r (alist):
    if alist == []:
        return []
    else:
        return r(alist[1:]) + [alist[0]]


def prod(m, n):
    if m == 0:
        return 0
    else:
        return prod(m - 1, n) + n


def fastPow(b, k):
    if k == 0:
        return 1
    elif (k % 2) == 0:
        return (b**2)**(k/2)
    else:
        return (b**2)**((k-1)/2)*b


def prodAccum(m, n, a=0):
    if m == 0:
        return a
    else:
        return prodAccum(m-1, n, a+m)

def minChange(a, aList):
    if a == 0:
        return 0
    elif aList == []:
        return None
    elif aList[0] > a:
        return minChange(a, aList[1:])
    else:
        return min(add(1, minChange(a-aList[0], aList)), minChange(a, aList[1:]))


def greedyMinChange(a, aList):
    if a == 0:
        return 0
    elif aList == []:
        return None
    elif aList[0] > a:
        greedyMinChange(a, aList[1:])
    else:
        q = a/aList[0]
        r = a%aList[0]
        return add(q, greedyMinChange(r, aList[1:]))


def min(x, y):
    if x is None or y is None:
        return None
    elif x > y:
        return y
    else:
        return x


def add(x, y):
    if x is None or y is None:
        return None
    else:
        return x+y



def main():
    print(r([1, 4, 1, 2]))
    print(prod(2, 7))
    print(fastPow(2, 3))
    print(fastPow(2, 4))
    print(prodAccum(5, 3))
    print(minChange(56, [25, 10, 1]))

main()
