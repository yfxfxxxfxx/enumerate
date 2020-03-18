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

    public static byte[] getByteSignature(String path) throws IOException {
        // hardcoded number of bytes to read because time and space costs are insignificant
        // overloaded method can be added if more flexibility is required
        return Files.newInputStream(Paths.get(path)).readNBytes(16);
    }
}
