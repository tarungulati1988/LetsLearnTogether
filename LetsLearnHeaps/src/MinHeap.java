/**
 * Created by tgulati on 4/17/16.
 */
public class MinHeap {
    public int size;
    public int[] minHeapArr;
    public int position;

    public MinHeap(int size) {
        this.size = size;
        minHeapArr = new int[size + 1];
        position = 0;
    }

    public void createHeap(int[] arrA) {
        if (arrA.length > 0) {
            for (int i = 0; i < arrA.length; i++) {
                insert(arrA[i]);
            }
        }
    }

    public void display() {
        for (int i = 1; i < minHeapArr.length; i++) {
            System.out.println(minHeapArr[i]);
        }
    }

    public void insert(int x) {
        if (position == 0) {
            minHeapArr[position + 1] = x;
            position = 2;
        } else {
            minHeapArr[position++] = x;
            bubbleUp();
        }
    }

    public void bubbleUp() {
        int pos = position - 1;
        while (pos > 0 && minHeapArr[pos / 2] > minHeapArr[pos]) {
            int y = minHeapArr[pos];
            minHeapArr[pos] = minHeapArr[pos / 2];
            minHeapArr[pos / 2] = y;
            pos = pos / 2;
        }
    }

    public int min() {
        int min = minHeapArr[1];
        minHeapArr[1] = minHeapArr[position - 1];
        minHeapArr[position - 1] = 0;
        position--;
        sinkDown(1);
        return min;
    }

    public void sinkDown(int k) {
        int a = minHeapArr[k];
        int smallest = k;
        if (2 * k < position && minHeapArr[smallest] > minHeapArr[2 * k]) {
            smallest = 2 * k;
        }
        if (2 * k + 1 < position && minHeapArr[smallest] > minHeapArr[2 * k + 1]) {
            smallest = 2 * k + 1;
        }
        if (smallest != k) {
            swap(k, smallest);
            sinkDown(smallest);
        }

    }

    public void swap(int a, int b) {
        int temp = minHeapArr[a];
        minHeapArr[a] = minHeapArr[b];
        minHeapArr[b] = temp;
    }

    public static void main(String args[]) {
        int arr[] = {3, 2, 1, 7, 8, 4, 10, 16, 12};

        MinHeap minHeap = new MinHeap(arr.length);

        System.out.println("Min-Heap: ");
        minHeap.createHeap(arr);
        minHeap.display();

        System.out.print("Extract Min:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(minHeap.min());
        }

    }


}
