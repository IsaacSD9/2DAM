numero = int(input("Escribe el número para ver su tabla de multiplicar: "))
for i in range (1, 11):
    numero_multiplicado = numero * i
    print(numero, "*", i, "=", numero_multiplicado)
