package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class Main {

    private static boolean notJunk(String strLine){
        if(strLine.substring(strLine.indexOf(" ") + 1) != null) return true;
        return false;
    }

    private static void readFile(String qFile, String aFile, String outFile) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(
                new DataInputStream(new FileInputStream(new File(qFile)))));

        BufferedReader br2 = new BufferedReader(new InputStreamReader(
                new DataInputStream(new FileInputStream(new File(aFile)))));

        String strLine = br.readLine();
        String correctAnswer;

        br2.readLine(); // To remove junk into
        int questionNumber = 0;

        // Writes everything in new file using mark up
        try (Writer writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outFile)))) {
            while (strLine != null) {
                //If it is a question
                if (Character.isDigit(strLine.charAt(0)) && notJunk(strLine)) {
                    questionNumber++;
                    writer.write("~~~" + "\n" + "test" + "\n" + questionNumber + "." + strLine.substring(strLine.indexOf(" "))
                                +"\n");
                    System.out.println(strLine);
                    strLine = br.readLine();
                    while (Character.isDigit(strLine.charAt(0)) || strLine.charAt(0) == 'I') {
                        if (notJunk(strLine)) {
                            writer.write(strLine.substring(strLine.indexOf(" ") + 1) + "\n");
                            System.out.println(strLine);
                            strLine = br.readLine();
                        }
                    }
                }
                // If it is a possible answer
                if (!Character.isDigit(strLine.charAt(0)))
                {
                    correctAnswer = br2.readLine();
                    while(!Character.isDigit(strLine.charAt(0)) && strLine.charAt(0) != 'I') {
                        if (correctAnswer.substring(correctAnswer.indexOf(".") - 1, correctAnswer.indexOf("."))
                                .equals(strLine.substring(0, strLine.indexOf(" ")))) {
                            writer.write(strLine + "@1.0" + "\n");
                        } else {
                            writer.write(strLine + "@0.0" + "\n");
                        }
                        strLine = br.readLine();
                        //case for the last question
                        if(strLine==null) {
                            break;
                        }
                    }
                    writer.write("???"+"\n"+correctAnswer.substring(correctAnswer.indexOf(" ")+1)+"\n");
                }
                strLine = br.readLine();
            }
            System.out.println("Your file was created and changed");
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws IOException {
        boolean result;
        File file = new File("MarkedUp.txt");
        try {
            result = file.createNewFile();
            if (result) {
                System.out.println("file created " + file.getCanonicalPath());
            } else {
                System.out.println("File already exist at location: " + file.getCanonicalPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        readFile(args[0],args[1],args[2]);
    }
}