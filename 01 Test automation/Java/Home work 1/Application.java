import model.Kotik;

class Application {

    private static Object[] parameters() {
//        byte prettiness, String name, byte weight, String meow
        Object[] parameters = new Object[4];
        parameters[0] = (byte)(Math.random()*100);
        String[] names = {"Oscar", "Max", "Bella", "Tiger", "Molly", "Sam", "Max", "Misty",
                "Coco", "Simba", "Milo", "Angel", "Chloe", "Lucy", "Missy", "Sacha", "Lala"};
        parameters[1] = names[(int)(Math.random()*names.length)];
        parameters[2] = (byte)(Math.random()*11);
        parameters[3] = "Meow" + " meow".repeat((int)(Math.random()*7)) + "!!!";
        return parameters;
    }

    public static void main(String[] args) {
        Object[] params = parameters();
        Kotik catFirst = new Kotik((byte)params[0], (String)params[1], (byte)params[2], (String)params[3]);
        Kotik catSecond = new Kotik();
        params = parameters();
        catSecond.setKotik((byte)params[0], (String)params[1], (byte)params[2], (String)params[3]);

        catFirst.liveAnotherDay();

        if (catFirst.getMeow().equals(catSecond.getMeow()))
            System.out.println("Cats speak the same language.");
        else
            System.out.println("Cats don't understand each other.");

        System.out.println("Total cats count: " + (int)Kotik.getCatsCount());
    }
}