package food;

public abstract class Grass extends Food {
    public Grass(String name, short calorie) {
        super(calorie);
        setName(name);
    }
}
