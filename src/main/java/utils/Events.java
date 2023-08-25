package main.java.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Events {

	public static void writeOnInput(WebElement element, String value) {
		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();
		if (element.isDisplayed() && element.isEnabled()) {
			String nameInput = Utils.inputName(element);
			int caracteres = element.getAttribute("value").toCharArray().length;
			for (int i = 0; i < caracteres; i++) {
				element.sendKeys(Keys.BACK_SPACE);
			}
			element.sendKeys(value);
			Utils.outputInfo("Se ha ingresado el texto '" + value + "' en el campo: " + nameInput);
		} else {
			String nameInput = Utils.inputName(element);
			Utils.eventFailed(currentEvent, "El campo '" + nameInput + "' no se encuentra habilitado o desplegado");
		}
	}

	public static void clickButton(WebElement element) {
		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();
		if (element.isEnabled()) {
			String name = Utils.buttonName(element);
			element.click();
			Utils.outputInfo("Se ha hecho clic en el botón: " + name);
		} else {
			String name = element.getAttribute("text");
			Utils.eventFailed(currentEvent, "El botón '" + name + "' no está desplegado o habilitado");
		}
	}

	public static String selectByText(WebElement element, String option) {
		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();
		String name = Utils.inputName(element);
		Select select = new Select(element);
		select.selectByVisibleText(option);
		if (select.getFirstSelectedOption().isSelected()) {
			String selectedOption = select.getFirstSelectedOption().getText();
			Utils.outputInfo(
					"Se ha seleccionado la opción '" + selectedOption + "' en la lista desplegable '" + name + "'");
			return selectedOption;
		} else {
			Utils.eventFailed(currentEvent, "La opción requerida no pudo ser seleccionada");
			return null;
		}
	}

	public static void clickJavaScript(WebElement element, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String name = Utils.buttonName(element);
		jse.executeScript("arguments[0].click()", element);
		Utils.outputInfo("Se hizo clic en el botón: " + name);
	}

}
