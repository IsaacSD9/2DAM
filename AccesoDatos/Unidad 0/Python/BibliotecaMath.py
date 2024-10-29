import math
# Importamos la librería math para utilizar las funciones matemáticas
numero = input("Introduce un número por favor ");
# Pedimos el número por teclado que se almacena como cadena de texto
numero_float = float(numero);
# Creamos una nueva variable en la que se almacena la cadena de texto de la variable numero pero cambiada a tipo float, es decir, convertida en número
raiz_cuadrada = math.sqrt(numero_float);
print("La raíz cuadrada es: " , raiz_cuadrada);
