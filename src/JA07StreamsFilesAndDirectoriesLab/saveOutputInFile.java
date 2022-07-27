package JA07StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class saveOutputInFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = "src/JA07streamsFilesAndDirectoriesLab/input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            FileOutputStream outputStream = new FileOutputStream("src/JA07streamsFilesAndDirectoriesLab/output.txt");
            int read = inputStream.read();

            while (read != -1) {
                outputStream.write(read);
                read = inputStream.read();
            }

        } catch (IOException ignored) {
        }
    }
}
