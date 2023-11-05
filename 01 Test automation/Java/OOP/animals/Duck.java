package animals;

public class Duck extends animals.Herbivore implements Fly, Run, Swim, Voice {
    public Duck(){}

    public Duck(String name){
        setName(name);
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flying.");
    }

    @Override
    public void run() {
        System.out.println(getName() + " is running.");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming.");
    }

    @Override
    public String voice() {
        return "Duck's voice.";
    }
}
