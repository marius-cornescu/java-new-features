package org.jnew.features.j9.langandlib.language;

public interface PricedObject {
    // Private fields are not allowed
    // private double TAX = 1.21;

    double getPrice();

    default double getPriceWithTax() {
       return getTaxedPriceInternal();
    }

    default double getOfferPrice(double discount) {
        return getTaxedPriceInternal() * discount;
    }

    private double getTaxedPriceInternal() {
        return getPrice() * getTax();
    }

    private static double getTax() {
        return 1.21;
    }

    /* Before private interface methods, shared logic could not be extracted into a
       new method (at least not without it becoming part of the public API).

    default double getPriceWithTax() {
        return getPrice() * 1.21;
    }

    default double getOfferPrice(double discount) {
        return getPrice() * 1.21 * discount;
    }
    */
}
