package com.limt.Lib;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {

    @Test
    void testGenerateRandomPassword() {
        String password = Utils.generateRandomPassword();
        assertNotNull(password, "Generated password should not be null");
        assertTrue(Utils.checkPassword(password), "Generated password should meet the requirements");
    }

    @Test
    void testCheckPassword() {
        assertTrue(Utils.checkPassword("Aa1@56789"), "Password should be valid");
        assertFalse(Utils.checkPassword("password"), "Password without special characters, digits, or uppercase should be invalid");
        assertFalse(Utils.checkPassword("PASSWORD123"), "Password without lowercase letters should be invalid");
        assertFalse(Utils.checkPassword("Aa@1234"), "Password with less than 8 characters should be invalid");
    }

    @Test
    void testCheckEmail() {
        assertTrue(Utils.checkEmail("test@example.com"), "Valid email should return true");
        assertFalse(Utils.checkEmail("test@.com"), "Invalid email should return false");
        assertFalse(Utils.checkEmail("testexample.com"), "Invalid email without @ should return false");
    }

    @Test
    void testCheckBookISBN() {
        assertTrue(Utils.checkBookISBN("123-456-789-0"), "Valid ISBN should return true");
        assertTrue(Utils.checkBookISBN("1234567890123"), "Valid ISBN-13 should return true");
        assertFalse(Utils.checkBookISBN("123456"), "Invalid short ISBN should return false");
    }

    @Test
    void testGeneratedOTP() {
        String otp = Utils.generatedOTP();
        assertNotNull(otp, "Generated OTP should not be null");
        assertEquals(6, otp.length(), "Generated OTP should have 6 digits");
        assertTrue(otp.matches("\\d{6}"), "Generated OTP should contain only digits");
    }
}
