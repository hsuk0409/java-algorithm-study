package com.spring.corestudy.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // 하나의 개체만 생성되어야 하기 때문에 생성자를 막는다.
    private SingletonService() {
    }

    public void login() {
        System.out.println("싱글톤 개체 로직 호출");
    }
}
