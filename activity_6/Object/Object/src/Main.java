public class Main {
    public static void main(String[] args) {
        // Crear instancias de cada clase
        Person p1 = new Person();
        Provider pr1 = new Provider();
        Customer c1 = new Customer();
        @SuppressWarnings("unused")
        Object obj = new Object();

        // ASIGNACIONES VALIDAS
        p1 = pr1;  // Válido porque Provider es un Person
        p1 = c1;   // Válido porque Customer es un Person
        obj = p1;   // Válido porque cualquier objeto es un Object
        obj = c1;   // Válido porque Customer también es un Object
        obj = pr1;  // Válido porque Provider también es un Object

        //ASIGNACIONES NO VALIDAS
        // pr1 = p1;  /
        // c1 = p1;   

    }
}

// CLASES DEFINIDAS
class Person {
    String Name;
    String Lastname;
}

class Customer extends Person {
}

class Provider extends Person {
}
