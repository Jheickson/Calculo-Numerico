import math

def f(x):
    #return math.exp(-x**2) - math.cos(x) #Questao 1
    #return x**3 - x - 1 #Questao 2
    return x**3 - 9*x + 2 #Questao 3


def bisection(a, b, tol, maxiter):
    iter = 0
    error = tol + 1

    while error > tol and iter < maxiter:
        iter += 1
        c = (a + b) / 2
        fc = f(c)
        if f(a) * fc < 0:
            b = c
        elif f(b) * fc < 0:
            a = c
        else:
            break
        error = (b - a) / 2

        print('n = ' + str(iter) + ' \tx = ' + str(c) + ' \tf(x) = ' + str(fc) + ' \terror = ' + str(error))


    if error > tol:
        c = None

    return c




def q1():
    a = 1
    b = 1.5
    tol = 10**(-7)
    print(bisection(a, b, tol, 100))

def q2():
    a = 0
    b = 1.5
    tol = 10**(-5)
    print(bisection(a, b, tol, 100))

def q3():
    a = 0
    b = 1
    tol = 10**(-10)
    print(bisection(a, b, tol, 100))

q3()