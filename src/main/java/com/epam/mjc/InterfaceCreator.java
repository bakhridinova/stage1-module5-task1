package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> strings.stream().allMatch(string -> Character.isUpperCase(string.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> x.addAll(x.stream().filter(elem -> elem % 2 == 0).toList());
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream().filter(value -> Character.isUpperCase(value.charAt(0)) && value.contains(".") && value.split(" ").length > 3).toList();
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return strings -> strings.stream().collect(Collectors.toMap(Object::toString, String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (integers1, integers2) -> Stream.concat(integers1.stream(), integers2.stream()).toList();
    }
}
