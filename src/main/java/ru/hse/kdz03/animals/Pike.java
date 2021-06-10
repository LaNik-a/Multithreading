package ru.hse.kdz03.animals;

import ru.hse.kdz03.Cart;

/**
 * Животное - щука, имеющее функционал животного
 * и свой угол для перетегивания тележки
 */
public class Pike extends Animal {
    private static final double anglePike = Math.toRadians(300);

    public Pike(double coefficient, Cart cart) {
        super(coefficient, cart, anglePike);
    }


}
