package com.oop.study.oopstudy.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TupleQuestionTest {

    @DisplayName("문자열 그룹 중 적은 수 순서대로 중복없이 그룹핑하기")
    @Test
    void tupleQuestionTest() {
        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String s3 = "{{20,111},{111}}";

        ArrayList<ArrayList<Integer>> tmpStorages = new ArrayList<>();
        int i = 1;

        while (i < s3.length() - 1) {
            ArrayList<Integer> tmpNums = new ArrayList<>();
            if (s3.charAt(i++) == '{') {
                StringBuilder numStr = new StringBuilder();
                while (s3.charAt(i) != '}') {
                    if (s3.charAt(i) != ',') {
                        numStr.append(s3.charAt(i));
                    } else {
                        tmpNums.add(Integer.parseInt(numStr.toString()));
                        numStr.delete(0, numStr.length());
                    }
                    ++i;
                }
                tmpNums.add(Integer.parseInt(numStr.toString()));
                numStr.delete(0, numStr.length());
            }
            if (tmpNums.size() > 0) {
                tmpStorages.add(tmpNums);
            }
        }

        sortArrArr(tmpStorages);

        ArrayList<Integer> result = new ArrayList<>();
        for (ArrayList<Integer> arr : tmpStorages) {
            printArr(arr);
            for (int num : arr) {
                if (!result.contains(num)) {
                    result.add(num);
                }
            }
        }

        sortArrArr(tmpStorages);


        System.out.println();
    }

    @DisplayName("문자열 그룹 중 적은 수 순서대로 중복없이 그룹핑하기 (다른사람 코드)")
    @Test
    void tupleQuestionTest2() {
        String s = "{{20,111},{111}}";

        Set<String> set = new HashSet<>();
        String tmpStr1 = s.replaceAll("[{]", " ");
        String tmpStr2 = tmpStr1.replaceAll("[}]", " ");
        String[] arr = tmpStr2.trim().split(" , ");
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        int[] result = new int[arr.length];
        int resultInx = 0;
        for (String s1 : arr) {
            for (String s2 : s1.split(",")) {
                if (set.add(s2)) {
                    result[resultInx++] = Integer.parseInt(s2);
                }
            }
        }

        List<Integer> expect = new ArrayList<>();
        expect.add(111);
        expect.add(20);

        for (int i = 0; i < result.length; ++i) {
            assertThat(result[i]).isEqualTo(expect.get(i));
        }
    }

    public void sortArrArr(ArrayList<ArrayList<Integer>> arrArr) {
        for (int i = 0; i < arrArr.size(); ++i) {
            for (int k = i + 1; k < arrArr.size(); ++k) {
                if (arrArr.get(k).size() < arrArr.get(i).size()) {
                    ArrayList<Integer> tmp;
                    tmp = arrArr.get(k);
                    arrArr.set(k, arrArr.get(i));
                    arrArr.set(i, tmp);
                }
            }
        }
    }

    public void printArr(ArrayList<Integer> arr) {
        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }
}
