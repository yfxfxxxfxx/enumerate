package pl.epam.challenge.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class FileUtils {

    /**
     * Class should not be instantiated
     */
    private FileUtils() {}

    public static Optional<String> getFileExtension(String filename) {
        return Optional.ofNullable(filename)
                .filter(fn -> fn.contains("."))
                .map(fn -> fn.substring(filename.lastIndexOf(".") + 1));
    }
}
