package justin.designpattern.observer;

public class MockTimeSink implements ClockObserver {

    private int hours;
    private int minutes;
    private int seconds;

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void update(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

}
