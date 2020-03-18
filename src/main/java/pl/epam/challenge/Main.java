package pl.epam.challenge;

import pl.epam.challenge.util.FileSignatureChecker;

public class Main {
    public static void main(String[] args) {
        FileSignatureChecker fsc = new FileSignatureChecker();

        int currentArg = 0;

        while(currentArg < args.length) {
            fsc.fileChecker(args[currentArg]);
            currentArg++;
        }
    }
}
