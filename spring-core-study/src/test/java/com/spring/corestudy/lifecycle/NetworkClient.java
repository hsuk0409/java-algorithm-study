package com.spring.corestudy.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    /***
     * "무거운 초기화 작업은 생성자 안에서 하지말고 따로 분리해라"
     * 생성자: 필수 정보를 받고, 메모리 할당해서 개체 생성
     * 초기화: 생성된 값들을 활용해서 외부 커넥션 연결
     */
    public NetworkClient() {
        System.out.println("네트워크 클라이언트 생성자 호출, url= " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + ", message= " + message);
    }

    public void disconnect() {
        System.out.println("close: " + url);
    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
