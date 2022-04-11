package santaworkshopobserver;

public enum ToyRequest {
    DOLL("I need dolls"),
    BICYCLE("I need bicycles");

    public final String request;

    ToyRequest(String request) {
        this.request = request;
    }
}
