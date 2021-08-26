package com.jvm.study;

@MyAnnotation
public class Book {
    private static String pvStcStr;

    private static final String PV_STC_FIN_STR = "pv_stc_fin_str";

    private String pvStr;

    @MyAnnotation
    public String pbStr;

    protected String ptStr;

    public Book() {
    }

    public Book(String pvStr, String pbStr, String ptStr) {
        this.pvStr = pvStr;
        this.pbStr = pbStr;
        this.ptStr = ptStr;
    }

    private void printPvSomething() {
        System.out.println("private something");
    }

    public void printPbSomething() {
        System.out.println("public something");
    }

    public int getNumber() {
        return 100;
    }
}
