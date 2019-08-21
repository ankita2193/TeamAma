package com.autothon.assertions;

import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	public static void assertEqual(String actual, String expected)
			throws Exception {
		try {
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actual, expected);
		} catch (Exception var3) {
			var3.printStackTrace();
		}

	}

	public static void assertEqual(Number actual, Number expected)
			throws Exception {
		try {
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actual, expected);
		} catch (Exception var3) {
			var3.printStackTrace();
		}

	}

	public static void assertEqual(boolean actual, boolean expected)
			throws Exception {
		try {
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actual, expected);
		} catch (Exception var3) {
			var3.printStackTrace();
		}

	}

	public static void assertTrue(boolean expected) throws Exception {
		try {
			SoftAssert soft = new SoftAssert();
			soft.assertTrue(expected);
		} catch (Exception var2) {
			var2.printStackTrace();
		}

	}
}