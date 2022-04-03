package justin.designpattern.observer;

public class ClockDriver implements ClockObserver{

    private final TimeSink timeSink;

    public ClockDriver(TimeSource source, TimeSink sink) {
        source.registerObserver(this);
        timeSink = sink;
    }

    public void update(int hours, int minutes, int seconds) {
        timeSink.setTime(hours, minutes, seconds);
    }
}
