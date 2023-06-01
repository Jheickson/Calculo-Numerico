import math

k = 0

# a = float(input("Digite o valor de A: "))
# b = float(input("Digite o valor de B: "))
# e = float(input("Digite o valor da tolerância: "))

a = 1
b = 1.5
e = 10**(-7)

def fx(x):
    #return 2*(x**2) - 4*x
    return math.exp(-x**2) - math.cos(x)

xk = 0
while abs(a-b) > e:
    xk = (a + b) / 2

    if fx(a) * fx(xk) > 0:
        a = xk
    else:
        b = xk

    k = k + 1

print(xk)
