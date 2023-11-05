package animals;

import exceptions.WrongFoodException;
import food.Food;
import aviary.AviarySize;

public abstract class Animal {
    private String name = "Unknown animal";
    private short hunger;
    private AviarySize aviarySize;

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

    public AviarySize getAviarySize() {
        return aviarySize;
    }

    public void setAviarySize(AviarySize aviarySize) {
        this.aviarySize = aviarySize;
    }

    public Animal(){
        hunger = 75;
    }

    public abstract void eat(Food food) throws WrongFoodException;

    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        return name.equals((String)obj);
    }
}