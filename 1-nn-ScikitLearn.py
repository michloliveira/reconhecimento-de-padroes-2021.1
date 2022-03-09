from sklearn import datasets
from sklearn.neighbors import KNeighborsClassifier
import numpy as np

iris = datasets.load_iris()
x =  iris.data
y = iris.target

#Criando conjunto de treino
TreinoSetosa= iris.data[:25]
TreinoVersicolor = iris.data[50:75]
TreinoVirginica= iris.data[100:125]

Treino =  np.concatenate((TreinoSetosa,TreinoVersicolor,TreinoVirginica))

#criando conjunto de teste
TesteSetosa= iris.data[:25]
TesteVersicolor = iris.data[50:75]
TesteVirginica= iris.data[100:125]

teste = np.concatenate((TesteSetosa,TesteVersicolor,TesteVirginica))