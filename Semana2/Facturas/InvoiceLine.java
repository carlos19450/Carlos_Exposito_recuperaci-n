package Facturas;

public class InvoiceLine {
    private int qty;
    private String item;
    private String description;
    private float unitPrice;
    private float discount;

    public InvoiceLine(int qty, String item, String description, float unitPrice, float discount) {
        this.qty = qty;
        this.item = item;
        this.description = description;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "InvoiceLine{" +
                "qty=" + qty +
                ", item='" + item + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", discount=" + discount +
                '}';
    }
}
