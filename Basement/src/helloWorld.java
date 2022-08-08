import org.omg.Messaging.SyncScopeHelper;

import java.util.Scanner;
import java.util.jar.JarEntry;

public class helloWorld {
    int i = -12,j = 5;
     public static void main(String[] args) {
         int i = 12,j = -5;
        System.out.println("hello world!");
         System.out.println("m1 % n1 = " + i % j);
         Scanner scanner = new Scanner(System.in);

         System.out.println("Enter You Name:");

         String name = scanner.next();
         System.out.println("Enter You Age:");
         int age = scanner.nextInt();

     }
}
