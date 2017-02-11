import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {
    public static double affinityThreshold;
    public static int num;
    public static Map<String, List<String>> itemMap = new LinkedHashMap<>();
    public static Map<String, List<String>> clusterMap = new HashMap<>();
    public static Set<String> visited = new HashSet<>();
    //public static List<String> tempNodes = new ArrayList<>();

    public static void main(String args[] ) throws Exception {

        Scanner scanner = new Scanner(System.in);
        affinityThreshold = Double.parseDouble(scanner.nextLine());
        //System.out.println(affinityThreshold);
        num = Integer.parseInt(scanner.nextLine());
        //System.out.println(num);
        String line;
        for(int i = 0; i < num; i++) {
            line = scanner.nextLine();
            //System.out.println("temp: " + line);
            String[] tempArr = line.split(" ");
            Map<String, Double> tempMap = new HashMap<>();
            List<String> tempList = new ArrayList<>();
            /*for(String str: tempArr) {
                System.out.println(str);
            }*/
            tempList.add(tempArr[1]);
            tempList.add(tempArr[2]);
//            tempMap.put(tempArr[1], Double.parseDouble(tempArr[2]));
            itemMap.put(tempArr[0], tempList);
        }

        //build cluster map

        for(Map.Entry<String, List<String>> entry : itemMap.entrySet()) {
            String key = entry.getKey();

            if(!visited.contains(key)) {
                visited.add(key);
                List<String> valueList = entry.getValue();
                int comp = Double.compare(affinityThreshold, Double.parseDouble(valueList.get(1)));
                if(comp <= 0) {
                    //do dfs and get list of all connected nodes
                    List<String> tempNodes = new ArrayList<>();
                    tempNodes.add(key);
                    System.out.println("-----------------------key-------------------" + key);
                    doDFS(key, tempNodes);

                    /*for(String str : tempNodes) {
                        System.out.println("connected nodes:" + str);
                    }*/
                    clusterMap.put(key, tempNodes);
                    System.out.println("-----------------------key ends-------------------");
                    //System.out.println(valueList.get(0) + ":" + key);
                }
            }

        }

        for(String key2 : clusterMap.keySet()) {
            System.out.println(key2 + " : " + Arrays.toString(clusterMap.get(key2).toArray()));
        }


        //get biggest cluster
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

    }


    public static void doDFS(String key, List<String> tempNodes) {
        if(itemMap.get(key) == null)
            return;

        System.out.println("dfs step 1: " + itemMap.get(key).get(0));

        if(visited.contains(itemMap.get(key).get(0)))
            return;

        List<String> tempList = itemMap.get(key);
        System.out.println("tempList: " + Arrays.toString(tempList.toArray()));
        int comp = Double.compare(affinityThreshold, Double.parseDouble(tempList.get(1)));
        if(comp <= 0) {
            tempNodes.add(tempList.get(0));
            visited.add(tempList.get(0));
            //System.out.println(tempList.get(0) + " key : "+ key);
            System.out.println("tempNodes: " + Arrays.toString(tempNodes.toArray()));
            doDFS(tempList.get(0), tempNodes);
        }

    }
}