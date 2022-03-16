from sklearn import datasets
from sklearn.neighbors import KNeighborsClassifier
from sklearn.datasets import load_wine
from sklearn.model_selection import train_test_split
from sklearn.metrics import confusion_matrix

def make_matriz_confusion(y_true,y_pred):
    matrix_confusion = [[0,0,0],
                        [0,0,0],
                        [0,0,0]]
    i = 0
    while(i < len(y_true)):

        if (y_true[i]) == 0:
            if(y_pred[i]) == 0:
                matrix_confusion[0][0] += 1
            elif(y_pred[i]) == 1:
                matrix_confusion[0][1] += 1
            else:
                matrix_confusion[0][2] +=1

        elif (y_true[i]) == 1:
            if(y_pred[i]) == 0:
                matrix_confusion[1][0] += 1
            elif(y_pred[i]) == 1:
                matrix_confusion[1][1] += 1
            else:
                matrix_confusion[1][2] +=1   

        else:
            if(y_pred[i]) == 0:
                matrix_confusion[2][0] += 1
            elif(y_pred[i]) == 1:
                matrix_confusion[2][1] += 1
            else:
                matrix_confusion[2][2] +=1
        i= i+1
    return matrix_confusion

def calcular_taxa_de_acerto(matriz_confusion):
    #A taxa de acerto do classificador é a (soma da diagonal principal)/(soma total da matriz)

    #somando diagonal principal
    soma_diagonal = matriz_confusion[0][0] + matriz_confusion[1][1] + matriz_confusion[2][2]
    soma_total = 0
    #somando total matriz
    for i in range(3):
        for j in range(3):
            soma_total += matriz_confusion[i][j]
    
    print(soma_total)
    print(soma_diagonal)

    taxa_acerto = soma_diagonal / soma_total
    print(taxa_acerto)
    print("A taxa de acerto é {0:.2f}".format(taxa_acerto))

x,y = load_wine(return_X_y = True)
treinoX, testeX, treinoY, testeY = train_test_split(x,y,test_size=0.30) #test_size proporção 

knn = KNeighborsClassifier(n_neighbors=1, weights= "distance",metric="euclidean")
knn.fit(treinoX,treinoY)

y_pred = knn.predict(testeX)
y_true = testeY
#print(confusion_matrix(y_true,y_pred)) #confusion_matrix(y_true, y_pred) API
matriz_confusion = make_matriz_confusion(y_true,y_pred)
print(matriz_confusion[0])
print(matriz_confusion[1])
print(matriz_confusion[2])

calcular_taxa_de_acerto(matriz_confusion)