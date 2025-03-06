package com.automobile;
public class App {
        public static void main(String[] args) {
            Automovil miAuto = new Automovil("Gris", "Sedan", "V6", 300, "Automatica", "ABS");
    
            miAuto.mostrarInfo();
            miAuto.encender();
            miAuto.arrancar();
            miAuto.transportar();
            miAuto.frenar();
        }
    
}
