
//Crear una clase Motocicleta, a través de la cual se pueda conocer el color del       Motocicleta, la marca, el modelo, consumo de combustible por km, total de distancia recorrida, capacidad de combustible máximo y nivel de combustible en litros. Crear el constructor de Motocicleta cree un método double run(int distancia), el cual recibe como parámetros la distancia que va a recorrer la moto y como salida deberá devolver el máximo de kilómetros que quede recorrer con el combustible actual y aumente los kilómetros recorridos teniendo en cuenta el combustible consumido y el nivel actual e implementar el método  Int fillTank(int litros) que permitirá llenar el tanque de combustible hasta un máximo devolviendo los litros restantes en caso de que se pase del máximo.
//Crear una clase PruebaMotocicleta que instancie una moto en la que se evidencia el uso de los métodos por medio de un menú que permita: andar y llenar tanque.



public class Motorcycle {

    //Atributos
    private String color;
    private String brand;
    private int model;
    private double fuelConsumptionPerKm;
    private double totalDistance;
    private double maxFuelCapacity;
    private double currentFuelLevel;

    //Constructor
    public Motorcycle(String color, String brand, int model, double fuelConsumptionPerKm, double totalDistance,
            double maxFuelCapacity, double currentFuelLevel) {
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.totalDistance = totalDistance;
        this.maxFuelCapacity = maxFuelCapacity;
        this.currentFuelLevel = currentFuelLevel;
    }






    
}
