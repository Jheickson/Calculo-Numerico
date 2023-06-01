import math

def f(x):
    #return (x**3) - x - 1 #Questao 2
    return x**3 - 9*x + 2

def fixed_point(g, x0, tol, maxiter):
    iter = 0
    error = tol + 1

    while error > tol and iter < maxiter:
        iter += 1
        x = g(x0)
        error = abs(x - x0)
        x0 = x
        print('n = ' + str(iter) + ', x = ' + str(x) + ', error = ' + str(error))

    if error > tol:
        x = None

    return x

# exemplo de uso
def g(x):
    return (x**3 + 2) / 9

fixed_point(g, 0.5, 1e-5, 100)
