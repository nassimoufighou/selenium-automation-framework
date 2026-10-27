package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirectoryUtils {

    public static Path createDirectory(String name, Path path) {
        try {
            return Files.createDirectories(Path.of(String.valueOf(path), name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean directoryExists(Path path) {
        return Files.exists(path);
    }
}
