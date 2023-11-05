package animals;

import food.Food;
import food.Meat;

public abstract class Carnivorous extends animals.Animal {
    @Override
    public void eat(Food food){
        if (food instanceof Meat) {
            setHunger((short)(food.getCalorie() + getHunger()));
            System.out.println(getName() + " is eating " + food.getName() + ".");
        }
        else
            System.out.println(getName() + " don't like " + food.getName() + ".");
    }
}