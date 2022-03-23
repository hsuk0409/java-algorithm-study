package justin.designpattern.singleton;

public class SingletonObject {
    private static final SingletonObject instance = new SingletonObject();

    private SingletonObject() {
    }

    public static SingletonObject getInstance() {
        return instance;
    }
}
