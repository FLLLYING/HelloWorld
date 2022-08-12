package linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及時雨");
        HeroNode2 hero2 = new HeroNode2(2, "盧俊義", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吳用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林衝", "豹子頭");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.addNode(hero1);
        doubleLinkedList.addNode(hero2);
        doubleLinkedList.addNode(hero3);
        doubleLinkedList.addNode(hero4);

        doubleLinkedList.show();

        HeroNode2 node2 = new HeroNode2(4, "l", "y");
        doubleLinkedList.delNode(node2);

        doubleLinkedList.show();
    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    public void show() {
        HeroNode2 temp = head;

        if (head.next == null) {
            System.out.println("This LinkedList is empty!");
            return;
        }
        while (true) {
            temp = temp.next;
            if (temp == null) {
                break;
            }
            System.out.println(temp);
        }
    }

    public void addNode(HeroNode2 hero) {
        HeroNode2 temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = hero;
        hero.pre = temp;
    }

    public void delNode(HeroNode2 heroNode) {
        HeroNode2 temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                return;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
            return;
        } else {
            System.out.println("Node not found!");
        }

    }

    public void updateNode(HeroNode2 heroNode) {
        if (head.next == null) {
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.println("Cant not find the hero!");
        }


    }
}


class HeroNode2 {
    int no;
    String name;
    String nickName;
    HeroNode2 next;
    HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return no + "." + name + ":" + nickName;
    }
}
