package animals;

public class Fish extends animals.Carnivorous implements Swim {
    public Fish(){}

    public Fish(String name){
        setName(name);
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming.");
    }
}