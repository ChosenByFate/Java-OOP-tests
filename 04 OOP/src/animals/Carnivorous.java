package animals;

import exceptions.WrongFoodException;
import food.Food;
import food.Meat;

public abstract class Carnivorous extends animals.Animal {
    @Override
    public void eat(Food food) throws WrongFoodException {
        if (food instanceof Meat) {
            setHunger((short)(food.getCalorie() + getHunger()));
            System.out.println(getName() + " is eating " + food.getName() + ".");
        }
        else
            throw new WrongFoodException("Exception! " + getName() + " don't like " + food.getName() + ".");
    }
}