package com.oop.study.oopstudy.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ConvertBracketTest {

    @DisplayName("스택을 이용한 괄호 변환 문제")
    @Test
    void convertBracketTest() {
        String p = "()))((()";

        if (correct(p)) {
            System.out.println(p);
        }

        System.out.println(dfs(p));
    }

    private boolean correct(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private String dfs(String w) {
        if (w.length() == 0) return "";

        String u = "";
        String v = "";
        int open = 0;
        int close = 0;

        for (int i = 0; i < w.length(); ++i) {
            char c = w.charAt(i);
            if (c == '(') ++open;
            else ++close;

            if ((open != 0 && close != 0) && open == close) {
                u = w.substring(0, i + 1);
                if (i != w.length() - 1) {
                    v = w.substring(i + 1);
                }
                break;
            }
        }

        if (!correct(u)) {
            String tmp = "(" + dfs(v);
            tmp += ")";
            u = u.substring(1, u.length() - 1);
            u = u.replace("(", ".");
            u = u.replace(")", "(");
            u = u.replace(".", ")");
            tmp += u;
            return tmp;
        }
        return u + dfs(v);
    }

}
