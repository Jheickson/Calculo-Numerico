import math

k = 0

def f(x):
    return  x*math.e*(x)-1

def df(x):
    return x*(1+math.e(x))


def newton(x0, tol, maxiter):
    iter = 0
    error = tol + 1

    while error > tol and iter < maxiter:
        iter += 1
        dx = -f(x0) / df(x0)
        x = x0 + dx
        error = abs(x - x0)
        x0 = x

        print('n = ' + str(iter) + ' x = ' + str(x) + ' error = ' + str(error))

    if error > tol:
        x = None
    
    return x

x0 = 0.5
tol = 0.0000000001

print(newton(x0, tol, 100))