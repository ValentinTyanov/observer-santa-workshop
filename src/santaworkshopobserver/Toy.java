package santaworkshopobserver;

public class Toy {
    private String name;

    public void giveName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static class Type {
        public static final String BICYCLE = "Bicycle";
        public static final String DOLL = "Doll";
    }
}
