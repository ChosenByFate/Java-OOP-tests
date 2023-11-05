package animals;

public class EurasianHoopoe extends Herbivore implements Fly, Run, Voice {
    public EurasianHoopoe(){}

    public EurasianHoopoe(String name){
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
        return "Eurasian hoopoe's voice.";
    }
}
