public class App {
    public static void main(String[] args) {
        Shop tienda = new Shop("Variedades Nathalia", "Calle 75# 7 tbis 05 ", 320808776, "9 AM - 9 PM");

        tienda.addToCart("Iphone");
        tienda.addToCart("Teclado");
        tienda.showCart();
    }
}
