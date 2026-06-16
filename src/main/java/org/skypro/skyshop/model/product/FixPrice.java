package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPrice extends Product {
    private final static int PRICE = 300;

    public FixPrice(UUID id, String name) {
        super(id, name);
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public String toString() {
        return getName() + " : Фиксированная цена " + PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}