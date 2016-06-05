import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by tgulati on 6/1/16.
 */
public class WordLadder {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        // "hot","dot","dog","lot","log"
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        System.out.println(wordLadderLength("hit", "log", set));

    }

    private static int wordLadderLength(String start, String end, Set<String> set) {

        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(start, 1));

        set.add(end);
        int count = 0;

        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;

            if(word.equals(end)){
                System.out.println("count: " + count);
                return top.numSteps;
            }

            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }

                    String newWord = new String(arr);
                    if(set.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        set.remove(newWord);
                        count++;
                    }

                    arr[i]=temp;
                }
            }
        }

        return 0;
    }


    static class WordNode{
        String word;
        int numSteps;

        public WordNode(String word, int numSteps){
            this.word = word;
            this.numSteps = numSteps;
        }
    }
}
