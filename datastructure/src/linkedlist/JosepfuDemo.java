package linkedlist;
public class JosepfuDemo {
    public static void main(String[] args) {
        CircleLinkedList josepfu = new CircleLinkedList();
        josepfu.showBoy();
        josepfu.addBoy(5);
        josepfu.showBoy();
        josepfu.countBoy(1,2,5);
    }
}

class CircleLinkedList {
    private Boy first = null;

    public void addBoy(int num) {
        Boy cur = null;
        if (num < 1) {
            System.out.println("Wrong Number!");
            return;
        }
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
//            System.out.println(boy);
            if (i == 1) {
                first = boy;
                first.next = first;
                cur = first;
            } else {
                cur.next = boy;
                boy.next = first;
                cur = boy;
            }
        }

    }

    public void showBoy() {
        Boy cur = first;
        if (cur == null) {
            System.out.println("Is empty!");
            return;
        }
        while (true) {
            System.out.println(cur);
            if (cur.next == first) {
                break;
            }
            cur = cur.next;
        }
    }

    public void countBoy(int startNo,int countNo,int num){
         if (first == null || startNo < 1 || startNo > num) {
             System.out.println("Input parameter error!");
             return;
         }

         Boy helper = first;

         while (true) {
             if (helper.next == first){
                 break;
             }
             helper = helper.next;
         }
         // move to start NO
        for (int j = 1; j < startNo; j++){
            first = first.next;
            helper = helper.next;
        }

        while (true){
            if (helper == first){
                break;
            }

            for (int j = 1; j<countNo; j++){
                first = first.next;
                helper = helper.next;
            }
            System.out.println("Boy NO." + first.getNo() + " out.");
            helper.next = first.next;
            first = first.next;
        }
        System.out.println("The last one boy is" +first);
    }

}


class Boy {
    private int no;
    Boy next = null;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boys No." + no;
    }
}
