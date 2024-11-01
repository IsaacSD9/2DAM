package Ejercicio_9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio9 extends JFrame implements ActionListener {
    private HiloContador hiloPrimero, hiloSegundo;
    private JLabel estadoHiloPrimero, estadoHiloSegundo, contadorHiloPrimero, contadorHiloSegundo;
    private JButton btnIniciarContadores, btnInterrumpirHilo1, btnInterrumpirHilo2, btnDetenerContadores;

    public Ejercicio9() {
        // Configuración de la ventana principal
        setTitle("EJECUTAR E INTERRUMPIR HILOS");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Inicializar botones y etiquetas
        inicializarComponentes();

        // Añadir componentes a la ventana
        agregarComponentes();

        // Configurar eventos de botones
        configurarEventos();
    }

    private void inicializarComponentes() {
        // Inicializar botones
        btnIniciarContadores = new JButton("Comenzar Proceso");
        btnInterrumpirHilo1 = new JButton("Interrumpir");
        btnInterrumpirHilo2 = new JButton("Interrumpir");
        btnDetenerContadores = new JButton("Finalizar Proceso");

        // Inicializar etiquetas
        estadoHiloPrimero = new JLabel("HILO 1", JLabel.CENTER);
        estadoHiloSegundo = new JLabel("HILO 2", JLabel.CENTER);
        contadorHiloPrimero = new JLabel("", JLabel.CENTER);
        contadorHiloSegundo = new JLabel("", JLabel.CENTER);

        // Inicializar el estado de los botones
        btnInterrumpirHilo1.setEnabled(false);
        btnInterrumpirHilo2.setEnabled(false);
        btnDetenerContadores.setEnabled(false);
    }

    private void agregarComponentes() {
        // Usar GridBagLayout para posicionar los componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Primera fila: Botón Comenzar Proceso (posición central)
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(btnIniciarContadores, gbc);

        // Segunda fila: Botones Interrumpir
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(btnInterrumpirHilo1, gbc);

        gbc.gridx = 2;
        add(btnInterrumpirHilo2, gbc);

        // Tercera fila: Contadores
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(contadorHiloPrimero, gbc);

        gbc.gridx = 2;
        add(contadorHiloSegundo, gbc);

        // Cuarta fila: Estados de los hilos
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(estadoHiloPrimero, gbc);

        gbc.gridx = 2;
        add(estadoHiloSegundo, gbc);

        // Última fila: Botón Finalizar Proceso (posición central)
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(btnDetenerContadores, gbc);
    }

    private void configurarEventos() {
        btnIniciarContadores.addActionListener(this);
        btnInterrumpirHilo1.addActionListener(this);
        btnInterrumpirHilo2.addActionListener(this);
        btnDetenerContadores.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        // Controlar eventos de botones
        if (evento.getSource() == btnIniciarContadores) {
            iniciarContadores(); // Inicia los hilos
        } else if (evento.getSource() == btnInterrumpirHilo1) {
            hiloPrimero.interrumpir(); // Interrumpe el hilo 1
            estadoHiloPrimero.setText("Hilo1 Interrumpido"); // Actualizar estado
        } else if (evento.getSource() == btnInterrumpirHilo2) {
            hiloSegundo.interrumpir(); // Interrumpe el hilo 2
            estadoHiloSegundo.setText("Hilo2 Interrumpido"); // Actualizar estado
        } else if (evento.getSource() == btnDetenerContadores) {
            detenerContadores(); // Detiene ambos hilos
        }
    }

    private void iniciarContadores() {
        // Crear e iniciar hilos
        hiloPrimero = new HiloContador("Hilo 1", 1000, contadorHiloPrimero, estadoHiloPrimero);
        hiloSegundo = new HiloContador("Hilo 2", 1500, contadorHiloSegundo, estadoHiloSegundo);

        hiloPrimero.start(); // Iniciar el hilo 1
        hiloSegundo.start(); // Iniciar el hilo 2

        // Actualizar el estado de los botones
        btnIniciarContadores.setEnabled(false);
        btnInterrumpirHilo1.setEnabled(true);
        btnInterrumpirHilo2.setEnabled(true);
        btnDetenerContadores.setEnabled(true);
    }

    private void detenerContadores() {
        // Detener ambos hilos
        hiloPrimero.detener();
        hiloSegundo.detener();

        // Actualizar el estado en la interfaz
        estadoHiloPrimero.setText("Hilo1 Finalizado");
        estadoHiloSegundo.setText("Hilo2 Finalizado");

        // Desactivar botones de interrupción
        btnInterrumpirHilo1.setEnabled(false);
        btnInterrumpirHilo2.setEnabled(false);
        btnDetenerContadores.setEnabled(false);
    }

    class HiloContador extends Thread {
        private boolean interrumpido = false;
        private boolean detenido = false;
        private int valorContador = 0;
        private final int tiempoEspera; // Tiempo de espera para el hilo
        private JLabel etiquetaValor; // Etiqueta para mostrar el contador
        private JLabel estadoHilo; // Etiqueta para mostrar el estado

        public HiloContador(String nombre, int tiempoEspera, JLabel etiquetaValor, JLabel estadoHilo) {
            super(nombre); // Establecer el nombre del hilo
            this.tiempoEspera = tiempoEspera; // Tiempo de espera
            this.etiquetaValor = etiquetaValor; // Etiqueta del contador
            this.estadoHilo = estadoHilo; // Etiqueta del estado
        }

        public synchronized void interrumpir() {
            interrumpido = true; // Cambiar a estado interrumpido
        }

        public void detener() {
            detenido = true; // Cambiar a estado de detenido
            interrupt(); // Interrumpir el hilo
        }

        @Override
        public void run() {
            try {
                while (!detenido) { // Mientras no esté detenido
                    synchronized (this) {
                        if (interrumpido) { // Verificar si está interrumpido
                            estadoHilo.setText(getName() + " Interrumpido"); // Mostrar interrupción
                            wait(); // Esperar reanudación
                        }
                    }
                    valorContador++; // Incrementar el contador
                    etiquetaValor.setText(String.valueOf(valorContador)); // Actualizar etiqueta
                    estadoHilo.setText(getName() + " Corriendo"); // Actualizar estado
                    Thread.sleep(tiempoEspera); // Dormir el hilo
                }
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrumpido."); // Mensaje si el hilo es interrumpido
            }
            estadoHilo.setText(getName() + " Finalizado"); // Actualizar estado al finalizar
        }
    }

    public static void main(String[] args) {
        Ejercicio9 ventana = new Ejercicio9(); // Crear instancia de la ventana
        ventana.setVisible(true); // Hacer visible la ventana
    }
}
