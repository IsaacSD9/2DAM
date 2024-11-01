package Tarea2_5;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contador_Applet extends Applet implements ActionListener {
    // Definimos los hilos y botones del applet
    private HiloContador hiloContador1, hiloContador2;
    private Button botonFinalizarHilo1, botonFinalizarHilo2;

    public void init() {
        // Inicializamos los botones para finalizar cada hilo y los añadimos al applet
        botonFinalizarHilo1 = new Button("Finalizar Hilo 1");
        add(botonFinalizarHilo1);
        botonFinalizarHilo2 = new Button("Finalizar Hilo 2");
        add(botonFinalizarHilo2);

        // Registramos los botones para escuchar eventos de acción
        botonFinalizarHilo1.addActionListener(this);
        botonFinalizarHilo2.addActionListener(this);
    }

    public void start() {
        // Creamos e iniciamos los hilos, con contadores en diferentes valores iniciales
        hiloContador1 = new HiloContador(100);
        hiloContador1.start();
        hiloContador2 = new HiloContador(120);
        hiloContador2.start();

    }

    public void paint(Graphics g) {
        // Dibujamos el estado de cada hilo en la pantalla
        if (hiloContador1 != null && hiloContador1.estaEnEjecucion()) {
            g.drawString("Hilo1: " + hiloContador1.obtenerContador(), 50, 100);
        } else {
            g.drawString("Hilo1: Finalizado", 50, 100);
        }
        if (hiloContador2 != null && hiloContador2.estaEnEjecucion()) {
            g.drawString("Hilo2: " + hiloContador2.obtenerContador(), 50, 120);
        } else {
            g.drawString("Hilo2: Finalizado", 50, 120);
        }
    }

    public void actionPerformed(ActionEvent evento) {
        // Verificamos si se ha pulsado el botón para finalizar Hilo 1
        if (evento.getSource() == botonFinalizarHilo1 && hiloContador1 != null && hiloContador1.estaEnEjecucion()) {
            hiloContador1.detenerHilo(); // Finalizamos el hilo modificando la variable de control
            botonFinalizarHilo1.setLabel("Finalizado Hilo1");
        }

        // Verificamos si se ha pulsado el botón para finalizar Hilo 2
        if (evento.getSource() == botonFinalizarHilo2 && hiloContador2 != null && hiloContador2.estaEnEjecucion()) {
            hiloContador2.detenerHilo(); // Finalizamos el hilo modificando la variable de control
            botonFinalizarHilo2.setLabel("Finalizado Hilo2");
        }

        // Redibujamos la pantalla para actualizar el estado de los hilos
        repaint();
    }

    // Clase interna que representa un contador en un hilo separado
    class HiloContador extends Thread {
        private int contador;
        private volatile boolean enEjecucion = true; // Variable de control para mantener el hilo activo

        public HiloContador(int valorInicial) {
            this.contador = valorInicial;
        }


        public int obtenerContador() {
            return contador;
        }

        public void detenerHilo() {
            enEjecucion = false; // Cambiamos la variable de control para finalizar el hilo
            interrupt(); // Interrumpimos el hilo para que salga de cualquier espera
        }

        public void run() {
            // Incrementamos el contador mientras el hilo esté en ejecución
            while (enEjecucion) {
                contador++;
                try {
                    // Hacemos una pausa de 1 segundo entre cada incremento
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restauramos el estado de interrupción del hilo
                    break; // Salimos del bucle si el hilo ha sido interrumpido
                }
                repaint(); // Redibujamos el applet para actualizar el contador visualmente
            }
        }


        public boolean estaEnEjecucion() {
            return enEjecucion;
        }
    }
}
