package linkedlist;

import java.util.Stack;

public class ReverseLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及時雨");
        HeroNode hero2 = new HeroNode(2, "盧俊義", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吳用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林衝", "豹子頭");

        LinkedList list = new LinkedList();
        list.addNode(hero1);
        list.addNode(hero2);
        list.addNode(hero3);
        list.addNode(hero4);

        list.show();

//        ReverseLinkedList.reverseLinkedList(list.getHead());
        ReverseLinkedList.printReverseLinkedList(list.getHead());
        System.out.println("After reverse!");
        list.show();

    }
}

class ReverseLinkedList{
    public static void reverseLinkedList(HeroNode headNode) {
        if (headNode.next == null & headNode.next.next == null){
            return;
        }

        HeroNode temp = headNode.next;
        HeroNode next;
        HeroNode reverse = new HeroNode(0,"","");
        while(true){
            if (temp == null) {
                break;
            }
            next = temp.next;
            temp.next = reverse.next;
            reverse.next = temp;
            temp = next;
        }
        headNode.next = reverse.next;
        return;
    }

    public static void printReverseLinkedList(HeroNode heroNode) {
        if (heroNode.next == null) {
            return;
        }
        HeroNode cur = heroNode.next;
        Stack<HeroNode> stack = new Stack<>();
        while(cur!=null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }
}

