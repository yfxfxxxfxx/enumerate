package pl.epam.challenge.util;

import pl.epam.challenge.exceptions.UnsupportedExtensionException;

import java.io.IOException;
import java.util.Map;

public class FileSignatureChecker {

    String formatter;

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

    public FileSignatureChecker(String formatter) {
        this.formatter = formatter;
    }

    public String getFormatter() {
        return formatter;
    }

    public String fileChecker(String filename) throws IOException {

        String currentFileExtension = FileUtils
                .getFileExtension(filename)
                .orElse("");

        byte[] bytes = FileUtils.getByteSignature(filename);

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

    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();

        for (byte b : bytes) {
            char[] hexDigits = new char[2];
            hexDigits[0] = Character.forDigit((b >> 4) & 0xF, 16);
            hexDigits[1] = Character.forDigit((b & 0xF), 16);
            hexString.append(new String(hexDigits)).append(" ");
        }

        return String.valueOf(hexString);
    }
}
