
//Crear una clase estudiante, con los atributos nombre y calificación, y que implemente los métodos aprobo() el cual devuelve true o false si la calificación es mayor o menor a 3.0, y el método mostrarDatos() que imprime el nombre el estudiante y la nota y el estado de aprobación e.g. Camilo 3.0 aprobó. Crear otra clase PruebaEstuduante que cree una lista de estudiantes, solicite las notas y muestre por pantalla la información del listado de estudiantes.

public class Student {

    // Atributos
    private String nameStudent;
    private Double qualification;
    private boolean approvalStatus;

    // Constructor
    public Student(String nameStudent, double qualification) {

        if (qualification > 5.0) {
            System.out.println(Colors.YELLOW + "Calificacion sobrepasa el valor maximo de 5.0, debe ser menor a 5.0"
                    + Colors.RESET);
            throw new IllegalArgumentException("Calificacion fuera de rango.");

        }
        this.nameStudent = nameStudent;
        this.qualification = qualification;
        this.approvalStatus = approved(qualification);
        TestStudent.addStudent(this);
    }

    // Metodos

    public String getNameStudent() {
        return nameStudent;
    }
    public boolean approved(Double qualification) {
        return qualification >= 3.0;
    }

    public void showData() {

        System.out.println("Nombre Estudiante: " + nameStudent);
        System.out.println("Calificacion: " + qualification);
        System.out.println(
                "Estado de aprobacion: " + (approvalStatus ? Colors.GREEN + "Aprobado" + Colors.RESET
                        : Colors.RED + "Reprobado" + Colors.RESET));

    }

}
