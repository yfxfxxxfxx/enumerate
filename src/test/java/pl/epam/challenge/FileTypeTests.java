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
        assertEquals(fsc.fileChecker("src/main/resources/static/6S3T53JOWFBGHAVWNJBDWH5MP4.png"),
                "Extension is png, whereas file type is jpg.");
    }

    @Test
    public void ifExtensionTxtButNotTxtThenInauthentic() throws IOException {
        assertEquals(fsc.fileChecker("src/main/resources/static/fakeOgg2.txt"),
                "Extension is txt, whereas file type is ogg.");
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
    public void ifFileUnreadableThenIOException() {
        assertThrows(IOException.class, () ->
                fsc.fileChecker("src/main/resources/static/asdfasdf.txt"));
    }

    @Test
    public void ifNoFileExtensionThenExceptionThrown() {
        assertThrows(UnsupportedExtensionException.class, () ->
                fsc.fileChecker("src/main/resources/static/Procfile"));
    }

    @Test
    public void ifFileExtensionAccurateThenSuccess() throws IOException {
        assertEquals(fsc.fileChecker("src/main/resources/static/svaneti-mountains.jpg"),
                        "File extension authentic.");
    }
}
