import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SorteHashMapOnValues {

    public static void main(String[] args) {
        Map<String, Integer> unsortedMap = new HashMap<>();

        unsortedMap.put("a", 5);
        unsortedMap.put("b", 1);
        unsortedMap.put("c", 6);

        System.out.println("without sorting: "+unsortedMap);

        /*LinkedHashMap<String, Integer> sortedMap = unsortedMap.entrySet().stream()
                                            .sorted((e1,e2) -> {return e1.getValue()-e2.getValue();})
                                            .collect(Collectors.toMap(((e) -> e.getKey(), e.getValue()), (e1, e2) -> e1, LinkedHashMap:: new);

                                            */
    }
    
}
