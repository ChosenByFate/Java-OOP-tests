package aviary;

public enum AviarySize {
    MIN(1),
    MEDIUM(2),
    LARGE(3),
    MAX(4);

    private int size;

    public int getSize() {
        return size;
    }

    AviarySize(int i) {
        size = i;
    }
}
