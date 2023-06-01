import math 

k = 0

def fx(x):
    return math.exp(-x**2) - math.cos(x) #Questao 1
    #return (x**3) - x - 1 #Questao 2
    #return x**3 - 9*x + 2 #Questao 3



def gx(x):
    return math.sqrt(- math.log(math.cos(x)))
    #return (x+1)**(1/3) #Questao 2
    #return (x**3 + 2) / 9 #Questao 3




def fixedpoint(x0, tol, maxiter):

    iter = 0

    error = tol + 1

    while error > tol and iter < maxiter:
        iter = iter + 1
        x = gx(x0)
        error = abs(x - x0)
        x0 = x

        print('n=' + str(iter) + ', x=' + str(x) + ', f\'(x)=' + str(fx(x)) + ', error=' + str(error))
        

    return x0


fixedpoint(1.5, 10**-7, 100) #Questao 1
#fixedpoint(0.5, 10**-5, 100) #Questao 2
#fixedpoint(0.0, 10**-10, 100) #Questao 3
