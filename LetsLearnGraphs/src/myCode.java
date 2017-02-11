import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by tgulati on 9/12/16.
 */
class myCode {

    public static Graph graph;

    /**
     * Message - this class build the message which the application
     * works on
     * The operations are performed on node1 and node2
     * messageType is the operation that has to be performed
     */
    public static class Message {
        private String messageType = "";
        private String node1 = "";
        private String node2 = "";

        public Message(String mode, String node1, String node2) {
            this.messageType = mode;
            this.node1 = node1;
            this.node2 = node2;
        }

        public String getMessageType() {
            return messageType;
        }

        public String getNode1() {
            return node1;
        }

        public String getNode2() {
            return node2;
        }
    }

    /**
     * Graph - class to represent the graph data structure
     * add(n1, n2)- add two nodes to the graph
     * remove(n1, n2)- remove the bidirectional link from the graph
     * isLinked(n1, n2)- check if a link exists between two nodes
     */
    public static class Graph {

        private Map<String, Set<String>> emailGraph;

        public Graph() {
            this.emailGraph = new HashMap<>();
        }

        public Map<String, Set<String>> getEmailGraph() {
            return emailGraph;
        }

        /**
         * add(n1, n2)- adds the bidirectional link between n1 and n2
         */
        public void add(String n1, String n2) {
            Set<String> tempLink;
            Set<String> tempLink2;
            if(emailGraph.containsKey(n1)) {
                tempLink = emailGraph.get(n1);
                if(!tempLink.contains(n2)) {
                    tempLink.add(n2);
                    if(emailGraph.containsKey(n2)) {
                        tempLink2 = emailGraph.get(n2);
                        tempLink.addAll(tempLink2);
                    }
//                     if(!emailGraph.get(n2).isEmpty()) {
//                         tempLink.addAll(emailGraph.get(n2));
//                     }
//                     tempLink.addAll(emailGraph.get(n2));
                    tempLink.remove(n1);
                    emailGraph.put(n1, tempLink);
//                     System.out.println("tg: " + emailGraph.get(n1));
                }

            } else {
                tempLink = new HashSet<>();
                tempLink.add(n2);
                if(emailGraph.containsKey(n2)) {
                    tempLink2 = emailGraph.get(n2);
                    tempLink.addAll(tempLink2);
                }
//                 System.out.println(emailGraph.get(n2));
//                 if(!emailGraph.get(n2).isEmpty()) {
//                     tempLink.addAll(emailGraph.get(n2));
//                 }
//                 tempLink.addAll(emailGraph.get(n2));
                tempLink.remove(n1);
                emailGraph.put(n1, tempLink);
//                 System.out.println("emailGraphn1: " + emailGraph.get(n1));
            }


        }

        /**
         * remove(n1, n2)- removes the bidirectional link between n1 and n2
         */
        public void remove(String n1, String n2) {
//             System.out.println("in remove: " + n1 + n2);
            Set<String> tempLink;

            if(emailGraph.containsKey(n1)) {
                tempLink = emailGraph.get(n1);
                if(tempLink.contains(n2)) {
                    for(String key : tempLink) {
//                         System.out.println("key: " + key);
                        Set<String> tempLink2 = emailGraph.get(key);
//                        System.out.println(tempLink2);
                        tempLink2.remove(n2);
                        emailGraph.put(key, tempLink2);

                    }
                    tempLink.remove(n2);
                    emailGraph.put(n1, tempLink);
//                     System.out.println("tg: " + emailGraph.get(n1));
                }
                if(tempLink.isEmpty()) {
                    emailGraph.remove(n1);
                }

            }
//             else {
//                 tempLink = new HashSet<>();
//                 tempLink.add(n2);
//                 emailGraph.put(n1, tempLink);
//                 System.out.println("emailGraphn1: " + emailGraph.get(n1));
//             }
//             return true;
        }

