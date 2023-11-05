import model.Kotik;

class Application {

    private static Object[] parameters() {
        Object[] parameters = new Object[4];
        parameters[0] = (int)(Math.random()*100);
        String[] names = {"Oscar", "Max", "Bella", "Tiger", "Molly", "Sam", "Max", "Misty",
                "Coco", "Simba", "Milo", "Angel", "Chloe", "Lucy", "Missy", "Sacha", "Lala"};
        parameters[1] = names[(int)(Math.random()*names.length)];
        parameters[2] = (int)(Math.random()*11);
        parameters[3] = "Meow";
        for (int i = 0; i < (int)(Math.random()*7); ++i) {
            parameters[3] += " meow";
        }
        parameters[3] += "!!!";
        return parameters;
    }

    public static void main(String[] args) {
        Object[] params = parameters();
        Kotik catFirst = new Kotik((int)params[0], (String)params[1], (int)params[2], (String)params[3]);
        Kotik catSecond = new Kotik();
        params = parameters();
        catSecond.setKotik((int)params[0], (String)params[1], (int)params[2], (String)params[3]);

        catFirst.liveAnotherDay();

        if (catFirst.getMeow().equals(catSecond.getMeow()))
            System.out.println("Cats speak the same language.");
        else
            System.out.println("Cats don't understand each other.");

        System.out.println("Total cats count: " + (int)Kotik.getCatsCount());
    }
}