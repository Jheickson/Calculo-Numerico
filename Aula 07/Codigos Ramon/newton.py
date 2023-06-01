import math

k = 0

def f(x):
    #return  math.exp(-x**2) - math.cos(x) #Questao 1
    #return x**3 - x - 1 #Questao 2
    return (x**3) - 9*x + 2 #Questao 3



def df(x):
    #return math.sin(x) - 2 * math.exp(-x**2) * x #Questao 1
    #return 3 * (x**2) - 1 #Questao 2
    return 3*(x**2-3) #Questao 3



def newton(x0, tol, maxiter):
    iter = 0
    error = tol + 1

    while error > tol and iter < maxiter:
        iter += 1
        dx = -f(x0) / df(x0)
        x = x0 + dx
        error = abs(x - x0)
        x0 = x
        fx = f(x)

        print('n = ' + str(iter) + ' \tx = ' + str(x) + ' \tf(x) = ' + str(fx) + ' \terror = ' + str(error))

    if error > tol:
        x = None
    
    return x

def q1():
    x0 = 1.5
    tol = 10**(-7)

    print(newton(x0, tol, 100))

def q2():
    x0 = 0
    tol = 10**(-5)

    print(newton(x0, tol, 100))

def q3():
    x0 = 0
    tol = 10**(-10)

    print(newton(x0, tol, 100))

q2()