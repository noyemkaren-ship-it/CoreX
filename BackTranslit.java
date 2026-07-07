import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class BackTranslit {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Укажите исходный и целевой файлы");
            return;
        }

        Path sourcePath = Paths.get(args[0]);
        Path targetPath = Paths.get(args[1]);

        try {
            List<String> allLines = Files.readAllLines(sourcePath);
            List<String> outputLines = new ArrayList<>();
            
            final String INCLUDE_PREFIX = "#include <";
            final String MAIN_PREFIX = "int main";
            
            for (String line : allLines) {
                String strippedLine = line.strip();
                
                if (strippedLine.startsWith(INCLUDE_PREFIX)) {
                    String afterInclude = strippedLine.substring(INCLUDE_PREFIX.length());
                    outputLines.add("import " + afterInclude);
                } else if (strippedLine.startsWith(MAIN_PREFIX)) {  // исправлено: strippedLine
                    String afterIntMain = strippedLine.substring(MAIN_PREFIX.length());  // исправлено: константа
                    outputLines.add("_main" + afterIntMain);
                } else {
                    outputLines.add(line.toUpperCase());
                }
            }

            Files.write(targetPath, outputLines,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Файл успешно обработан!");

        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}