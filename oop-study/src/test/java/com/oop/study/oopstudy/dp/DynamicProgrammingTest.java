package com.oop.study.oopstudy.dp;

import com.oop.study.oopstudy.entity.knapsack.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DynamicProgrammingTest {

    @DisplayName("동적 계획법으로 배낭문제 푸는 코드 작성해보기")
    @Test
    void dpTest() {
        //given
        Item[] items = new Item[5];

        items[0] = new Item(3, 5);
        items[1] = new Item(9, 12);
        items[2] = new Item(1, 2);
        items[3] = new Item(5, 4);
        items[4] = new Item(7, 9);

        int maxValue = getMaxValue(15, items);

        System.out.println(String.format("Max Value: %d", maxValue));
    }

    private int getMaxValue(int numSpace, Item[] items) {
        int numItems = items.length;

        int cache[][] = new int[numItems][numSpace + 1];

        for (int s = 1; s <= numSpace; ++s) {
            if (items[0].getSpace() > s) {
                continue;
            }
            cache[0][s] = items[0].getValue();
        }

        for (int i = 1; i < numItems; ++i) {
            for (int s = 1; s <= numSpace; ++s) {
                // 현재 아이템이 s 공간에 들어가는지 확인
                if (items[i].getSpace() > s) {
                    // 안 들어간다면 전의 최댓값으로 넣는다.
                    cache[i][s] = cache[i - 1][s];
                    continue;
                }

                // s 공간에 들어간다면
                int remainingSpace = s - items[i].getSpace();
                int remainingMaxValue = cache[i - 1][remainingSpace];

                int choice1 = cache[i - 1][s]; // 최댓값
                int choice2 = items[i].getValue() + remainingMaxValue; // 현재 값 + 남은 공간을 채웠던 최댓값

                cache[i][s] = Math.max(choice1, choice2);
            }
        }

        return cache[numItems - 1][numSpace];
    }
}
