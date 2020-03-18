package pl.epam.challenge.validators;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public class TxtValidator implements TypeValidator {
    @Override
    public boolean verifyFileType(byte[] bytes) throws UnsupportedEncodingException {
        Pattern p = Pattern.compile("\\A(\n" +
                "[\\x09\\x0A\\x0D\\x20-\\x7E]               \\n" +
                "| [\\xC2-\\xDF][\\x80-\\xBF]               \n" +
                "| \\xE0[\\xA0-\\xBF][\\x80-\\xBF]          \n" +
                "| [\\xE1-\\xEC\\xEE\\xEF][\\x80-\\xBF]{2}  \n" +
                "| \\xED[\\x80-\\x9F][\\x80-\\xBF]          \n" +
                "| \\xF0[\\x90-\\xBF][\\x80-\\xBF]{2}       \n" +
                "| [\\xF1-\\xF3][\\x80-\\xBF]{3}            \n" +
                "| \\xF4[\\x80-\\x8F][\\x80-\\xBF]{2}       \n" +
                ")*\\z");

        String stringArg = new String(bytes, "ISO-8859-1");
        return p.matcher(stringArg).matches();
    }
}
