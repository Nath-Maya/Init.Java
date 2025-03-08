import java.util.ArrayList;

public class TestStudent {

    private static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(Student student) {
        students.add(student);
        System.out.println("Se agrego estudiante: " + student.getNameStudent());
        ;
    }

    public static void showListStudents() {
        System.out.println("\nLista de estudiantes:");
        for (Student s : students) {
            s.showData();
        }
    }

}