package utills;

public enum FieldSize {
    SMALL(30),
    MEDIUM(40),
    LARGE(50),
    XLARGE(60);

    private final Integer size;


    FieldSize(int i) {
        this.size = i;
    }

    public Integer getSize() {
        return this.size;
    }
}
