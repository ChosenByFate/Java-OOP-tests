package food;

public abstract class Food {
    private String name;
    private short calorie;

    protected Food(short calorie) {
        this.calorie = calorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getCalorie() {
        return calorie;
    }
}
