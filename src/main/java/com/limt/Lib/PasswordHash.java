package com.limt.Lib;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class PasswordHash {
    private String SALT;
    private final int numberOfIterations;
    private final int keyLength;
    private final String Algorithm;

    public PasswordHash() {
        numberOfIterations = 65536;
        keyLength = 128;
        Algorithm = "PBKDF2WithHmacSHA256";
        SALT = GeneratedSalt();
    }

    private String GeneratedSalt() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16]; // 16 byte = 128 bit
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes); // Mã hóa thành chuỗi Base64
    }

    public String hashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), SALT.getBytes(), numberOfIterations, keyLength);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(Algorithm);
        byte[] hash = factory.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(hash); // Mã hóa thành chuỗi Base64
    }

    public boolean verifyPassword(String password, String hashedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), SALT.getBytes(), numberOfIterations, keyLength);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(Algorithm);
        byte[] hash = factory.generateSecret(spec).getEncoded();
        String generatedHash = Base64.getEncoder().encodeToString(hash);
        return generatedHash.equals(hashedPassword);
    }

    public String getSalt() {
        return SALT;
    }

    public void setSalt(String SALT) {
        this.SALT = SALT;
    }
}
