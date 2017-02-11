import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 1/18/17.
 */
public class ArrayFlattener {


    public static void main(String[] args) {


        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        Long l = Long.valueOf(Integer.MAX_VALUE);
//        System.out.println(l + 200);
//        System.out.println(Long.valueOf(Integer.MAX_VALUE));
        Object[] obj = new Object[]{new Object[]{1, 2, new Object[]{3}}, 4, -5};
//        List<Integer> integerList= integerArrayFlatener2(obj);
//        Integer[] arr = integerList.toArray(new Integer[integerList.size()]);
//        System.out.println("----------");
//        for (int i : arr) {
//            System.out.println(i);
//        }

        int[] tempArr = flattenedIntegerArray(obj);
        for (int i : tempArr) {
            System.out.println(i);
        }

    }

    /**
     * Flattens an array of arbitrarily nested arrays of integers into a flat array of integers
     *
     * @param inputObjArr array of Integers or nested arrays of Integers
     * @return the flattened array or null if null or empty
     * @throws IllegalArgumentException
     */
    public static int[] flattenedIntegerArray(Object[] inputObjArr) throws IllegalArgumentException {
        List<Integer> integerList = integerArrayFlatener(inputObjArr);

        if (integerList == null || integerList.size() == 0) {
            return null;
        }

        int[] flattenedIntArray = new int[integerList.size()];
        int j = 0;
        for (int i : integerList) {
            flattenedIntArray[j] = i;
            j++;
        }

        return flattenedIntArray;
    }

    private static List<Integer> integerArrayFlatener(Object[] inputObjArr) throws IllegalArgumentException {

        if (inputObjArr == null) {
            return null;
        }

        List<Integer> flatList = new ArrayList<>();

        for (Object obj : inputObjArr) {
            // check if the object is of type integer
            if (obj instanceof Integer) {
                flatList.add((int) obj);
            } else if (obj instanceof Object[]) {
                // check if its a nested object
                // recursively call the same method with the nested object
                flatList.addAll(integerArrayFlatener((Object[]) obj));
            } else {
                throw new IllegalArgumentException("Input exceptions, pass an aray of integers or an array or nested arrays of integers");
            }
        }

        return flatList;
    }

}