        /**
         * isLinked(n1, n2)- checks if n1 and n2 are connected
         */
        public boolean linked(String n1, String n2) {
//             System.out.println("in linked: " + n1 + n2);
            Set<String> tempLink;
            if(emailGraph.containsKey(n1)) {
                tempLink = emailGraph.get(n1);
                if(tempLink.contains(n2)) {
                    return true;
                }
            }
            return false;
        }


        public void iterate() {
            System.out.println("----iter-------------");
            for(Map.Entry<String, Set<String>> entry : emailGraph.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            System.out.println("----iter end-------------");
        }

    }



    public static void main (String[] args) throws java.lang.Exception {
        // for internal usage convert intput
        // into a message to be passed around
        // no multiple classes or importrts allowed
        // could have made use of JCommander instead

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(
                new File("/Users/tgulati/Downloads/input2.txt")));

        String input;
        graph = new Graph();

        while((input = br.readLine()) != null) {

//             System.out.println("input1: " + input);
            Message msg = null;
            if(checkValidity(input)) {
                msg = getMessageFromInput(input.split(" "));
                executeOperation(msg);
                //             System.out.println("correct input!!");
                // now call the corresponding methods after extracting the message
            } else {
                continue;
//                 System.out.println("in correct input!!");
            }
        }

    }

    /**
     * checkValidity()- check if the input is valid
     *
     */
    public static boolean checkValidity(String input) {

        if(input == null || input.equals("") || input.equals(" ")) {
            return false;
        }

        String[] inputArr = input.split(" ");

        if(inputArr.length > 4) {
            return false;
        } else if(inputArr.length == 4 && (!inputArr[0].equals("is") || !inputArr[1].equals("linked"))) {
            return false;
        } else if(inputArr.length < 3) {
            return false;
        }

        return true;
    }

    private static Message getMessageFromInput(String[] inputArr) {
        Message msg = null;

        switch(inputArr[0]) {
            case "add":
//                 System.out.println("ADD!!");
                msg = buildMessage(inputArr[0], inputArr[1], inputArr[2]);
//                 System.out.println(msg.getNode1());
//                 System.out.println(msg.getNode2());
                break;
            case "remove":
//                 System.out.println("REMOVE!!");
                msg = buildMessage(inputArr[0], inputArr[1], inputArr[2]);
//                 System.out.println(msg.getNode1());
//                 System.out.println(msg.getNode2());
                break;
            case "is":
//                 System.out.println("IS LINKED!!");
                msg = buildMessage(inputArr[1], inputArr[2], inputArr[3]);
//                 System.out.println(msg.getNode1());
//                 System.out.println(msg.getNode2());
                break;
            default:
                break;
        }

        return msg;
    }

    /**
     * buildMessage - builds the message that the application
     * would work on
     * mode - run mode type
     * node1 - node 1 to perform the operation on
     * node 2 - node 2 to perform the operation on
     */
    private static Message buildMessage(String mode, String node1, String node2) {

        RunModes runMode = RunModes.valueOf(mode);
//         System.out.println("run mode: " + RunModes.valueOf(mode));
        Message msg = new Message(mode, node1, node2);

        return msg;
    }

    private static void executeOperation(Message msg) {
        switch(msg.getMessageType()) {
            case "add":
                graph.add(msg.getNode1(), msg.getNode2());
                graph.add(msg.getNode2(), msg.getNode1());
//                 graph.iterate();
                break;
            case "remove":
                graph.remove(msg.getNode1(), msg.getNode2());
                graph.remove(msg.getNode2(), msg.getNode1());
//                 graph.iterate();
                break;
            case "linked":
//                 graph.linked(msg.getNode1(), msg.getNode2());
                if(graph.linked(msg.getNode1(), msg.getNode2()) && graph.linked(msg.getNode2(), msg.getNode1())) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
                break;
        }
    }


    public static enum RunModes {
        add,
        remove,
        linked;
    }
}