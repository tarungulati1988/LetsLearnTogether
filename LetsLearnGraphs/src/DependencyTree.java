/**
 * Created by tgulati on 5/1/16.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/*
 * You are given operations and the dependency operations on which this operation depends
 * You have parts that need these operations performed on them
 * Choose appropriate data structures to load up the operations and then calling them on a part
 * Test file: src/main/resources/test.in
 */

public class DependencyTree {
    static class Part{
        public String getName(){
            return("X");
        }
    }

    static class Operation{
        private String name_;
        public Operation(final String name){
            name_ = name;
        }
        public String getName() {
            return(name_);
        }
        public void operate(Part p){
            System.out.println("Operation " + name_ + " on part " + p.getName());
        }
    }

    private static Map<String, List<String>> operationMap = new HashMap<>();
    private static Map<String, Operation> nameToOperationMap = new HashMap<>();

    static class StepManager{
        public void addOperation(final Operation operation, final String[] prerequisites){
            // add your implementation here. This method is called
            // once for each type of operation during setup
            List<String> preReqList = new ArrayList<>(Arrays.asList(prerequisites));
            operationMap.put(operation.getName(), preReqList);
            nameToOperationMap.put(operation.getName(), operation);
        }

        public void performOperation(String operationName, Part p){
            // add your implementation here. When this method is called
            // you must call the operate() method for the named operation,
            //as well as all prerequisites for that operation
            Stack<String> operationStack = new Stack<>();
            Set<String> visited = new HashSet<>();
            operationStack.push(operationName);

            while(!operationStack.isEmpty()){
                String currentTop = operationStack.peek();
                String child = getUnvisitedChild(currentTop, visited);
                if(child == null){
                    currentTop = operationStack.pop();
                    visited.add(currentTop);
                    Operation tempOperation = nameToOperationMap.get(currentTop);
                    tempOperation.operate(p);
                } else{
                    operationStack.push(child);
                }
            }
        }

        private String getUnvisitedChild(String currentTop, Set<String> visited) {
            List<String> children = operationMap.get(currentTop);
            for(String child: children){
                if(!visited.contains(child)){
                    return(child);
                }
            }
            return(null);
        }
    }
    public static void main(String[] args) throws IOException{
        StepManager manager = null;
        BufferedReader in = new BufferedReader(new FileReader(
                new File("/Users/tgulati/Downloads/input.txt")));
        String s;
        while((s = in.readLine()) != null && s.length() != 0){
            if(s.startsWith("#")){
                if(manager != null){
                    manager.performOperation("final", new Part());
                }
                manager = new StepManager();
                System.out.println(s);
                continue;
            }
            String[] parts = s.split(",");
            manager.addOperation(new Operation(parts[0]), Arrays.copyOfRange(parts, 1, parts.length));
        }
        if(manager != null){
            manager.performOperation("final", new Part());
        }
        in.close();
    }
}