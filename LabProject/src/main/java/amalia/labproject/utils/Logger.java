package amalia.labproject.utils;

import java.io.*;

/**
 *  Singleton pattern
 */
public class Logger {
    private static OutputStream os;

    private static void initOS() {
        try {
            os = new FileOutputStream(new File("D:\\Faculty\\Sem6\\Design Patterns\\LabProject\\logs.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void log(String data) {
        if (os == null)
            initOS();
        try {
            data += "\n";
            Logger.os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

