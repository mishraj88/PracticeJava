import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class StreamDemo {

    private static Map<String, String> map = new HashMap<>();

    private static List<String> numbers = new ArrayList<>();



    private static List<String> convertMapToListJava8(Map<String, String> map){
        return map.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
    }

    private static Map<Integer, String> convertListToMapJava8(List<String> list){
        return list.stream().collect(Collectors.toMap(s -> s.length(), s -> s.toUpperCase()));
    }
    public static void main(String[] args) {
        map.put("A", "Abhi");
        map.put("B", "Banrakas");
        System.out.println("Printing map: "+map);

        map.forEach((k,v) -> System.out.println("key: "+k+" , and value: "+v));
       List<String> list = convertMapToListJava8(map);
       list.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

       Collections.addAll(numbers, "Abhi", "Banrakas");

       numbers.forEach(s -> System.out.println(s));

       Map<Integer,String> newMap = convertListToMapJava8(list);

       System.out.println("New map created from list using java 8streams:");
       newMap.forEach((k,v) -> System.out.println("key: "+k+" , and value: "+v));


    }
    
}
