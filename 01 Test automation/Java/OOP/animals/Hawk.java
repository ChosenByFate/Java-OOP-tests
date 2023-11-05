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
    public void run() {
        System.out.println(getName() + " is running.");
    }

    @Override
    public String voice() {
        return "Hawk's voice.";
    }
}
