package model;

public class Kotik {

    private static char catsCount = 0;
    private int hunger = 100;
    private int prettiness;
    private String name;
    private int weight;
    private String meow;

    public static char getCatsCount() {
        return catsCount;
    }

    public int getHunger() {
        return hunger;
    }

    public int getPrettiness() {
        return prettiness;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getMeow() {
        return meow;
    }

    public Kotik() {
        ++catsCount;
        System.out.println("Meow!");
    }

    public Kotik(int prettiness, String name, int weight, String meow) {
        ++catsCount;
        this.prettiness = prettiness;
        this.name = name;
        this.weight = weight;
        this.meow = meow;
        System.out.println(meow);
    }

    protected void finalize() {
        --catsCount;
        System.out.println("One of them died.");
    }

    public void setKotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = (int)prettiness;
        this.name = name;
        this.weight = (int)weight;
        this.meow = meow;
    }

    static private boolean checkSatiety(int hunger, String name) {
        if (hunger <= 0b1010) {
            System.out.println("The cat " + name + " is hungry. :\\");
            return false;
        }
        return true;
    }

    public void eat() {
        eat((int)(Math.random()*10+25), "Mixed feed");
    }

    public void eat(int satiety) {
        System.out.println("The cat " + name + " is eating.");
        hunger += satiety;
    }

    public void eat(int satiety, String foodName) {
        System.out.println("The cat " + name + " is eating " + foodName + ".");
        hunger += satiety;
    }

    public boolean play() {
        if (!checkSatiety(hunger, name)) {
            --hunger;
            return false;
        }
        System.out.println("The cat " + name + " is playing.");
        hunger -= (int)(Math.random()*4+5);
        return true;
    }
    public boolean sleep() {
        if (!checkSatiety(hunger, name)) {
            --hunger;
            return false;
        }
        System.out.println("The cat " + name + " is sleeping.");
        hunger -= (int)(Math.random()*4+5);
        return true;
    }
    public boolean chaseMouse() {
        if (!checkSatiety(hunger, name)) {
            --hunger;
            return false;
        }
        System.out.println("The cat " + name + " is chasing the mouse.");
        hunger -= (int)(Math.random()*4+5);
        if (Math.random() > 0.90) {
            System.out.println("Success!");
            hunger += (int)0b0001_1000;
        }else {
            System.out.println("Couldn't catch the mouse!");
        }
        return true;
    }

    public boolean doSomethingIncomprehensible() {
        if (!checkSatiety(hunger, name)) {
            --hunger;
            return false;
        }
        System.out.println("The cat " + name + " is doing something incomprehensible!");
        hunger -= (int)(Math.random()*4+5);
        return true;
    }

    public void liveAnotherDay() {
        int randValue;
        boolean wellFed = true;
        for (int i = 0; i < 24; i++) {
            randValue = (int)(Math.random()*3);
            switch (randValue) {
                case (int)0:
                    wellFed = play();
                    break;
                case (int)1:
                    wellFed = sleep();
                    break;
                case (int)2:
                    wellFed = chaseMouse();
                    break;
                case (int)3:
                    wellFed = doSomethingIncomprehensible();
                    break;
            }
            System.out.println("Well-fed: "+hunger+".");
            if (hunger <= 0) {
                finalize();
                System.gc();
                return;
            }
            if (!wellFed) {
                eat();
                wellFed = true;
            }
        }
    }
}
