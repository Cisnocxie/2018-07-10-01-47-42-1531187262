package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer> result = new ArrayList<Integer>();
        IntStream.range(1, number / 2 + 1).reduce(number, (reduceNum, index) -> {
            int reduceValue = reduceNum - 2;
            result.add(reduceValue);
            return reduceValue;
        });
        return result;
    }
}
