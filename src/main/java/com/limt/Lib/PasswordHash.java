package com.limt.Lib;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.HexFormat;

public class PasswordHash {
    private String SALT;
    private final Integer numberOfIterations;
    private final Integer keyLength;
    private final String Algorithm;

    public PasswordHash() {
        numberOfIterations = 32768;
        keyLength = 128;
        Algorithm = "PBKDF2WithHmacSHA256";
        SALT = GeneratedSalt();
    }

    private String GeneratedSalt() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];  // 16 byte = 128 bit
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }

    public String HashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), SALT.getBytes(), numberOfIterations, keyLength);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(Algorithm);
        return Base64.getEncoder().encodeToString(keyFactory.generateSecret(spec).getEncoded());
    }

    public boolean VerifyPassword(String password, String hashedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), SALT.getBytes(), numberOfIterations, keyLength);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(Algorithm);
        return Base64.getEncoder().encodeToString(keyFactory.generateSecret(spec).getEncoded()).equals(hashedPassword);
    }
}
