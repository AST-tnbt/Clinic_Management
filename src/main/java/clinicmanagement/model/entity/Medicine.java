package clinicmanagement.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Medicine {
    private int id;
    private String name;
    private LocalDate importDate;
    private BigDecimal price;
    private LocalDate expireDate;
    private int inventoryQuantity;

    public Medicine(int id, String name, LocalDate importDate, BigDecimal price, LocalDate expireDate, int inventoryQuantity) {
        this.id = id;
        this.name = name;
        this.importDate = importDate;
        this.price = price;
        this.expireDate = expireDate;
        this.inventoryQuantity = inventoryQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }
}
