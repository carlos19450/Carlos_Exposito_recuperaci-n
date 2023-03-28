package Facturas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice {
    private List<InvoiceLine> line = new ArrayList<>();

    private int id;
    private Date date;
    private String shipTo;
    private Date dueDate;
    private Date deliveryDate;
    private String shippingTerms;
    private String to;
    private String shippingMethod;
    private String paymentTerms;
    private String salesPerson;
    private float discount;

    public Invoice(int id, Date date, String to, String shipTo, String salesPerson, String shippingMethod, String shippingTerms, Date deliveryDate, String paymentTerms, Date dueDate, float discount) {
        this.id = id;
        this.date = date;
        this.shipTo = shipTo;
        this.dueDate = dueDate;
        this.deliveryDate = deliveryDate;
        this.shippingTerms = shippingTerms;
        this.to = to;
        this.shippingMethod = shippingMethod;
        this.paymentTerms = paymentTerms;
        this.salesPerson = salesPerson;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getShipTo() {
        return shipTo;
    }

    public void setShipTo(String shipTo) {
        this.shipTo = shipTo;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getShippingTerms() {
        return shippingTerms;
    }

    public void setShippingTerms(String shippingTerms) {
        this.shippingTerms = shippingTerms;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(String salesPerson) {
        this.salesPerson = salesPerson;
    }

    public List<InvoiceLine> getLine() {
        return line;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void addInvoiceLine(InvoiceLine line) {
        this.line.add(line);
    }

    public void print() {
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\tInvoice number: " + getId());
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tDate: \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + getDate());
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tTO: " + getTo());
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tSHIP TO: " + getShipTo());
        System.out.println();

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t" + getSalesPerson() + "\t|"
                + "\t\t\t" + getSalesPerson() + "\t|"
                + "\t\t\t" + getSalesPerson() + "\t|"
                + "\t\t\t\t\t\t\t" + getSalesPerson() + "\t|"
                + "\t\t\t" + getSalesPerson() + "\t|"
                + "\t\t\t\t\t\t\t" + getSalesPerson() + "\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t" + getSalesPerson() + "\t|"
                + "\t\t\t\t\t\t" + getShippingMethod() + "\t|"
                + "\t\t\t" + getPaymentTerms() + "\t|"
                + "\t\t\t" + getDeliveryDate() + "\t|"
                + "\t\t\t" + getPaymentTerms() + "\t|"
                + "\t\t\t" + getDueDate() + "\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\tQTY\t|"
                + "\t\t\tItem #\t|"
                + "\t\t\t\t\t\tDESCRIPTION\t|"
                + "\t\t\tUNIT PRICE\t|"
                + "\t\tDISCOUNT\t|"
                + "\t\t\tLINE TOTAL\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        float precioFinal1 = 0;
        float precioFinal2 = 0;
        float preciosFinalesSumados = 0;
        for (InvoiceLine line : line) {
            if (line.getQty() == 5000) {
                precioFinal1 = (line.getUnitPrice() * line.getQty()) - ((line.getUnitPrice() * line.getQty()) * (line.getDiscount() / 100));

                System.out.println("|\t\t" + line.getQty() + "\t|"
                        + "\t\t\t" + line.getItem() + "\t|"
                        + "\t\t\t" + line.getDescription() + "\t|"
                        + "\t\t\t\t" + line.getUnitPrice() + "\t|"
                        + "\t\t\t" + line.getDiscount() + "\t|"
                        + "\t\t\t" + precioFinal1 + "\t|");
            }else {
                precioFinal2 = (line.getUnitPrice() * line.getQty()) - ((line.getUnitPrice() * line.getQty()) * (line.getDiscount() / 100));
                System.out.println("|\t\t\t" + line.getQty() + "\t|"
                        + "\t\t\t" + line.getItem() + "\t|"
                        + "\t\t\t" + line.getDescription() + "\t|"
                        + "\t\t\t\t" + line.getUnitPrice() + "\t|"
                        + "\t\t\t" + line.getDiscount() + "\t|"
                        + "\t\t\t\t" + precioFinal2 + "\t|");
            }
        }
        preciosFinalesSumados = precioFinal1 + precioFinal2;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t TOTAL DISCOUNT |");
        System.out.print("\t\t\t\t" + getDiscount() + "\t|");
        System.out.println("\t\t\t" + preciosFinalesSumados * (getDiscount() / 100) + "\t|");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-------------------------------------------------------------");
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t SUBTOTAL |");
        System.out.println("\t\t\t" + (preciosFinalesSumados - preciosFinalesSumados * (getDiscount() / 100)) + "\t|");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t---------------------------------");
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t GST  |");
        System.out.println("\t\t\t" + 192441.72 + "\t|");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t---------------------------------");
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    TOTAL |");
        System.out.println("\t\t" + ((preciosFinalesSumados - preciosFinalesSumados * (getDiscount() / 100)) + 192441.72) + "\t|");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t---------------------------------");

        System.out.println();

    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", date=" + date +
                ", shipTo='" + shipTo + '\'' +
                ", dueDate=" + dueDate +
                ", deliveryDate=" + deliveryDate +
                ", shippingTerms='" + shippingTerms + '\'' +
                ", to='" + to + '\'' +
                ", shippingMethod='" + shippingMethod + '\'' +
                ", paymentTerms='" + paymentTerms + '\'' +
                ", salesPerson='" + salesPerson + '\'' +
                ", discount=" + discount +
                '}';
    }
}
