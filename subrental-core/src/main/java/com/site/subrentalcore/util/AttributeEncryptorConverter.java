package com.site.subrentalcore.util;

import jakarta.persistence.AttributeConverter;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AttributeEncryptorConverter implements AttributeConverter<String, String> {

    private static final String SECRET = "gnillib-20201101";

    private final AES256Util aes256Util;

    public AttributeEncryptorConverter() {
        aes256Util = new AES256Util(SECRET);
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        try {
            if (attribute == null) {
                return null;
            }
            return aes256Util.aesEncode(attribute);
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException | NoSuchAlgorithmException |
                 NoSuchPaddingException | InvalidAlgorithmParameterException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        try {
            if (dbData == null) {
                return null;
            }
            return aes256Util.aesDecode(dbData);
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException e) {
            throw new IllegalStateException(e);
        }
    }
}
