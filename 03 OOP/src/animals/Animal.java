package animals;

import food.Food;

public abstract class Animal {
    private String name = "Unknown animal";
    private short hunger;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getHunger() {
        return hunger;
    }

    public void setHunger(short hunger) {
        this.hunger = hunger;
    }

    public Animal(){
        hunger = 75;
    }

    public abstract void eat(Food food);

}