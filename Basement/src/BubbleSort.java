import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static int[] bubbleSort(int[] i){
        int l = i.length;
        for(int j = 0; j < i.length-1; j++) {
            for (int k = 0; k < i.length - 1 - j; k++) {
                if(i[k]>i[k+1]){
                    int tmp = i[k];
                    i[k] = i[k+1];
                    i[k+1] = tmp;
                }
            }
        };

        return i;
    }
    public static void main(String args[]){
        int i[] = new int[10];
        for (int j = 0; j < 10; j++){
            System.out.println("Enter Number:");
            i[j] = new Scanner(System.in).nextInt();
        }

        int p[] = bubbleSort(i);
        System.out.println(Arrays.toString(p));
        for (int z = 0; z<p.length;z++){
            System.out.print(p[z] + " ");
        }
    }

}
