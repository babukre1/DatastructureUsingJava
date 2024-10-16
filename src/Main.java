import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Main {



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Type some text t reverse");

        String original = input.next();
        StringBuffer reversed = new StringBuffer();
        long startTime = System.nanoTime();
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed.append(original.charAt(i));
        }
        long endTime = System.nanoTime();
        

        System.out.println(endTime - startTime);

        System.out.println(reversed.toString());
    }
}