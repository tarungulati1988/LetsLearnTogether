import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tgulati on 2/13/17.
 */
public class CombinationSum {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = combinationSum(new int[]{1,2,3,3,2,1,2,2,2}, 6);
        System.out.println(res.size());
        List<List<Integer>> res2 = combinationSum2(new int[]{1,2,3,3,2,1,2,2,2}, 6);
        System.out.println(res2.size());
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(result, curr, 0, target, candidates);
        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> curr, int start, int target, int[] candidates){
        if(target==0){
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        if(target<0){
            return;
        }

        int prev=-1;
        for(int i=start; i<candidates.length; i++){
            if(prev!=candidates[i]){ // each time start from different element
                curr.add(candidates[i]);
                helper(result, curr, i+1, target-candidates[i], candidates); // and use next element only
                curr.remove(curr.size()-1);
                prev=candidates[i];
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if(candidates == null || candidates.length == 0) return result;

        ArrayList<Integer> current = new ArrayList<Integer>();
        Arrays.sort(candidates);

        combinationSum(candidates, target, 0, current, result);

        return result;
    }

    public static void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result){
        if(target == 0){
            ArrayList<Integer> temp = new ArrayList<Integer>(curr);
            result.add(temp);
            return;
        }

        for(int i=j; i<candidates.length; i++){
            if(target < candidates[i])
                return;

            curr.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, curr, result);
            curr.remove(curr.size()-1);
        }
    }
}
