/**
 * Created by Alessandro Arosio on 20/03/2017.
 */
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;

public class readerTest {
    public static void main(String[] args) throws IOException {
        try {
            /** Create a GUI */
            String path =JOptionPane.showInputDialog("Input path and file name:");
            File file = new File(path);

            PrintWriter newFile = new PrintWriter("C:\\Users\\alessandro arosio\\Desktop\\newFile.txt");
            Scanner scanner = new Scanner(file);
            JOptionPane.showMessageDialog(null, "New file created in the desktop");
            int DSPcounter = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Carrier card serial"))
                {
                    newFile.print(line);
                    newFile.println();
                    newFile.print("DSPs:");
                    newFile.println();
                }
                if (line.contains("SerialNumber:")) {
                    newFile.print(line.substring(18, 23)+", ");
                    System.out.println(line.substring(18, 23));
                    DSPcounter++;
                }
            }
            newFile.println();
            newFile.println("Total of: " + DSPcounter + " DSP");
            System.out.println("Total of: " + DSPcounter + " DSP");
            newFile.close();
        }
        catch (IOException ioe) {
            JOptionPane.showMessageDialog(null,"IO Exception: File not found, check path name");
            System.out.println("IO Exception: File not found, check path name.");
        }
    }
}