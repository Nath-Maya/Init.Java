
//Crear una clase Motocicleta, a través de la cual se pueda conocer el color del       Motocicleta, la marca, el modelo, consumo de combustible por km, total de distancia recorrida, capacidad de combustible máximo y nivel de combustible en litros. Crear el constructor de Motocicleta cree un método double run(int distancia), el cual recibe como parámetros la distancia que va a recorrer la moto y como salida deberá devolver el máximo de kilómetros que quede recorrer con el combustible actual y aumente los kilómetros recorridos teniendo en cuenta el combustible consumido y el nivel actual e implementar el método  Int fillTank(int litros) que permitirá llenar el tanque de combustible hasta un máximo devolviendo los litros restantes en caso de que se pase del máximo.
//Crear una clase PruebaMotocicleta que instancie una moto en la que se evidencia el uso de los métodos por medio de un menú que permita: andar y llenar tanque.


public class Motorcycle {

    // Atributos
    private String color;
    private String brand;
    private int model;
    private double fuelConsumptionPerKm;
    private double totalDistance;
    private double maxFuelCapacity;
    private double fuelLevel;

    // Constructor
    public Motorcycle(String color, String brand, int model, double fuelConsumptionPerKm, double maxFuelCapacity, double currentFuelLevel) {
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.totalDistance = 0; 
        this.maxFuelCapacity = maxFuelCapacity;
        this.fuelLevel = Math.min(currentFuelLevel, maxFuelCapacity);
    }

    // Metodo para recorrer distancia
    public double run(int distancia) {
        double maxKmPosibles = fuelLevel / fuelConsumptionPerKm; 
        
        if (distancia > maxKmPosibles) {
            distancia = (int) maxKmPosibles; 
        }

        double combustibleConsumido = distancia * fuelConsumptionPerKm;
        fuelLevel -= combustibleConsumido;
        totalDistance += distancia;

        return fuelLevel / fuelConsumptionPerKm; 
    }

    // Metodo para llenado de tanque
    public int fillTank(int litros) {
        double newFuelLevel = fuelLevel + litros;

        if (newFuelLevel > maxFuelCapacity) {
            int sobrante = (int) (newFuelLevel - maxFuelCapacity);
            fuelLevel = maxFuelCapacity;
            return sobrante; 
        } else {
            fuelLevel = newFuelLevel;
            return 0; 
        }
    }

    
    public void showData() {
        System.out.println("Marca: " + brand);
        System.out.println("Modelo: " + model);
        System.out.println("Color: " + color);
        System.out.println("Capacidad Max. de Combustible: " + maxFuelCapacity + " litros");
        System.out.println("Nivel Actual de Combustible: " + fuelLevel + " litros");
        System.out.println("Consumo por Km: " + fuelConsumptionPerKm + " litros/km");
        System.out.println("Distancia Total Recorrida: " + totalDistance + " km");
        System.out.println("Km restantes con el combustible actual: " + (fuelLevel / fuelConsumptionPerKm) + " km");
    }
}






    

