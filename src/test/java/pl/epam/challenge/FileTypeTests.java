package pl.epam.challenge;


import org.junit.jupiter.api.Test;
import pl.epam.challenge.exceptions.UnsupportedExtensionException;
import pl.epam.challenge.util.FileSignatureChecker;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileTypeTests {

    private FileSignatureChecker fsc = new FileSignatureChecker("File %d: \n%s");

    @Test
    public void ifIndicatedExtensionIsPngAndFileTypeisJpgThenInauthentic() throws IOException {
        String result = fsc.fileChecker("src/main/resources/static/6S3T53JOWFBGHAVWNJBDWH5MP4.png");
        assertEquals(result,
                "Extension is png, whereas file type is jpg.");
    }

    @Test
    public void ifEmptyFileTypeUnidentified() throws IOException {
        assertEquals(fsc.fileChecker("src/main/resources/static/test.jpg"),
                "Extension is jpg, whereas file type is unidentified.");
    }

    @Test
    public void ifFileExtensionNotSupportedThenExceptionThrown() {
        assertThrows(UnsupportedExtensionException.class, () ->
                fsc.fileChecker("src/main/resources/static/ogg1.ogg"));
    }

    @Test
    public void ifFileExtensionAccurateThenSuccess() throws IOException {
        assertEquals(fsc.fileChecker("src/main/resources/static/svaneti-mountains.jpg"),
                        "File extension authentic.");
    }
}
