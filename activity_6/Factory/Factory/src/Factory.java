public class Factory {
    private Factory() {} 

    public static Media create(int type) {
        System.out.println("Bienvenido al Factory de Media!");
        Media aux = null;
        if (type == 1) {
            aux = new Video();
        } else if (type == 2) {
            aux = new Audio();
        }
        if (aux != null) aux.readMediaData();
        return aux;
    }
}
