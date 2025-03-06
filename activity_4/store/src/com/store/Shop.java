package com.store;
import java.util.ArrayList;
import java.util.List;

public class Shop {

    //Atributos
    private String name;
    private String address;
    private int phone;
    private String schedule;
    private List<String> cart; 

    //Constructor
    public Shop(String name, String address, int phone, String schedule) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.schedule = schedule;
        this.cart = new ArrayList<>(); 
    }

    //Metodos Getters y Setters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    
    public int getPhone() {
        return phone;
    }

    public String getSchedule() {
        return schedule;
    }

    //Metodos
    public void addToCart(String item) {
        cart.add(item);
        System.out.println(item + " ha sido agregado al carrito.");
    }

    public void showCart() {
        if (cart.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Artículos en el carrito: " + cart);
        }
    }
}
