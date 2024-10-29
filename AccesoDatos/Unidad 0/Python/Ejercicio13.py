import random

lista=[]

for i in range (1, 10+1): # Creamos un bucle de 1 a 10 para que se realice la
    # operación 10 veces
    lista.append(random.randint(1, 50))
    # Con el método lista.append insertamos en la última posición de la lista
    # el número aleatorio mediante el método random.randint de la librería
    # random e indicamos que ese número se encuentre entre el 1 y el 50


numero = int(input("Introduce un número para el bingo "))
# Pedimos el número que se va a buscar por teclado

print(lista)

if (numero in (lista))== True: # Comprobamos mediante la palabra reservada in,
    # si el número introducido se encuentra en la lista, de así serlo
    # se imprimirá la palabra Bingo y por el contrario se imprimirá Has perdido
    print("Bingo")
else:
    print("Has perdido")

