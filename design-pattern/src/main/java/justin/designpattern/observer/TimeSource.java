package justin.designpattern.observer;

public interface TimeSource {

    void registerObserver(ClockObserver observer);
}
