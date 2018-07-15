package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        IntStream is = leftBorder < rightBorder ? IntStream.rangeClosed(leftBorder, rightBorder) : IntStream.rangeClosed(rightBorder, leftBorder);
        return is.filter(i -> i % 2 == 0).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        IntStream is = leftBorder < rightBorder ? IntStream.rangeClosed(leftBorder, rightBorder) : IntStream.rangeClosed(rightBorder, leftBorder);
        return is.filter(i -> i % 2 != 0).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(i -> i * 3 + 2).reduce(0, (a, b) -> a + b);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(i -> {
            if (i % 2 != 0) {
                i = i * 3 + 2;
            }
            return i;
        }).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(i -> i % 2 != 0).map(i -> i * 3 + 5).reduce(0, (a, b) -> a + b);
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> al = arrayList.stream().filter(i -> i % 2 == 0).sorted().collect(Collectors.toList());
        double result = 0;
        if (al.size() % 2 == 0) {
            result = (al.get(al.size() / 2) + al.get(al.size() / 2 - 1)) / 2;
        } else {
            result = al.get(Math.round(al.size() / 2 - 1));
        }
        return result;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        List<Integer> al =  arrayList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        return al.stream().reduce(0, (a, b) -> a + b) / al.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()).contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return new ArrayList<Integer>(arrayList.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList()));
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> al =  arrayList.stream().filter(i -> i % 2 == 0).sorted().collect(Collectors.toList());
        al.addAll(arrayList.stream().filter(i -> i % 2 != 0).sorted(Collections.reverseOrder()).collect(Collectors.toList()));
        return al;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<Integer>();
        arrayList.stream().reduce((i, j) -> {
            Integer k = (i + j) * 3;
            result.add(k);
            return j;
        });
        return result;
    }
}
