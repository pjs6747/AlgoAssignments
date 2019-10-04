

# Doesn't work but think I was on right track
#
def fibPow(n):
    # return pow(L(0,1), n)

def L(a,b):
    if b == 1:
        return [0,1]
    elif a == 1 && b == 1:
        return [1,1]
    else:
        return [[1,1],[1,0]]