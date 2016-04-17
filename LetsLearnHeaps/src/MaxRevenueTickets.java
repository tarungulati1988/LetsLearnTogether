import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by tgulati on 4/17/16.
 */
public class MaxRevenueTickets {

    PriorityQueue<Integer> priorityQueue;

    public MaxRevenueTickets(int length) {
        priorityQueue = new PriorityQueue<Integer>(length, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public int calculate(int[] windowsTickets, int tickets) {

        int revenue = 0;
        for (int i = 0; i < windowsTickets.length; i++) {
            priorityQueue.offer(windowsTickets[i]);
        }

        while (tickets > 0) {
            int ticketPrice = priorityQueue.poll();
            revenue += ticketPrice;
            priorityQueue.offer(--ticketPrice);
            tickets--;
        }
        return revenue;
    }

    public static void main(String[] args) {

        int[] windowsTickets = {5, 1, 7, 10, 11, 9};
        int noOfTickets = 5;

        MaxRevenueTickets maxRevenueTickets = new MaxRevenueTickets(windowsTickets.length);
        System.out.println("Selling: " + noOfTickets + " revenue: " + maxRevenueTickets.calculate(windowsTickets, noOfTickets));

    }
}