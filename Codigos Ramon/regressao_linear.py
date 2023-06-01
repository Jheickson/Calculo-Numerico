import numpy as np
import matplotlib.pyplot as plt

m = 3
xdata = np.array([1,3,4])
ydata = np.array([3,7,9])
A = np.array([[np.sum(xdata**2), np.sum(xdata)], [np.sum(xdata), m]])
b = np.array([np.sum(xdata*ydata), np.sum(ydata)])
x = np.linalg.solve(A, b)

xfit = np.arange(min(xdata), max(xdata), 0.01)
yfit = x[0]*xfit + x[1]

plt.plot(xdata, ydata, "om", xfit, yfit, "-b", linewidth=2)
plt.show()