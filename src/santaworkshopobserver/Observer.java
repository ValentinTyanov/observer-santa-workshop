package santaworkshopobserver;

public interface Observer {
    void update();

    void setObservable(Observable observable);
}