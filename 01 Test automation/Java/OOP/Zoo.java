import animals.*;
import food.*;

import java.util.Vector;

class Zoo {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{
                new Deer("Bambie"),
                new Duck("Flying duck"),
                new EurasianHoopoe("Bird"),
                new Fish("Piranha"),
                new Hawk("Hawkeye"),
                new Hyena()
        };

        Food[] foods = {
                new Meat("Worms", (short)3),
                new Grass("Cut grass", (short)11)
        };

        Worker jack = new Worker();

        for (Animal a :
                animals) {
            try {
                jack.getVoice((Voice)a);
            } catch (Exception e) {
                System.out.println(a.getName() + " don't talk.");
            }
        }

        System.out.println("_".repeat(50));
        for (Animal a :
                animals) {
            for (Food f :
                    foods) {
                jack.feed(a, f);
            }
        }

        System.out.println("_".repeat(50));
        Vector pond = new Vector();
        for (int i = 0; i < animals.length * 3; i++) {
            try {
                pond.add((Swim)animals[i%animals.length]);
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
        for (Object a :
                pond) {
            ((Swim)a).swim();
        }
    }
}