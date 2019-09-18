# Question 5
# Began running slow in the mid 30s
def fib(n):
    if n == 1:
        return 0
    elif n == 2:
        return 1
    else:
        return fib(n-1) + fib(n-2)

# Question 7
def fibItHelper(n, a, b):
    if n == 0:
        return a
    elif n == 1:
        return b
    else:
        return fibItHelper(n-1, b, a+b)

# Question 7
# Did not run as slow as fib
def fibIt(n):
    return fibItHelper(n-1, 0, 1)


def main():
    print(fib(35))
    print(fibIt(35))


main()
