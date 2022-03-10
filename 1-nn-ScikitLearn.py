from sklearn import datasets
from sklearn.neighbors import KNeighborsClassifier
import numpy as np

iris = datasets.load_iris()
x =  iris.data
y = iris.target

#Criando conjunto de treino
#data
TreinoSetosaX= iris.data[:25]
TreinoVersicolorX = iris.data[50:75]
TreinoVirginicaX= iris.data[100:125]
TreinoX =  np.concatenate((TreinoSetosaX,TreinoVersicolorX,TreinoVirginicaX))

#target
TreinoSetosaY= iris.target[:25]
TreinoVersicolorY = iris.target[50:75]
TreinoVirginicaY= iris.target[100:125]
TreinoY =  np.concatenate((TreinoSetosaY,TreinoVersicolorY,TreinoVirginicaY))

#criando conjunto de teste
#data
TesteSetosaX= iris.data[25:50]
TesteVersicolorX = iris.data[75:100]
TesteVirginicaX= iris.data[125:150]
testeX = np.concatenate((TesteSetosaX,TesteVersicolorX,TesteVirginicaX))

#target
TesteSetosaY= iris.target[25:50]
TesteVersicolorY = iris.target[75:100]
TesteVirginicaY= iris.target[125:150]
testeY = np.concatenate((TesteSetosaY,TesteVersicolorY,TesteVirginicaY))

#k-nn var

knn = KNeighborsClassifier(n_neighbors=1, weights= "uniform", metric= "euclidean")
knn.fit(TreinoX,TreinoY)

print(knn.predict(testeX))
print(knn.score(testeX, testeY))
