package pl.epam.challenge;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import pl.epam.challenge.util.FileSignatureChecker;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileTypeTests {

    private FileSignatureChecker fsc;

    @Before
    public void init() {
        fsc = new FileSignatureChecker("File %d: \n%s");
    }

    @Test
    public void ifIndicatedExtensionIsPngAndFileTypeisJpgThenInauthentic() throws IOException {
        assertEquals(fsc.fileChecker("src/main/resources/static/6S3T53JOWFBGHAVWNJBDWH5MP4.png"),
                "Extension is png, whereas file type is jpg.");
    }

    @Test
    public void ifEmptyFileTypeUnidentified() throws IOException {
        assertEquals(fsc.fileChecker("src/main/resources/static/test.jpg"),
                "Extension is jpg, whereas file type is unidentified.");
    }

    @Test
    public void ifFileExtensionNotSupportedThenExceptionThrown() {
        assertThrows(Exception.class, () ->
                fsc.fileChecker("src/main/resources/static/ogg1.ogg"));
    }

    @Test
    public void ifFileExtensionAccurateThenSuccess() throws IOException {
        assertEquals(fsc.fileChecker("src/main/resources/static/svaneti-mountains.jpg"),
                        "File extension authentic.");
    }
}
