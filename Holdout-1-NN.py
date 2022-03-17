from sklearn import datasets
from sklearn.neighbors import KNeighborsClassifier
from sklearn.datasets import load_wine
from sklearn.model_selection import train_test_split

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
    #print
    print(matrix_confusion[0])
    print(matrix_confusion[1])
    print(matrix_confusion[2])

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
    
    #print(soma_total)
    #print(soma_diagonal)

    taxa_acerto = soma_diagonal / soma_total
    #print(taxa_acerto)
    print("A taxa de acerto é {0:.2f}".format(taxa_acerto))
    return taxa_acerto

def calcular_taxa_de_precisao(matriz_confusion):
    # precisao = taxa_de_acerto da classe / soma de toda classe

    #taxa de precisao classe 0
    classe_0 = matriz_confusion[0][0] / (matriz_confusion[0][0] + matriz_confusion[1][0] + matriz_confusion[2][0])
    #taxa de precisao classe 1
    classe_1 = matriz_confusion[1][1] / (matriz_confusion[0][1] + matriz_confusion[1][1] + matriz_confusion[2][1])
    #taxa de precisao classe 2
    classe_2 = matriz_confusion[2][2] / (matriz_confusion[0][2] + matriz_confusion[1][2] + matriz_confusion[2][2])

    print("Taxa de Precisão:\nClasse 0 = {0:.2f}\nClasse 1 = {1:.2f}\nClasse 2 = {2:.2f}".format(classe_0, classe_1, classe_2))

    return classe_0, classe_1, classe_2

def calcular_taxa_de_recall(matriz_confusion):
    #recall = taxa_de acerto da classe / soma da linha com outras classes

    #taxa de recall classe 1
    classe_0 = matriz_confusion[0][0] / (matriz_confusion[0][0] + matriz_confusion[0][1] + matriz_confusion[0][2])
    #taxa de recall classe 1
    classe_1 = matriz_confusion[1][1] / (matriz_confusion[1][0] + matriz_confusion[1][1] + matriz_confusion[1][2])
    #taxa de recall classe 2
    classe_2 = matriz_confusion[2][2] / (matriz_confusion[2][0] + matriz_confusion[2][1] + matriz_confusion[2][2])     

    print("Taxa de Recall:\nClasse 0 = {0:.2f}\nClasse 1 = {1:.2f}\nClasse 2 = {2:.2f}".format(classe_0, classe_1, classe_2))
    
    return classe_0, classe_1, classe_2

def calcular_f1(pClasse0, pClasse1, pClasse2, rClasse0, rClasse1, rClasse2):
    #F1 = 2 * (precision * recall) / (precision + recall)
    #f1 para classe 0
    f1_c0 = 2 * (pClasse0 * rClasse0) / (pClasse0 + rClasse0)
    #f1 para classe 1
    f1_c1 = 2 * (pClasse1 * rClasse1) / (pClasse1 + rClasse1)
    #f1 para classe 2
    f1_c2 = 2 * (pClasse2 * rClasse2) / (pClasse2 + rClasse2)

    print("Medida F:\nClasse 0 = {0:.2f}\nClasse 1 = {1:.2f}\nClasse 2 = {2:.2f}".format(f1_c0, f1_c1, f1_c2))


def calcular_fp(m):
    #falsoPositivo taxa = falsoPositivo/ falsoPositivo + verdadeiroNegativo
   
    fp_c0 = (m[1][0] + m[2][0]) / ((m[1][0] + m[2][0]) + (m[1][1] + m[2][1] + m[1][2] + m[2][2]))
    fp_c1 = (m[0][1] + m[2][1]) / ((m[0][1] + m[2][1]) + (m[0][0] + m[2][0] + m[0][2] + m[2][2]))
    fp_c2 = (m[0][2] + m[1][2]) / ((m[0][2] + m[1][2]) + (m[0][0] + m[1][0] + m[0][1] + m[1][1]))
    print("Taxa Falso Positivo:\nClasse 0 = {0:.2f}\nClasse 1 = {1:.2f}\nClasse 2 = {2:.2f}".format(fp_c0, fp_c1, fp_c2))


x,y = load_wine(return_X_y = True)
treinoX, testeX, treinoY, testeY = train_test_split(x,y,test_size=0.30) #test_size proporção 

knn = KNeighborsClassifier(n_neighbors=1, weights= "distance",metric="euclidean")
knn.fit(treinoX,treinoY)

y_pred = knn.predict(testeX)
y_true = testeY

matriz_confusion = make_matriz_confusion(y_true,y_pred)
rClasse0, rClasse1, rClasse2 = calcular_taxa_de_recall(matriz_confusion)
taxa_acerto = calcular_taxa_de_acerto(matriz_confusion)
pClasse0, pClasse1, pClasse2 = calcular_taxa_de_precisao(matriz_confusion)
calcular_f1(pClasse0, pClasse1, pClasse2, rClasse0, rClasse1, rClasse2)
calcular_fp(matriz_confusion)