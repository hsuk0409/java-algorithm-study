package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class FindDayOfWeekTest {
    @DisplayName("2016년도 날짜에 대한 요일 구하기")
    @Test
    void test() {
        String dayOfWeek = getDayOfWeek(5, 24);
        assert (dayOfWeek.equals("TUE"));

        dayOfWeek = getDayOfWeekOther(5, 24);
        assert (dayOfWeek.equals("TUE"));
    }

    public String getDayOfWeek(int a, int b) {
        String[] result = new String[] {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        LocalDate date = LocalDate.of(2016, a, b);
        DayOfWeek dw = date.getDayOfWeek();

        return result[dw.getValue() - 1];
    }

    public String getDayOfWeekOther(int a, int b) {
        return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0, 3);
    }
}
