package animals;

public class Hyena extends Carnivorous implements Run, Voice {
    public Hyena(){}

    public Hyena(String name){
        setName(name);
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
        return "Hyena's voice.";
    }

    @Override
    public String cry() {
        return "Hyena's cry.";
    }
}
