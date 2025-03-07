
//Crear una clase estudiante, con los atributos nombre y calificación, y que implemente los métodos aprobo() el cual devuelve true o false si la calificación es mayor o menor a 3.0, y el método mostrarDatos() que imprime el nombre el estudiante y la nota y el estado de aprobación e.g. Camilo 3.0 aprobó. Crear otra clase PruebaEstuduante que cree una lista de estudiantes, solicite las notas y muestre por pantalla la información del listado de estudiantes.

public class Student {

    // Atributos
    private String nameStudent;
    private Float qualification;
    private boolean approvalStatus;

    // Constructor
    public Student(String nameStudent, Float qualification, String approvalStatus) {
        this.nameStudent = nameStudent;
        this.qualification = qualification;
        this.approvalStatus = false;
    }

    // Metodos
    public boolean approved(Float qualification) {
        if (qualification > 5.0) {
            System.out.println("Calificación no valida, debe ser menor o igual a 5.0");
            return false;
        }

        if (qualification >= 3.0) {
            System.out.println("Aprobado");
            return true;
        } else {
            System.out.println("Reprobado");
            return false;
        }
    }

    public void showData(String nameStudent, Float qualification, boolean approvalStatus) {
        System.out.println("Nombre Estudiante: " + nameStudent);
        System.out.println("Calificacion: " + qualification);
        System.out.println("Estado de aprobacion: " + (approvalStatus ? "Aprobado" : "Reprobado"));

    }

}
