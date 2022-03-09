from sklearn import datasets
from sklearn.neighbors import KNeighborsClassifier
import numpy as np

iris = datasets.load_iris()
x =  iris.data
y = iris.target
#Criando conjuntos de treino
TreinoSetosa= iris.data[:25]
TreinoVersicolor = iris.data[50:75]
TreinoVirginica= iris.data[100:125]

Treino =  np.concatenate((TreinoSetosa,TreinoVersicolor,TreinoVirginica))
