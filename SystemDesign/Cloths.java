public class Cloths extends Item {
    String description;

    Cloths(int ItemId, String name, double price, int quantity) {
        super(ItemId, name, price, quantity);
        this.description = "Dress Section";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String name) {
        description = name;
    }
}
