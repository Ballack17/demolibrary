package com.kitconsalt.stringtoarrays;

import com.kitconsalt.stringtoarrays.convertors.StringToIntArraysAbleImpls;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class StringToIntArraysAbleImplsTest {

    private final StringToIntArraysAbleImpls stringToIntArraysAbleImpls = new StringToIntArraysAbleImpls();

    String[] a = {"1,3-5", "2", "3-4"};

    @Test
    void reformingStringSizeCheck() {
        assertThat(stringToIntArraysAbleImpls.stringToInt(new String[]{"1,3-5", "2", "3-4"}).size()).isEqualTo(3);
    }

    @Test
    void reformingStringHyphenCheck() {
        assertThat(stringToIntArraysAbleImpls.stringToInt(new String[]{"1,3-5", "2", "3-4"}).get(0)).isEqualTo(new Integer[] {1,3,4,5});
        assertThat(stringToIntArraysAbleImpls.stringToInt(new String[]{"1,3-5", "2", "3-4"}).get(1)).isEqualTo(new Integer[] {2});
        assertThat(stringToIntArraysAbleImpls.stringToInt(new String[]{"1,3-5", "2", "3-4"}).get(2)).isEqualTo(new Integer[] {3,4});
    }

    @Test
    void reformingStringHyphenCheckFail() {
        assertThat(stringToIntArraysAbleImpls.stringToInt(new String[]{"1,3-5", "2", "3-4"}).get(0)).isNotEqualTo(new Integer[] {1,3,5,5});
    }

    @Test
    void recursionTest() {
        ArrayList<Integer[]> mainData = stringToIntArraysAbleImpls.stringToInt(new String[]{"1,3-5", "2", "3-4"});
        LinkedList<Integer> buffer = new LinkedList<>();
        LinkedList<LinkedList<Integer>> answer = new LinkedList<>();
        stringToIntArraysAbleImpls.recursion(buffer, mainData, answer, 0);
        assertThat(answer.size()).isEqualTo(8);
        assertThat(answer.get(0).toArray()).isEqualTo(new Integer[] {1,2,3});
        assertThat(answer.get(7).toArray()).isEqualTo(new Integer[] {5,2,4});
    }

}
