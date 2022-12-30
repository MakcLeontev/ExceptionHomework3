package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
    String line;
    String fileName;

    public FileService(String line, String fileName) {
        this.line = line;
        this.fileName = fileName;
    }

    public FileService() {
    }

    public boolean availabilityFile(String fileName) {
        String name = fileName + ".txt";
        File file = new File(name);
        return file.exists();
    }

    public void createFile(String fileName) {
        String name = fileName + ".txt";
        File file = new File(name);
        try {
            if (file.createNewFile()) {
                System.out.println("файл создан");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String fileName, String line) {
        try (FileWriter writer = new FileWriter(fileName + ".txt", true)) {
            writer.write(line);
            writer.append('\n');
            System.out.println("запись в файл: ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
