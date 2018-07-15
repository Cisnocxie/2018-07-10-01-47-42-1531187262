package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().mapToInt(i -> i).max().getAsInt();
    }

    public double getMinimum() {
        return arrayList.stream().mapToInt(i -> i).min().getAsInt();
    }

    public double getAverage() {
        return arrayList.stream().reduce(0, (a, b) -> a + b).floatValue() / arrayList.size();
    }

    public double getOrderedMedian() {
        int size = arrayList.size();
        if (size % 2 != 0) {
            return arrayList.stream().skip(size / 2).findFirst().get();
        } else {
            return arrayList.stream().skip(size / 2 - 1).limit(2).mapToInt(Integer::intValue).average().getAsDouble();
        }
    }

    public int getFirstEven() {
        return arrayList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()).get(0);
    }

    public int getIndexOfFirstEven() {
        return arrayList.indexOf(arrayList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()).get(0));
    }

    public boolean isEqual(List<Integer> arrayList) {
        boolean isEqual = false;
        if (arrayList.size() == this.arrayList.size()) {
            isEqual = IntStream.range(0, arrayList.size())
                    .allMatch(index -> arrayList.get(index) == this.arrayList.get(index));
        }
        return isEqual;
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        if (arrayList.size() % 2 != 0) {
            return arrayList.get((arrayList.size() - 1) / 2).doubleValue();
        } else {
            return (arrayList.get(arrayList.size() / 2) + arrayList.get(arrayList.size() / 2 - 1)) / 2.0;
        }
    }

    public int getLastOdd() {
        List<Integer> l = arrayList.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
        return l.get(l.size() - 1);
    }

    public int getIndexOfLastOdd() {
        List<Integer> l = arrayList.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
        return arrayList.indexOf(l.get(l.size() - 1));
    }
}
