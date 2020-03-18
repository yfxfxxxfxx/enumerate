package pl.epam.challenge;

import pl.epam.challenge.exceptions.UnsupportedExtensionException;
import pl.epam.challenge.util.FileSignatureChecker;

public class Main {
    public static void main(String[] args) {
        FileSignatureChecker fsc = new FileSignatureChecker("File %d: \n%s");
        int currentArg = 0;

        while (currentArg < args.length) {
            try {
                System.out.println(String.format(
                        fsc.getFormatter(),
                        currentArg,
                        fsc.fileChecker(args[currentArg])));
            } catch (UnsupportedExtensionException e) {
                System.out.println(String.format(
                        fsc.getFormatter(),
                        currentArg,
                        "File extension not recognized: " + e.getMessage()));
            }

            currentArg++;
        }
    }
}
