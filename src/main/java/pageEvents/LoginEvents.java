package main.java.pageEvents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import main.java.pageObjects.RegistroLoginElements;
import main.java.utils.ElementFetch;
import main.java.utils.Events;
import main.java.utils.Utils;
import main.java.utils.Validations;
import test.java.sitioCompras.Tests;

public class LoginEvents extends Tests{

	public LoginEvents(WebDriver driver) {
		Tests.driver = driver;
	}
	@BeforeMethod(description = "Ingresa una breve descripsion de la funcion del metodo")
	public static void iniciarSesion(String usuario, String contrasena) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			Utils.outputInfo("Ha comenzado el evento: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			ElementFetch elementFetch = new ElementFetch();

//			WebElement inputNombreUsuarioElement = elementFetch.getWebElement("XPATH",
//					CarritoComprasElements.inputUsuario);
//			wait.until(ExpectedConditions.visibilityOf(inputNombreUsuarioElement));
//			Events.writeOnInput(inputNombreUsuarioElement, usuario);

		} catch (Exception e) {
			Utils.eventFailed(currentEvent, e.getMessage());
		}
	}
}
