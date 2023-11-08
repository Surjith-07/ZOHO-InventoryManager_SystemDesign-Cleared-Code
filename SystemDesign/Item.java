import java.util.*;

public class Item {
    private int ItemId;
    private String name;
    private double price;
    private int quantity;

    Item() {
    }

    Item(int ItemId, String name, double price, int quantity) {
        this.ItemId = ItemId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setItemId(int id) {
        ItemId = id;
    }

    public void setItemname(String val) {
        name = val;
    }

    public void setprice(double val) {
        price = val;
    }

    public void setquantity(int quan) {
        quantity = quan;
    }

    public int getItemId() {
        return ItemId;
    }

    public String getItemname() {
        return name;
    }

    public int getItemquantity() {
        return quantity;
    }

    public double getItemprice() {
        return price;
    }

    public void display() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("ItemId : " + ItemId + "\n" + "Itemname : " + name + "\n" + "price : " + price + "\n"
                + "quantity : " + quantity + "\n");
    }

}
