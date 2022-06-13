package com.kitconsalt.stringtoarrays.convertors;


import java.util.ArrayList;
import java.util.LinkedList;

public interface StringsToIntArraysAble {

    /**
     * @Param String[] with elements like 1,2,3 e t.c. and like 3-7 format, example {"1,3-5"} equals {1,3,4,5}
     * @Return ArrayList of Integer's arrays
     * */
    public abstract ArrayList<Integer[]> stringToInt(String[] stringData);

    /**
     * @Param LinkedList<Integer> for middle saving results
     * @Param ArrayList<Integer[]> main Data for analysis, it gets after using stringToInt method
     * @Param LinkedList<LinKedList<Integer> collecting answer's data
     * @Param Int - counter for Arrays reading
     * */
        public void recursion(LinkedList<Integer> integerLinkedList, ArrayList<Integer[]> integers, LinkedList<LinkedList<Integer>> answer, int counter);

}
