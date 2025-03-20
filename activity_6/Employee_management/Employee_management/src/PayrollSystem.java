import java.util.ArrayList;
import java.util.Scanner;

// Clase base que representa una persona
abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String dni;
    protected String maritalStatus;

    public Person(String firstName, String lastName, String dni, String maritalStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.maritalStatus = maritalStatus;
    }

    public abstract double calculateSalary();
}

// Clase base para empleados
abstract class Employee extends Person {
    protected int yearOfIncorporation;
    protected String assignedTask;
    protected double baseSalary;

    public Employee(String firstName, String lastName, String dni, String maritalStatus, int yearOfIncorporation, String assignedTask, double baseSalary) {
        super(firstName, lastName, dni, maritalStatus);
        this.yearOfIncorporation = yearOfIncorporation;
        this.assignedTask = assignedTask;
        this.baseSalary = baseSalary;
    }
}

// Clase para Operarios
class Operator extends Employee {
    private int extraHours;
    private double extraHourRate;

    public Operator(String firstName, String lastName, String dni, String maritalStatus, int yearOfIncorporation, String assignedTask, double baseSalary, int extraHours, double extraHourRate) {
        super(firstName, lastName, dni, maritalStatus, yearOfIncorporation, assignedTask, baseSalary);
        this.extraHours = extraHours;
        this.extraHourRate = extraHourRate;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + (extraHours * extraHourRate);
    }
}

// Clase para Secretarias
class Secretary extends Employee {
    public Secretary(String firstName, String lastName, String dni, String maritalStatus, int yearOfIncorporation, String assignedTask, double baseSalary) {
        super(firstName, lastName, dni, maritalStatus, yearOfIncorporation, assignedTask, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}

// Clase para Gerentes
class Manager extends Employee {
    private double performanceBonus;

    public Manager(String firstName, String lastName, String dni, String maritalStatus, int yearOfIncorporation, String assignedTask, double baseSalary, double performanceBonus) {
        super(firstName, lastName, dni, maritalStatus, yearOfIncorporation, assignedTask, baseSalary);
        this.performanceBonus = performanceBonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + performanceBonus;
    }
}

// Clase principal para gestionar la nómina
public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.print("Ingrese el numero de empleados a registrar: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\nEmpleado #" + (i + 1));
            System.out.print("Ingrese el tipo de empleado (1. Operario, 2. Secretaria, 3. Gerente): ");
            int type = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Nombre: ");
            String firstName = scanner.nextLine();
            System.out.print("Apellidos: ");
            String lastName = scanner.nextLine();
            System.out.print("DNI: ");
            String dni = scanner.nextLine();
            System.out.print("Estado civil: ");
            String maritalStatus = scanner.nextLine();
            System.out.print("Año de incorporacion: ");
            int yearOfIncorporation = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Tarea asignada: ");
            String assignedTask = scanner.nextLine();
            System.out.print("Salario base: ");
            double baseSalary = scanner.nextDouble();

            if (type == 1) {
                System.out.print("Horas extra trabajadas: ");
                int extraHours = scanner.nextInt();
                System.out.print("Valor por hora extra: ");
                double extraHourRate = scanner.nextDouble();
                employees.add(new Operator(firstName, lastName, dni, maritalStatus, yearOfIncorporation, assignedTask, baseSalary, extraHours, extraHourRate));
            } else if (type == 2) {
                employees.add(new Secretary(firstName, lastName, dni, maritalStatus, yearOfIncorporation, assignedTask, baseSalary));
            } else if (type == 3) {
                System.out.print("Bonificacion por rendimiento: ");
                double performanceBonus = scanner.nextDouble();
                employees.add(new Manager(firstName, lastName, dni, maritalStatus, yearOfIncorporation, assignedTask, baseSalary, performanceBonus));
            }
        }

        System.out.println("\n--- Nomina de la empresa ---");
        double totalPayroll = 0;
        for (Employee e : employees) {
            double salary = e.calculateSalary();
            totalPayroll += salary;
            System.out.println(e.firstName + " " + e.lastName + " - Salario: $" + salary);
        }
        System.out.println("Total a pagar en nomina: $" + totalPayroll);

        scanner.close();
    }
}
