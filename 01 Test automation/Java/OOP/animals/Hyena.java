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
    public String voice() {
        return "Hyena's voice.";
    }
}
