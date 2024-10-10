public class Oder extends User {
    private String username;
    private String itemName;
    private int quantity;

    public Oder(String username, String itemName, int quantity) {
        this.username = username;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getUsername() {
        return username;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

}
