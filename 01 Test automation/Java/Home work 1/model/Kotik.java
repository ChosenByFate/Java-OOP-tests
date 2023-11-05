package model;

//https://stackoverflow.com/questions/1927107/define-in-java
//https://stackoverflow.com/questions/1195206/is-there-a-java-equivalent-or-methodology-for-the-typedef-keyword-in-c
//jTrash.

public class Kotik {

    private static char catsCount = 0;
    private byte hunger = 0b0110_0100; // 0b1111_1111. jTrash.
    private byte prettiness;
    private String name;
    private byte weight;
    private String meow;

    public static char getCatsCount() {
        return catsCount;
    }

    public byte getHunger() {
        return hunger;
    }

    public byte getPrettiness() {
        return prettiness;
    }

    public String getName() {
        return name;
    }

    public byte getWeight() {
        return weight;
    }

    public String getMeow() {
        return meow;
    }

    public Kotik() {
        ++catsCount;
        System.out.println("Meow!");
    }

    public Kotik(byte prettiness, String name, byte weight, String meow) {
        ++catsCount;
        this.prettiness = prettiness;
        this.name = name;
        this.weight = weight;
        this.meow = meow;
        System.out.println(meow);
    }

//    https://ru.stackoverflow.com/questions/249241/%D0%94%D0%B5%D1%81%D1%82%D1%80%D1%83%D0%BA%D1%82%D0%BE%D1%80-%D0%B2-java
//    public ~Kotik() {  //jTrash.
//        --catsCount
//    }

    protected void finalize() {
        --catsCount;
        System.out.println("One of them died.");
    }

    public void setKotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = (byte)prettiness;
        this.name = name;
        this.weight = (byte)weight;
        this.meow = meow;
    }

    static private boolean checkSatiety(byte hunger, String name) {
        if (hunger <= 0b1010) {
            System.out.println("The cat " + name + " is hungry. :\\");
            return false;
        }
        return true;
    }

    public void eat() {
//        System.out.println("The cat " + name + " is eating.");
        eat((byte)(Math.random()*10+25), "Mixed feed");
    }

    public void eat(byte satiety) {
        System.out.println("The cat " + name + " is eating.");
        hunger += satiety;
    }

    public void eat(byte satiety, String foodName) {
        System.out.println("The cat " + name + " is eating " + foodName + ".");
        hunger += satiety;
    }

    public boolean play() {
        if (!checkSatiety(hunger, name)) {
            --hunger;   //jTrash
            return false;
        }
        System.out.println("The cat " + name + " is playing.");
        hunger -= (byte)(Math.random()*4+5);
        return true;
    }
    public boolean sleep() {
        if (!checkSatiety(hunger, name)) {
            --hunger;   //jTrash
            return false;
        }
        System.out.println("The cat " + name + " is sleeping.");
        hunger -= (byte)(Math.random()*4+5);
        return true;
    }
    public boolean chaseMouse() {
        if (!checkSatiety(hunger, name)) {
            --hunger;   //jTrash
            return false;
        }
        System.out.println("The cat " + name + " is chasing the mouse.");
        hunger -= (byte)(Math.random()*4+5);
        if (Math.random() > 0.90) {
            System.out.println("Success!");
            hunger += (byte)0b0001_1000;
        }else {
            System.out.println("Couldn't catch the mouse!");
        }
        return true;
    }

    public boolean doSomethingIncomprehensible() {
        if (!checkSatiety(hunger, name)) {
            --hunger;   //jTrash
            return false;
        }
        System.out.println("The cat " + name + " is doing something incomprehensible!");
        hunger -= (byte)(Math.random()*4+5);
        return true;
    }

    public void liveAnotherDay() {
        byte randValue;
        boolean wellFed = true;
        for (int i = 0; i < 24; i++) {
            randValue = (byte)(Math.random()*3);
            switch (randValue) {
                case (byte)0:
                    wellFed = play();
                    break;
                case (byte)1:
                    wellFed = sleep();
                    break;
                case (byte)2:
                    wellFed = chaseMouse();
                    break;
                case (byte)3:
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
