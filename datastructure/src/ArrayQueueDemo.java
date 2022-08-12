import sun.reflect.generics.tree.ReturnType;

import java.security.Key;
import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("S:Show Queue");
            System.out.println("E:Exit");
            System.out.println("A:Add Data");
            System.out.println("G:Get Data");
            System.out.println("H:Head");
            key = scanner.next().charAt(0);
            switch (key) {
                case 'S':
                    arrayQueue.showQueue();
                    break;

                case 'A':
                    System.out.println("Enter a number:");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;

                case 'G':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("Get data is %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'H':
                    try {
                        int res = arrayQueue.queueHead();
                        System.out.printf("Queue head is %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'E': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}

class ArrayQueue {
    private int MaxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        MaxSize = maxSize;
        arr = new int[MaxSize];
        front = -1;
        rear = -1;
    }

    public ArrayQueue() {

    }

    // check if is full
    public boolean isFull() {
        return rear == MaxSize - 1;
    }

    // check if is empty
    public boolean isEmpty() {
        return front == rear;
    }

    // add queue entry
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("Queue if Full, cant not add new Entry!");
            return;
        }
        rear++;
        arr[rear] = n;
        return;
    }

    // get queue entry
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty, can not get Entry!");
        }
        front++;
        return arr[front];
    }

    // show queue
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, can not show!");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Arr[%d] = %d\n", i, arr[i]);
        }
        return;
    }

    // show queue head
    public int queueHead() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty, can not get data");
        }
        return arr[front + 1];
    }
}
