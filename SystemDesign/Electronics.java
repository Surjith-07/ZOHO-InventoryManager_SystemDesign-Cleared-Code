public class Electronics extends Item {
    String description;

    Electronics(int ItemId, String name, double price, int quantity) {
        super(ItemId, name, price, quantity);
        this.description = "Electronical Section";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String name) {
        description = name;
    }

}
