package aviary;

import animals.Animal;

import java.util.HashMap;

public class Aviary<T> {
    private int aviarySize;
    private int aviaryFullness = 0;
    private HashMap<Integer, T> animals = new HashMap<>();

    public int getSize() {
        return aviarySize;
    }

    public int getAviaryFullness() {
        return aviaryFullness;
    }

    public void setAnimals(HashMap<Integer, T> animals) {
        this.animals = animals;
    }

    public T getAnimal(String name){
        return this.animals.get(name.hashCode());
    }

    public void setSize(int size) {
        if (animals.size() != 0) {
            System.out.println("You can't change aviary size while there are animals in it.");
            return;
        }
        this.aviarySize = size;
        System.out.println("New size: " + this.aviarySize);
    }

    public Aviary(int size){
        this.aviarySize = size;
    }

    public void addAnimal(T animal){
        final int animalSize = ((Animal)animal).getAviarySize().getSize();
        if (animalSize <= aviarySize - aviaryFullness) {
            if (this.animals.put(animal.hashCode(), animal) == null) {
                System.out.println("Adding animal with key: " + animal.hashCode());
                aviaryFullness += animalSize;
            }
            else
                System.out.println("Animal with key: " + animal.hashCode() + " already exists.");
        }
        else
            System.out.println("Not enough space in this aviary. Available: " + (aviarySize - aviaryFullness) +
                    "; animal size: " + animalSize);
    }

    public void removeAnimal(T animal){
        if (this.animals.remove(animal.hashCode()) != null) {
            aviaryFullness -= ((Animal)animal).getAviarySize().getSize();
            System.out.println("Removing animal with key: " + animal.hashCode());
        }
        else
            System.out.println("Animal with key: " + animal.hashCode() + " not found.");
    }

    public void removeAnimal(String name){
        T animal = getAnimal(name);
        if (animal != null) {
            if (this.animals.remove(animal.hashCode()) != null) {
                aviaryFullness -= ((Animal)animal).getAviarySize().getSize();
                System.out.println("Removing animal with key: " + animal.hashCode());
            }
            else
                System.out.println("Animal with key: " + animal.hashCode() + " not found.");
        }
        else
            System.out.println("Animal with name " + name + " does not exist.");
    }

    public int animalsCount() {
        return animals.size();
    }
}
