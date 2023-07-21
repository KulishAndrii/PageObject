package ua.avic.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("1 a");
        strings.add("2 w");
        strings.add("3 e");
        strings.add("4 wq");
        strings.add("5 q");
        System.out.println(strings.stream().map(x -> x.substring(0, x.indexOf(" "))).collect(Collectors.toList()));

    }

}
