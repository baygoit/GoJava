import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
	public void writeToFile(File fileNname, String string) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNname, true));
        try {
        	bufferedWriter.write(string);
            bufferedWriter.newLine();
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
