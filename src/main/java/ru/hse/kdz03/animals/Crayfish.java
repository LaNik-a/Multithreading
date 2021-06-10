package ru.hse.kdz03.animals;

import ru.hse.kdz03.Cart;

/**
 * Животное - рак, имеющее функционал животного
 * и свой угол для перетегивания тележки
 */
public class Crayfish extends Animal {
    private static final double angleCrayfish = Math.toRadians(180);

    public Crayfish(double coefficient, Cart cart) {
        super(coefficient, cart, angleCrayfish);
    }


}
