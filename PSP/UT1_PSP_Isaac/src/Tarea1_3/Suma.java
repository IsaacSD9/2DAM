package Tarea1_3;

import java.util.Scanner;

public class Suma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = 0;
        int n2= 0;

        if(scanner.hasNextInt()) {
            n1 = scanner.nextInt();
            System.out.println("El primer numero es: " + n1);
        }
        else{
            System.out.println("Introduce un numero entero");
        }
        if(scanner.hasNextInt()) {
            n2 = scanner.nextInt();
            System.out.println("El segundo numero es: " + n2);

        }else{
            System.out.println("Introduce un numero entero");
        }
        scanner.close();
        int resultado = n1 + n2;
        System.out.println("El resultado de la suma es: " + resultado);
    }
    }
