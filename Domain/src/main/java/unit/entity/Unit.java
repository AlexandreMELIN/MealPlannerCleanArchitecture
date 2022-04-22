package unit.entity;

public enum Unit {
    GRAM("gram", "g"),
    LITER("Liter", "L")
    ;

    private String name;
    private String shortName;

    Unit(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }
}
