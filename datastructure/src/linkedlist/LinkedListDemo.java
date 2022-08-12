package linkedlist;

public class LinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及時雨");
        HeroNode hero2 = new HeroNode(2, "盧俊義", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吳用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林衝", "豹子頭");

        LinkedList linkedList = new LinkedList();
//        linkedList.addNode(hero1);
//        linkedList.addNode(hero2);
//        linkedList.addNode(hero3);
//        linkedList.addNode(hero4);
//

        linkedList.addByOrder(hero1);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero3);
        linkedList.addByOrder(hero2);
        linkedList.show();
//        HeroNode node = new HeroNode(5, "小盧", "玉麒麟~~");
//        linkedList.updateNode(node);
//        System.out.println("Show updated!");
//        linkedList.show();

        linkedList.delNode(hero1);
        linkedList.delNode(hero2);
        linkedList.delNode(hero3);
        linkedList.delNode(hero4);
        System.out.println("After delete:");
        linkedList.show();

    }
}


class LinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead(){
        return head;
    }

    // add node
    public void addNode(HeroNode hero) {
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = hero;
    }


    // add by order
    public void addByOrder(HeroNode hero) {
        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > hero.no) {
                break;
            }
            if (temp.next.no == hero.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("Hero alread exist, can not insert!");
            return;
        }

        hero.next = temp.next;
        temp.next = hero;

    }

    public void updateNode(HeroNode heroNode){
        if (head.next == null) {
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if(temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.println("Cant not find the hero!");
        }


    }


    // delete node
    public void delNode(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;

        while(true) {
            if (temp.next == null){
                return;
            }
            if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            temp.next = temp.next.next;
            return;
        }else{
            System.out.println("Node not found!");
        }

    }

    // show all hero
    public void show() {
        HeroNode temp = head;

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
}

// hero node
class HeroNode {
    int no;
    String name;
    String nickName;
    HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return no + "." + name + ":" + nickName;
    }
}
