package ru.hse.kdz03.animals;


import ru.hse.kdz03.Cart;

/**
 * Животное - лебедь, имеющее функционал животного
 * и свой угол для перетегивания тележки
 */
public class Swan extends Animal {
    private static final double angleSwan = Math.toRadians(60);

    public Swan(double coefficient, Cart cart) {
        super(coefficient, cart, angleSwan);
    }

}
