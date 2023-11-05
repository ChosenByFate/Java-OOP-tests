package animals;

import aviary.AviarySize;

public class Fish extends animals.Carnivorous implements Swim {
    public Fish(){}

    public Fish(String name, AviarySize aviarySize) {
        setName(name);
        this.setAviarySize(aviarySize);
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming.");
    }

    @Override
    public void spin() {
        System.out.println(getName() + " is spinning.");
    }
}