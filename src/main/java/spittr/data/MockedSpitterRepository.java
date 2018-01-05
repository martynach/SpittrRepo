package spittr.data;

import org.springframework.stereotype.Component;
import spittr.Spitter;

import java.util.*;

@Component
public class MockedSpitterRepository implements ISpitterRepository {

    private Map<String, Spitter> spittersMap = new HashMap<>();
    Set<Spitter> spitters = new HashSet<>();

    @Override
    public Spitter save(Spitter spitter) {
        //TODO
        spittersMap.put(spitter.getUsername(), spitter);
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username) {
        return spittersMap.get(username);
    }

    public static void hashSetTest() {
        Set<Spitter> mySet = new HashSet<>();
        Spitter spitter1 = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
        Spitter spitter2 = new Spitter(25L, "jbauer", "24hours", "Jack", "Bauer");
        System.out.println("spitter1.equals(spitter2) = " + spitter1.equals(spitter2));

        boolean result = mySet.add(spitter1);
        System.out.println();
        System.out.println("Result of adding spitter1: " + result);
        for(Spitter s: mySet) {
            System.out.println(s);
        }

        result = mySet.add(spitter2);
        System.out.println();
        System.out.println("Result of adding spitter2: " + result);
        for(Spitter s: mySet) {
            System.out.println(s);
        }

        System.out.println();
    }

    public static void hashMapTest() {
        Map<Spitter, Integer> myMap = new HashMap<>();
        Spitter spitter1 = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
        Spitter spitter2 = new Spitter(25L, "jbauer", "24hours", "Jack", "Bauer");
        System.out.println("spitter1.equals(spitter2) = " + spitter1.equals(spitter2));


        Integer result = myMap.put(spitter1, 100);
        System.out.println();
        System.out.println("Result of adding lemon1: " + result);
        for(Spitter key: myMap.keySet()) {
            System.out.println("key: " + key + ", value: " + myMap.get(key));
        }

        result = myMap.put(spitter2, 200);
        System.out.println();
        System.out.println("Result of adding lemon2: " + result);
        for(Spitter key: myMap.keySet()) {
            System.out.println("key: " + key + ", value: " + myMap.get(key));
        }

        System.out.println();
    }
}
