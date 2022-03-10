from sklearn import datasets
from sklearn.neighbors import KNeighborsClassifier
from sklearn.datasets import load_wine
from sklearn.model_selection import train_test_split

x,y = load_wine(return_X_y = True)
treinoX, testeX, treinoY, testeY = train_test_split(x,y,test_size=0.5) #test_size proporção

knn = KNeighborsClassifier(n_neighbors=7, weights= "uniform",metric="euclidean")
knn.fit(treinoX,treinoY)

print(knn.predict(testeX))
print(knn.score(testeX,testeY))