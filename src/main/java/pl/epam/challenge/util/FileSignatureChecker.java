package pl.epam.challenge.util;

import pl.epam.challenge.exceptions.UnsupportedExtensionException;

import java.util.Map;

public class FileSignatureChecker {

    // Map.of() used for readability, if number of keys grows beyond 10
    // can replace with Arrays.stream().collect(Collectors.toMap())
    public static final Map<String, String> KNOWN_SIGNATURES = Map.of(
            "jpg", "ff d8 ff",
            "gif", "47 49 46 38",
            "png", "89 50 4e 47 0d 0a 1a 0a",
            "exe", "4d 5a",
            "ogg", "4f 67 67 53",
            "mp3", "ff fb",
            "pdf", "25 50 44 46 2d"
    );

    public String fileChecker(String filename) {

        String currentFileExtension = FileUtils
                .getFileExtension(filename)
                .orElse("File extension not recognized.");

        switch (currentFileExtension) {
            case "jpg":
            case "gif":
                return "ok";
            case "txt":
                return "ok txt";
            default:
                throw new UnsupportedExtensionException(currentFileExtension);
        }
    }
}
