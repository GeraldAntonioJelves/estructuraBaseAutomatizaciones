package main.java.pageEvents;

import main.java.pageObjects.LoginElement;
import main.java.utils.Events;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import main.java.utils.ElementFetch;
import main.java.utils.Utils;
import test.java.sitioCompras.Tests;

public class RealizarComprasEvents extends Tests{

	public RealizarComprasEvents(WebDriver driver) {
		Tests.driver = driver;
	}
	@BeforeMethod(description = "Ingresa una breve descripsion de la funcion del metodo")
	public static void nombreClase(String variableUtilizar) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			Utils.outputInfo("Ha comenzado el evento: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			ElementFetch elementFetch = new ElementFetch();

			WebElement linkLoginElement = elementFetch.getWebElement("XPATH",
					LoginElement.linkLogin);
			wait.until(ExpectedConditions.visibilityOf(linkLoginElement));
			Events.clickButton(linkLoginElement);

			
		} catch (Exception e) {
			Utils.eventFailed(currentEvent, e.getMessage());
		}
	}
}
