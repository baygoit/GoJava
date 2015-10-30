import java.util.Scanner;

/**
 * Created by Dmytro on 22.10.2015.
 */
public class HelloWorldGreeter {
    public static void main(String[] args) {
        HelloWorldGreeter greeter = new HelloWorldGreeter();
        greeter.sayHello();
    }

    public void sayHello() {
        System.out.println("Enter your name");

        Scanner scanIn = new Scanner(System.in);
        String name = scanIn.nextLine();
        scanIn.close();

        System.out.printf("Hello, %s!", name);
    }
}
