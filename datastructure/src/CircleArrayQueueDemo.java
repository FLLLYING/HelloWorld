import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray arrayQueue = new CircleArray(4);
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


class CircleArray{
    private int MaxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int maxSize) {
        MaxSize = maxSize;
        arr = new int[MaxSize];
    }

    // check if is full
    public boolean isFull() {
        return (rear + 1) % MaxSize == front;
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
        arr[rear] = n;
        rear = (rear + 1) % MaxSize;
        return;
    }

    // get queue entry
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty, can not get Entry!");
        }
        int value = arr[front];
        front = (front + 1) % MaxSize;
        return value;
    }

    // show queue
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, can not show!");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("Arr[%d] = %d\n", i % MaxSize, arr[i % MaxSize]);
        }
        return;
    }

    public int size(){
        return (rear + MaxSize -front) % MaxSize;
    }

    // show queue head
    public int queueHead() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty, can not get data");
        }
        return arr[front];
    }
}
