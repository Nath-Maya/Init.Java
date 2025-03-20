public class Main {
    public static void main(String[] args) {
        RealEstateAgency agency = new RealEstateAgency();

        Property apt1 = new Apartment("Calle 75 ", 80, 100000, 10, 3);
        Property apt2 = new Apartment("Avenida 100", 60, 75000, 30, 2);
        Property loc1 = new Local("Centro Comercial", 55, 120000, 15, 5);
        Property loc2 = new Local("Barrio Ciudad country", 40, 90000, 28, 1);

        agency.addProperty(apt1);
        agency.addProperty(apt2);
        agency.addProperty(loc1);
        agency.addProperty(loc2);

        agency.showAllProperties();
    }
}