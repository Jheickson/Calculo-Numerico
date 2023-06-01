import math

def f(x):
    #return  math.exp(-x**2) - math.cos(x) #Questao 1
    #return x**3 - x - 1 #Questao 2
    return (x**3) - 9*x + 2 #Questao 3



def secant(x0, x1, tol, maxiter):
    iter = 0
    error = tol + 1

    while error > tol and iter < maxiter:
        iter += 1
        fx0 = f(x0)
        fx1 = f(x1)
        dx = (x1 - x0) / (fx1 - fx0) * fx1
        x = x1 - dx
        error = abs(x - x1)
        x0, x1 = x1, x
        fx = f(x)


        print('n = ' + str(iter) + ' x = ' + str(x) + ' fx ' + str(fx) + ' error = ' + str(error))

    if error > tol:
        x = None
    
    return x



def q1():
    x0 = 1
    x1 = 1.5
    tol = 10**(-7)

    print(secant(x0, x1, tol, 100))

def q2():
    x0 = 0
    x1 = 0.5
    tol = 10**(-5)

    print(secant(x0, x1, tol, 100))

def q3():
    x0 = -0.5
    x1 = 0
    tol = 10**(-10)

    print(secant(x0, x1, tol, 100))

q3()