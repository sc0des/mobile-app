package e.commerce.app

import e.commerce.app.utils.isNull
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class ValidatorTest {

    // test for null value entered for the email and password fields

    // null values failed
    @Test
    fun nullValidator_NullCorrectEmailPassSimple_ReturnsTrue() {
        assertTrue("".isNull() && "".isNull())
    }

    // not null passed
    @Test
    fun nullValidator_CorrectEmailPassSimple_ReturnsTrue() {
        assertTrue("test@testmail.com".isNull() && "123456".isNull())
    }

}