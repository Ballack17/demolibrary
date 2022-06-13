package com.kitconsalt.stringtoarrays.convertors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringToIntArraysAbleImpls implements StringsToIntArraysAble {


    @Override
    public ArrayList<Integer[]> stringToInt(String[] stringData) {
        ArrayList<Integer[]> intList = new ArrayList<>();
        Arrays.stream(stringData).forEach(a -> {
            List<Integer> answer = new LinkedList<>();
            Arrays.stream(a.split(",")).forEach(s-> {
                if (s.contains("-")) {
                    Integer[] buff = Arrays.stream(s.split("-")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
                    for (Integer i = buff[0]; i <= buff[1]; i++) {
                        answer.add(i);
                    }
                } else {answer.add(Integer.parseInt(s));}
            });
            intList.add(answer.toArray(new Integer[0]));
        });
        return intList;
    }

    @Override
    public void recursion(LinkedList<Integer> integerLinkedList, ArrayList<Integer[]> integers, LinkedList<LinkedList<Integer>> answer, int counter) {
        for (int i = 0; i < integers.get(counter).length; i++) {
            LinkedList<Integer> bufShort;
            if(integerLinkedList.isEmpty()) {
                bufShort = new LinkedList<>();
            } else {
                bufShort = new LinkedList<>(integerLinkedList);
            }
            bufShort.add(integers.get(counter)[i]);
            if (counter+1 < integers.size()) {
                recursion(bufShort,integers,answer,counter+1);
            } else {answer.add(bufShort);}
        }
    }
}
