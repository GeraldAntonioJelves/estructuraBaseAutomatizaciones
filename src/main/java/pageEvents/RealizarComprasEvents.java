package main.java.pageEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import main.java.utils.ElementFetch;
import main.java.utils.Utils;
import test.java.sitioCompras.Tests;

public class CarritoComprasEvents extends Tests{

	public CarritoComprasEvents(WebDriver driver) {
		Tests.driver = driver;
	}
	@BeforeMethod(description = "Ingresa una breve descripsion de la funcion del metodo")
	public static void nombreClase(String variableUtilizar) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			Utils.outputInfo("Ha comenzado el evento: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			ElementFetch elementFetch = new ElementFetch();
			
//			WebElement etiquetaNombreVariableElement = elementFetch.getWebElement("XPATH",
//					CarritoComprasElements.inputUsuario);
//			wait.until(ExpectedConditions.visibilityOf(etiquetaNombreVariableElement));
//			Events.writeOnInput(etiquetaNombreVariableElement, variableUtilizar);

			
		} catch (Exception e) {
			Utils.eventFailed(currentEvent, e.getMessage());
		}
	}
}
