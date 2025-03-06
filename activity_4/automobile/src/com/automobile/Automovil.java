package com.automobile;
public class Automovil {
    // Atributos
    private String color;
    private String carroceria;
    private String motor;
    private int potencia;
    private String transmision;
    private String tipoFrenos;
    private boolean encendido;

    // Constructor
    public Automovil(String color, String carroceria, String motor, int potencia, String transmision, String tipoFrenos) {
        this.color = color;
        this.carroceria = carroceria;
        this.motor = motor;
        this.potencia = potencia;
        this.transmision = transmision;
        this.tipoFrenos = tipoFrenos;
        this.encendido = false; 
    }

    // Métodos
    public void encender() {
        if (!encendido) {
            encendido = true;
            System.out.println("El automóvil ha sido encendido.");
        } else {
            System.out.println("El automóvil ya está encendido.");
        }
    }

    public void arrancar() {
        if (encendido) {
            System.out.println("El automóvil está arrancando.");
        } else {
            System.out.println("No puedes arrancar, el automóvil está apagado.");
        }
    }

    public void frenar() {
        System.out.println("El automóvil está frenando.");
    }

    public void transportar() {
        if (encendido) {
            System.out.println("El automóvil está transportando pasajeros o carga.");
        } else {
            System.out.println("El automóvil está apagado, no puede transportar.");
        }
    }

    // Método para mostrar la información del auto
    public void mostrarInfo() {
        System.out.println("Color: " + color);
        System.out.println("Carrocería: " + carroceria);
        System.out.println("Motor: " + motor);
        System.out.println("Potencia: " + potencia + " HP");
        System.out.println("Transmisión: " + transmision);
        System.out.println("Tipo de frenos: " + tipoFrenos);
    }
}

