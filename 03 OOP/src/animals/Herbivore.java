package animals;

import food.Food;
import food.Grass;

public abstract class Herbivore extends animals.Animal {
    @Override
    public void eat(Food food){
        if (food instanceof Grass){
            setHunger((short)(food.getCalorie() + getHunger()));
            System.out.println(getName() + " is eating " + food.getName() + ".");
        }
        else
            System.out.println(getName() + " don't like " + food.getName() + ".");
    }
}