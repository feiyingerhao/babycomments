package main.java.general;

public class FileSaver {
    public static void saveContentToPath(String content, String path) {
        Recorder saver = new Recorder(Recorder.formatFileName(path));
        saver.writeRecord(content);
    }
}