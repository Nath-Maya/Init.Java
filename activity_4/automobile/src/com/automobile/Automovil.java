package com.automobile;
public class Automovil {
    // Atributos
    private String marca;
    private String color;
    private String carroceria;
    private String motor;
    private int potencia;
    private String transmision;
    private String tipoFrenos;
    private boolean encendido;

    // Constructor
    public Automovil(String marca, String color, String carroceria, String motor, int potencia, String transmision, String tipoFrenos) {
        this.marca = marca;
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
            System.out.println("El auto ha sido encendido.");
        } else {
            System.out.println("El auto ya esta prendido.");
        }
    }

    public void arrancar() {
        if (encendido) {
            System.out.println("El auto está arrancando.");
        } else {
            System.out.println("Carro apagado, no se puede arrancar.");
        }
    }

    public void frenar() {
        System.out.println("El auto esta deteniendose.");
    }

    public void transportar() {
        if (encendido) {
            System.out.println("El auto está transportando pasajeros o carga.");
        } else {
            System.out.println("El auto está apagado, no puede transportar.");
        }
    }

    // Método para mostrar datos del auto
    public void mostrarInfo() {
        System.out.println("Marca: " + marca);
        System.out.println("Color: " + color);
        System.out.println("Tipo de Carroceria: " + carroceria);
        System.out.println("Motor: " + motor);
        System.out.println("Potencia: " + potencia + " HP");
        System.out.println("Transmision: " + transmision);
        System.out.println("Tipo de frenos: " + tipoFrenos);
    }
}

