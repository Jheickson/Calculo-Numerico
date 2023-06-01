import math 

k = 0

def fx(x):
    return 2*(x**2) - 4*x


def gx(x):
    return math.sqrt(1+x)
    # return (1+x)/(1+2.718281828459045**x)

def show_info(iter, x, error):
    print('n='+str(iter)+', x='+str(x)+', error='+str(error)+'\n')


def fixedpoint(x0, tol, maxiter):

    iter = 0

    error = tol + 1

    while error > tol and iter < maxiter:
        iter = iter + 1
        x = gx(x0)
        error = abs(x - x0)
        x0 = x
        show_info(iter, x, error)

    return x0


fixedpoint(0.5, 10**-9, 10000)