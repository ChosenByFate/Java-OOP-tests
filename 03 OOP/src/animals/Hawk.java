package animals;

public class Hawk extends Carnivorous implements Fly, Run, Voice {
    public Hawk(){}

    public Hawk(String name){
        setName(name);
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
    public String voice() {
        return "Hawk's voice.";
    }

    @Override
    public String cry() {
        return "Hawk's cry.";
    }
}
