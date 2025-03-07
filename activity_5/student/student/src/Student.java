


//Crear una clase estudiante, con los atributos nombre y calificación, y que implemente los métodos aprobo() el cual devuelve true o false si la calificación es mayor o menor a 3.0, y el método mostrarDatos() que imprime el nombre el estudiante y la nota y el estado de aprobación e.g. Camilo 3.0 aprobó. Crear otra clase PruebaEstuduante que cree una lista de estudiantes, solicite las notas y muestre por pantalla la información del listado de estudiantes.

public class Student {

    //Atributos
    private String nameStudent;
    private Float qualification;
    private boolean approvalStatus;

    //Constructor
    public Student(String nameStudent, Float qualification, String approvalStatus) {
        this.nameStudent = nameStudent;
        this.qualification = qualification;
        this.approvalStatus = false;
    }
    
}
