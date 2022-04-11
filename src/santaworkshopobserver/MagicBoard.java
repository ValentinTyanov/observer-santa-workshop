package santaworkshopobserver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MagicBoard implements Observer, Observable {
    private static List<Observer> observers;
    private final Queue<String> toyRequests;

    private Santa santa;

    private static MagicBoard instance;

    public static MagicBoard getInstance() {
        if (instance == null) {
            instance = new MagicBoard();
        }
        return instance;
    }

    private MagicBoard() {
        observers = new ArrayList<>();
        toyRequests = new LinkedList<>();
    }

    @Override
    public void update() {
        if (santa == null) {
            System.out.println("I serve only Santa!");
            return;
        }
        storeToyRequest(santa.getMagicalWords());
    }

    @Override
    public void setObservable(Observable observable) {
        if (observable instanceof Santa) {
            santa = (Santa) observable;
        }
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
        observer.setObservable(this);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
        observer.setObservable(null);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
            if (toyRequests.isEmpty()) {
                break;
            }
        }
    }

    public String getNextToyInLine() {
        return toyRequests.poll();
    }

    private void storeToyRequest(String magicalWords) {
        if (magicalWords.equals(ToyRequest.BICYCLE.request)) {
            toyRequests.add(Toy.Type.BICYCLE);
            notifyObservers();
        } else if (magicalWords.equals(ToyRequest.DOLL.request)) {
            toyRequests.add(Toy.Type.DOLL);
            notifyObservers();
        } else {
            System.out.println("Sorry, Santa, we do not produce that!");
        }
    }
}