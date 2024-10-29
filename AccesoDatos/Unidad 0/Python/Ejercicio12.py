import random # Importamos la librería random

lista=[]

for i in range (1, 10+1): # Creamos un bucle de 1 a 10 para que se realice la
    # operación 10 veces
    lista.append(random.randint(1, 50))
    # Con el método lista.append insertamos en la última posición de la lista
    # el número aleatorio mediante el método random.randint de la librería
    # random e indicamos que ese número se encuentre entre el 1 y el 50

print(lista)
