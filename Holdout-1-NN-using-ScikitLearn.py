from sklearn import datasets
from sklearn.neighbors import KNeighborsClassifier
from sklearn.datasets import load_wine
from sklearn.model_selection import train_test_split
from sklearn.metrics import confusion_matrix
from sklearn.metrics import precision_score
from sklearn.metrics import recall_score
from sklearn.metrics import f1_score
from sklearn.metrics import accuracy_score


x,y = load_wine(return_X_y = True)
treinoX, testeX, treinoY, testeY = train_test_split(x,y,test_size=0.30) #test_size proporção 

knn = KNeighborsClassifier(n_neighbors=1, weights= "distance",metric="euclidean")
knn.fit(treinoX,treinoY)

y_pred = knn.predict(testeX)
y_true = testeY


print(confusion_matrix(y_true,y_pred))
print("recall por classe:")
print(recall_score(y_true,y_pred,average=None))
print("taxa de acerto:")
print(accuracy_score(y_true,y_pred))
print("taxa de precisao:")
print(precision_score(y_true,y_pred,average=None))
print("medida F:")
print(f1_score(y_true, y_pred, average=None))
