package pl.epam.challenge.validators;

import java.io.UnsupportedEncodingException;

/**
 * This interface is currently only implemented by one class, because only one file type that must be
 * verified does not have a specific magic number that can be stored in a lookup table. Interface will
 * be useful in case additional file types are added which also require specialized verification logic.
 */

public interface TypeValidator {
    boolean verifyFileType(byte[] bytes) throws UnsupportedEncodingException;
}
