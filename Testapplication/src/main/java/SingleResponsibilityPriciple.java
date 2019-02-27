import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SingleResponsibilityPriciple {
    public static void main(String[] args) throws Exception {
        Journal j = new Journal();
        j.addEntry("i enjoyed today");
        j.addEntry("i played today");
        System.out.println(j);

        Repository repository = new Repository();
        String filename = "c:\\temp\\journal.txt";
        repository.saveToFile(j, filename, true);

        Runtime.getRuntime().exec("notepad.exe " + filename);
    }

}

class Journal {
    List<String> entries = new ArrayList<>();
    private int count = 0;

    public List<String> addEntry(String entry) {
        entries.add(++count + ": " + entry);
        return entries;
    }

    public Boolean removeEntry(String entry) {
        return entries.remove(entry);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }
}

class Repository {
    public void saveToFile(Journal journal, String fileName, boolean overWrite) throws FileNotFoundException {
        if (overWrite || new File(fileName).exists()) {
            try (PrintStream out = new PrintStream(fileName)) {
                out.println(journal.toString());
            }
        }
    }
}

