package KickStarter;

import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 02.07.15
 * Time: 4:45
 * @version: 1.0
 */
public class Output {
    private OutputStream output;
    private StringBuilder accumulativeMultiLine = new StringBuilder();
    public Output(OutputStream output) {
        this.output = output;
    }

    public void writeln(String prompt){
        accumulativeMultiLine.append(prompt + "\n");
//        System.out.println(prompt);
    }
    public void write(String prompt){
        accumulativeMultiLine.append(prompt);
//        System.out.print(prompt);
    }
    public void replace(String prompt, String replacement){
        int index = accumulativeMultiLine.indexOf(replacement);
        accumulativeMultiLine.replace(index, index + replacement.length(), prompt);

    }
    public void clear(){
//        Runtime runtime = Runtime.getRuntime();
//        try {
//            Process process = runtime.exec("cls"); //linux - "clear", windows - "cls"
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //System.out.println ("\u001b[2J");
    }

    public StringBuilder getAccumulativeMultiLine(boolean clear) {
        StringBuilder tmp = accumulativeMultiLine;
        if (clear){
            accumulativeMultiLine = new StringBuilder();
        }
        return tmp;
    }

    public void show(){
        System.out.print(accumulativeMultiLine.toString());
        accumulativeMultiLine = new StringBuilder();
    }
}
