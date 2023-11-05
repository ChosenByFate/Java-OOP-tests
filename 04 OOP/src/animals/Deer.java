package animals;

import aviary.AviarySize;

public class Deer extends Herbivore implements Run, Voice {
    public Deer(){}

    public Deer(String name, AviarySize aviarySize) {
        setName(name);
        this.setAviarySize(aviarySize);
    }

    @Override
    public void run() {
        setHunger((short)(getHunger() - 5));
        System.out.println(getName() + " is running.");
    }

    @Override
    public void runAround() {
        System.out.println(getName() + " is running around.");
    }

    @Override
    public String voice() {
        return "Deer's voice.";
    }

    @Override
    public String cry() {
        return "Deer's voice.";
    }
}
