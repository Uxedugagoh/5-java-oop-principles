package com.example.task02;

public class DiscountBill extends Bill {
    // Предполагаю что скидка варьируется параметром от 0 до 1, например 0.5 - 50% скидка.
    private double discount;

    public DiscountBill(double discount) {
        this.discount = discount;
    }

    // Предполагаю что возвращать надо long потому что до этого также использовался long
    public long getDiscount() {
        return (long) (discount * 100);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public long getPrice() {
        return (long)(super.getPrice() * (1 - discount));
    }

    public long getAbsDiscount() {
        return super.getPrice() - this.getPrice();
    }
}
