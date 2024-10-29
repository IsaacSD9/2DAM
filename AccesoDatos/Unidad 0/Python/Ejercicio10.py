n1= int(input("Introduce el primer número "))
n2= int(input("Introduce el segundo número "))

def mayor(n1, n2):
    if n1> n2:
        return n1
    else:
        return n2

print("El número mayor es ", mayor(n1,n2))
