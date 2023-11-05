package food;

public abstract class Meat extends Food {
    public Meat(String name, short calorie) {
        super(calorie);
        setName(name);
    }
}
