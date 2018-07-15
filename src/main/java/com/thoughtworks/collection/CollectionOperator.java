package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        return left < right ? IntStream.rangeClosed(left, right).mapToObj(Integer::new).collect(Collectors.toList()) : IntStream.rangeClosed(right, left).mapToObj(Integer::new).sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return left < right ? IntStream.rangeClosed(left, right).filter(i -> i % 2 == 0).mapToObj(Integer::new).collect(Collectors.toList()) : IntStream.rangeClosed(right, left).filter(i -> i % 2 == 0).mapToObj(Integer::new).sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(i -> i % 2 == 0).mapToObj(Integer::new).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        return Arrays.stream(firstArray).filter(i ->
                Arrays.stream(secondArray).anyMatch(j -> i == j))
                .mapToObj(Integer::new).collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> l = new ArrayList<Integer>(Arrays.asList(firstArray));
        l.addAll(Arrays.stream(secondArray).filter(i ->
                !Arrays.stream(firstArray).anyMatch(j -> i == j))
                .collect(Collectors.toList()));
        return l;
    }
}
