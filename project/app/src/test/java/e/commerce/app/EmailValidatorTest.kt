package e.commerce.app

import e.commerce.app.utils.isValidEmail
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue("name@email.com".isValidEmail())
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse("name@email".isValidEmail())
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(null.isValidEmail())
    }




}