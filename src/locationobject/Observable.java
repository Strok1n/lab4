package locationobject;

import geometry.Point;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Point point) throws InterruptedException;
}

