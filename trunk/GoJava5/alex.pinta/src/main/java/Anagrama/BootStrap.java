package Anagrama;
/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 18.07.15
 * Time: 17:19
 * @version: 1.0
 */
public class BootStrap {

    public static void main(String args[]){
        Input input = new Input(System.in);
        Output output = new Output();
        Anagram anagram;
        while (true){
            output.writeln("Input string for anagram operation: ");
            String inputString = input.inputString();
            if (inputString.equalsIgnoreCase("Q")){
                break;
            }
            anagram =  new Anagram(inputString);
            output.writeln(anagram.replace());
        }
    }
}
