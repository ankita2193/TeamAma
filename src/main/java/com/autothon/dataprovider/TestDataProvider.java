package com.autothon.dataprovider;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider(name = "UpdateTravelPrefs")
	public static Object[][] getDataForCreatingNewProject() {

		return new Object[][] {

				{ "S3KPBX", "Asian vegetarian meal" } };
	}
}
