package animals;

import aviary.AviarySize;

public class Duck extends animals.Herbivore implements Fly, Run, Swim, Voice {
    public Duck(){}

    public Duck(String name, AviarySize aviarySize) {
        setName(name);
        this.setAviarySize(aviarySize);
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flying.");
    }

    @Override
    public void goDown() {
        System.out.println(getName() + " is going down.");
    }

    @Override
    public void run() {
        System.out.println(getName() + " is running.");
    }

    @Override
    public void runAround() {
        System.out.println(getName() + " is running around.");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming.");
    }

    @Override
    public void spin() {
        System.out.println(getName() + " is spinning.");
    }

    @Override
    public String voice() {
        return "Duck's voice.";
    }

    @Override
    public String cry() {
        return "Duck's cry.";
    }
}
