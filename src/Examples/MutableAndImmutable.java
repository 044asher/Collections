package Examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MutableAndImmutable {
    public static void main(String[] args) {
        ArrayList<String> mutableList = new ArrayList<>();
        mutableList.add("Java");
        mutableList.add("C++");
        mutableList.add("PHP");
        System.out.println("Start List: " + mutableList);

        mutableList.remove("PHP");
        System.out.println("Mutable List: " + mutableList);

        System.out.println("\n--------------------------------------\n");

        List<String> immutableList = List.of("Apple", "Banana", "Soup");
        System.out.println("List: " + immutableList);
        //immutableList.remove("Soup"); //UnsupportedOperationException
        //System.out.println("Immutable List: " + immutableList);

        System.out.println("\n--------------------------------------\n");

        Map<Integer, String> mutableMap = new HashMap<>();
        mutableMap.put(1, "Space");
        mutableMap.put(2, "Lab");

        System.out.println("Map: " + mutableMap);
        mutableMap.put(332, "Java");

        System.out.println("And this Map again: " + mutableMap);

        System.out.println("\n--------------------------------------\n");

        Map<String, String> immutableMap = Map.of(
                "Hi", "Hello",
                "Wrd", "World"
        );
        System.out.println("Start Map: " + immutableMap);

        //immutableMap.put("Hey", "How are you?"); //UnsupportedOperationException
        //System.out.println("Immutable Map: " + immutableMap);
    }
}
