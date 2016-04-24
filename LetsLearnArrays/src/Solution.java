import java.io.*;
import java.util.*;

/**
 * Created by tgulati on 4/18/16.
 */
public class Solution {

    static BufferedWriter bw;

    static class Employee {

        public String designation;

        public String year;

        public String name;

        public Employee(String name, String designation, String year) {
            this.name = name;
            this.designation = designation;
            this.year = year;
        }

    }

    public static void main(String[] args) throws IOException {


        String inputFileName = "/Users/tgulati/Downloads/org_chart.in";
        String outputFileName = "/Users/tgulati/Downloads/org_chart_output.in";

        String line = null;

        try {
            FileReader fileReader = new FileReader(new File(inputFileName));

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bw = new BufferedWriter(new FileWriter(new File(outputFileName)));

            int count = 1;
            String lineNum = bufferedReader.readLine();
            int num = Integer.parseInt(lineNum);
            while ((line = bufferedReader.readLine()) != null) {

                Map<String, ArrayList<Employee>> employeeMap = orgChart(line);
                bw.write("Case #" + count + "\n");

//                System.out.println("Case #" + count);
                printMap(employeeMap, "NULL", 0);
//                System.out.println("=============================");
                count++;
            }

            // Always close files.
            bufferedReader.close();
            bw.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            inputFileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + inputFileName + "'");
        }

    }

    private static void printMap (Map<String, ArrayList<Employee>> employeeMap, String aNull, int level) throws IOException {

        ArrayList<Employee> employeeArrayList = employeeMap.get(aNull);
        if (employeeArrayList != null && employeeArrayList.size() > 0) {
            Collections.sort(employeeArrayList, empComp);
            for (Employee emp : employeeArrayList) {
                bw.write(printDash(level) + emp.name + " (" + emp.designation + ") " + emp.year + "\n");
//                System.out.println(printDash(level) + e.name + " (" + e.designation + ") " + e.year);
                printMap(employeeMap, emp.name, level + 1);
            }
        } else {
            return;
        }
    }

    private static String printDash(int level) {
        String str = "";
        for (int i = 0; i < level; i++) {
            str += "-";
        }
        return str;
    }

    public static Comparator<Employee> empComp = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.name.compareTo(o2.name);
        }
    };

    private static Map<String, ArrayList<Employee>> orgChart(String line) {

        String[] splitStr = line.split("--");
        Map<String, ArrayList<Employee>> employeeMap = new HashMap<String, ArrayList<Employee>>();
        for (int i = 0; i < splitStr.length; i++) {
            String[] intermitentSplitStr = splitStr[i].split(",");
            if (employeeMap.containsKey(intermitentSplitStr[1])) {
                Employee e1 = new Employee(intermitentSplitStr[0], intermitentSplitStr[2], intermitentSplitStr[3]);
                employeeMap.get(intermitentSplitStr[1]).add(e1);
            } else {
                ArrayList<Employee> tempArr2 = new ArrayList<Employee>();
                Employee e2 = new Employee(intermitentSplitStr[0], intermitentSplitStr[2], intermitentSplitStr[3]);
                tempArr2.add(e2);
                employeeMap.put(intermitentSplitStr[1], tempArr2);
            }

        }

//        for(Map.Entry map : empMap.entrySet()) {
//            System.out.println(map.getKey() + ": " + map.getValue());
//        }

        return employeeMap;
    }

    private static int add(String line) {
        String[] split = line.split(" ");
        int sum = Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
        return sum;

    }
}
