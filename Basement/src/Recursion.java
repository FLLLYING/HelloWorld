public class Recursion {

    public static void main(String[] args) {
        Recursion recursion = new Recursion();

        System.out.println(recursion.recursion(10));
    }

    public int recursion(int n){
        if(n==1){
            return 1;
        }else {
            return n*recursion(n-1);
        }

    }

}
