package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class FailPercentTest {
    @DisplayName("실패율 높은 순으로 스테이지 정렬해서 구하기")
    @Test
    void test() {
        int[] stages = new int[] {2,1,2,6,2,4,3,3};
        int[] results = new int[] {3,4,2,1,5};

        int[] result = getStagesOrderByFailPercentDesc(5, stages);
        for (int i = 0; i < result.length; ++i) {
            assert (result[i] == results[i]);
        }
    }

    public int[] getStagesOrderByFailPercentDesc(int N, int[] stages) {
        int[] result = new int[N];
        int[] stageCnt = new int[N];
        HashMap<Integer, Double> failPer = new HashMap<>();

        for (int stage : stages) {
            if (stage == (N + 1)) continue;
            stageCnt[stage - 1]++;
        }

        int total = stages.length;
        for (int i = 0; i < stageCnt.length; ++i) {
            if (total == 0) {
                failPer.put(i, 0d);
                continue;
            }
            failPer.put(i, (double)stageCnt[i] / (double)total);
            total -= stageCnt[i];
        }

        for (int i = 0; i < N; ++i) {
            double max = -1;
            int key = 0;

            for (int k : failPer.keySet()) {
                if (max < failPer.get(k)) {
                    max = failPer.get(k);
                    key = k;
                }
            }

            result[i] = key + 1;
            failPer.remove(key);
        }

        return result;
    }
}
