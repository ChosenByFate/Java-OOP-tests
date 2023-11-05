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
                new Chicken("Chicken meat", (short)10),
                new Pork("Pork meat", (short)15),
                new Rye("Cut grass", (short)13),
                new Wheat("Wheat", (short)11)
        };

        Worker jack = new Worker();

        for (Animal a :
                animals) {
            try {
                if ((int)(Math.random() * 2) == 0)
                    jack.getVoice((Voice)a);
                else
                    jack.getCry((Voice)a);
            } catch (Exception e) {
                System.out.println(a.getName() + " don't talk.");
            }
        }

        System.out.println("__________________________________________________");
        for (Animal a :
                animals) {
            for (Food f :
                    foods) {
                jack.feed(a, f);
            }
        }

        System.out.println("__________________________________________________");
        Vector pond = new Vector();
        for (int i = 0; i < animals.length * 3; i++) {
            try {
                pond.add((Swim)animals[i%animals.length]);
            } catch (Exception e) {
            }
        }
        for (Object a :
                pond) {
            if ((int)(Math.random() * 2) == 0)
                ((Swim)a).swim();
            else
                ((Swim)a).spin();

        }

        System.out.println("__________________________________________________");
        for (Animal a:
             animals) {
            try {
                if ((int)(Math.random() * 2) == 0)
                    ((Run)a).run();
                else
                    ((Run)a).runAround();
            } catch (Exception e) {
            }
            try {
                if ((int)(Math.random() * 2) == 0)
                    ((Fly)a).fly();
                else
                    ((Fly)a).goDown();
            } catch (Exception e) {
            }
        }
    }
}