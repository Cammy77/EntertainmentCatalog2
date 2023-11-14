import java.util.HashMap;
import java.util.Map;

/**
* Taylor Layton - tglayton
* CIS152
* Nov 11, 2023
* Windows 10
 */

/**
 * creates hashmap, stores emails with names, searches by key
 */
public class Driver {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("ChickenNugget@gmail.com", "Ronald McDonald");
        map.put("GoldenGirl@yahoo.com", "Betty White");
        map.put("tglayton@dmacc.edu", "Taylor Layton");
        map.put("tatortots@gmail.com", "Napoleon Dynomite");
        
        Print(map, "ChickenNugget@gmail.com");
        Print(map, "tglayton@dmacc.edu");
        
        map.remove("ChickenNugget@gmail.com");
        map.remove("GoldenGirl@yahoo.com");
        map.remove("tglayton@dmacc.edu");
        map.remove("tatortots@gmail.com");
    }
/**
 * prints value related to the key in the map
 */
    private static void Print(Map<String, String> map, String key) {
        if (map.containsKey(key)) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}