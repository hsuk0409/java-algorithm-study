package justin.designpattern.observer;

import java.util.Vector;

public class TimeSource {

    private final Vector<ClockObserver> clockObservers = new Vector<>();

    protected void notify(int hours, int minutes, int seconds) {
        for (ClockObserver observer : clockObservers) {
            observer.update(hours, minutes, seconds);
        }
    }

    public void registerObserver(ClockObserver observer) {
        clockObservers.add(observer);
    }
}
