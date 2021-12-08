package common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFile {

    public String getFileData(Path pathToFile) throws IOException {
        return Files.readString(pathToFile);
    }
}
