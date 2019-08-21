package com.autothon.assertions;

import org.testng.asserts.Assertion;

public class HardAssertion {

	public static void assertEqual(String actual, String expected)
			throws Exception {
		try {
			Assertion hardAssertion = new Assertion();
			hardAssertion.assertEquals(actual, expected);
		} catch (Exception var3) {
			var3.printStackTrace();
		}

	}

	public static void assertEqual(Number actual, Number expected)
			throws Exception {
		try {
			Assertion hardAssertion = new Assertion();
			hardAssertion.assertEquals(actual, expected);
		} catch (Exception var3) {
			var3.printStackTrace();
		}

	}

	public static void assertEqual(boolean actual, boolean expected)
			throws Exception {
		try {
			Assertion hardAssertion = new Assertion();
			hardAssertion.assertEquals(actual, expected);
		} catch (Exception var3) {
			var3.printStackTrace();
		}

	}

	public static void assertTrue(boolean expected) throws Exception {
		try {
			Assertion hardAssertion = new Assertion();
			hardAssertion.assertTrue(expected);
		} catch (Exception var2) {
			var2.printStackTrace();
		}

	}
}
