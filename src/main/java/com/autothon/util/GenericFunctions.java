package com.autothon.util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GenericFunctions {
	
	public void ClickWebElement(Actions objAction, WebElement objWebElement)	{
		try	{
			objAction.moveToElement(objWebElement).build().perform();
			objAction.click(objWebElement).build().perform();
			Thread.sleep(3000);
		}
		catch(NoSuchElementException e)	{
			e.printStackTrace();
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
	}

	public void EnterValueInTextbox(WebElement objTextbox, String varValue)	{
		try	{
			objTextbox.sendKeys(varValue);
			Thread.sleep(1000);
		}
		catch(NoSuchElementException e)	{
			e.printStackTrace();
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
	}
	
	public void SelectValueInDropdown(WebElement objDropdown, String varValue)	{
		try	{
			Select objSelect = new Select(objDropdown);
			objSelect.selectByVisibleText(varValue);
			Thread.sleep(3000);
		}
		catch(NoSuchElementException e)	{
			e.printStackTrace();
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
	}
	
	public boolean VerifySelectedValueInDropdown(WebElement objDropdown, String varValue) {
		int flag = 0;
		try	{
			Select objSelect = new Select(objDropdown);
			if(objSelect.getFirstSelectedOption().toString().equalsIgnoreCase(varValue)) {
				flag = 1;
			}
		}
		catch(NoSuchElementException e)	{
			e.printStackTrace();
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
		if(flag == 1) {
			return true;
		}
		else {
			return false;
		}
	}
}
