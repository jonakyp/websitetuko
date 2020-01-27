package common;


import org.testng.Assert;

public class AssertionHelpers {

    public static void verifyText(String s1, String s2) {
        Assert.assertEquals(s1, s2);
    }

    public static void verifyTrue(boolean status) {
        Assert.assertTrue(status);
    }

    public static void verifyFalse(boolean status) {
        Assert.assertFalse(status);
    }

    public static void fail() {
        Assert.assertTrue(false);
    }

    public static void pass() {
        Assert.assertTrue(true);
    }

    public static void updateTestStatus(boolean status) {
        if (status) {
            pass();
        } else {
            fail();
        }

    }
}
