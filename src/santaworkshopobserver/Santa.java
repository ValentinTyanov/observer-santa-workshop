package santaworkshopobserver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Santa implements Observable {

    private final List<Observer> observers;
    private String magicalWords;
    public static final List<Toy> toyStash = new ArrayList<>();

    private Santa() {
        this.observers = new ArrayList<>();
    }

    private static Santa instance;

    public static Santa getInstance() {
        if (instance == null) {
            instance = new Santa();
        }
        return instance;
    }

    @Override
    public void subscribe(Observer observer) {
        this.observers.add(observer);
        observer.setObservable(this);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.observers.remove(observer);
        observer.setObservable(null);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update();
        }
    }

    public String getMagicalWords() {
        return magicalWords;
    }

    public void requestToy(String magicalWords) {
        this.magicalWords = magicalWords;
        notifyObservers();
    }

    public Stream<Toy> getSomeToysFromStash() {
        return toyStash.stream().limit(5);
    }
}
