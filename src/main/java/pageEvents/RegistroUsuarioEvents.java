package main.java.pageEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import main.java.pageObjects.RegistroElements;
import main.java.utils.ElementFetch;
import main.java.utils.Events;
import main.java.utils.Utils;
import main.java.utils.Validations;
import test.java.sitioCompras.Tests;

public class RegistroUsuarioEvents extends Tests {

	public RegistroUsuarioEvents(WebDriver driver) {
		Tests.driver = driver;
	}

	@BeforeMethod(description = "Realizamos un registro de cuenta")
	public static void registrarUsuario(String firstName, String lastName, String email, String password) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			Utils.outputInfo("Ha comenzado el evento: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			ElementFetch elementFetch = new ElementFetch();

			WebElement aRegistroRelavitoElement = elementFetch.getWebElement("XPATH",
					RegistroElements.linkRegisterRelativo);
			wait.until(ExpectedConditions.visibilityOf(aRegistroRelavitoElement));
			Events.clickButton(aRegistroRelavitoElement);
			
			Thread.sleep(2000);
			WebElement textTetxoRegistroElement = elementFetch.getWebElement("XPATH",
					RegistroElements.TextRegistro);
			wait.until(ExpectedConditions.visibilityOf(textTetxoRegistroElement));

			String textoRegistro = textTetxoRegistroElement.getText();
			Validations.trueBooleanCondition(textoRegistro.equalsIgnoreCase("Register"),
					"Se ha ingresado a la página de '" + textoRegistro + "' correctamente",
					"No se ha ingresado a la página correcta", currentEvent);
			
			WebElement inputSexoMaleElement = elementFetch.getWebElement("XPATH",
					RegistroElements.inputSexoM);
			wait.until(ExpectedConditions.visibilityOf(inputSexoMaleElement));
			Events.clickButton(inputSexoMaleElement);
			
			WebElement inputFirstNameElement = elementFetch.getWebElement("XPATH",
					RegistroElements.inputFirstName);
			wait.until(ExpectedConditions.visibilityOf(inputFirstNameElement));
			Events.writeOnInput(inputFirstNameElement,firstName);
			
			WebElement inputLastNameElement = elementFetch.getWebElement("XPATH",
					RegistroElements.inputLastName);
			wait.until(ExpectedConditions.visibilityOf(inputLastNameElement));
			Events.writeOnInput(inputLastNameElement, lastName);
			
			WebElement inputEmailElement = elementFetch.getWebElement("XPATH",
					RegistroElements.inputEmail);
			wait.until(ExpectedConditions.visibilityOf(inputEmailElement));
			Events.writeOnInput(inputEmailElement, email);
			
			WebElement inputPasswordElement = elementFetch.getWebElement("XPATH",
					RegistroElements.inputPassword);
			wait.until(ExpectedConditions.visibilityOf(inputPasswordElement));
			Events.writeOnInput(inputPasswordElement, password);
			
			WebElement inputConfirmPasswordElement = elementFetch.getWebElement("XPATH",
					RegistroElements.inputConfirPassword);
			wait.until(ExpectedConditions.visibilityOf(inputConfirmPasswordElement));
			Events.writeOnInput(inputConfirmPasswordElement, password);
			
			WebElement inputBotonRegistroElement = elementFetch.getWebElement("XPATH",
					RegistroElements.inputRegisterBtn);
			wait.until(ExpectedConditions.visibilityOf(inputBotonRegistroElement));
			Events.clickButton(inputBotonRegistroElement);
			
			Thread.sleep(2000);
			WebElement textoRegistroCompletadoElement = elementFetch.getWebElement("XPATH",
					RegistroElements.textoRegistroCompletado);
			wait.until(ExpectedConditions.visibilityOf(textoRegistroCompletadoElement));
			
			String registroExitoso = textoRegistroCompletadoElement.getText();
			Validations.trueBooleanCondition(registroExitoso.contains("Your registration completed"),
					"El nuevo usuario ha registrado correctamente '" + registroExitoso + "' correctamente",
					"No se ha realizado el registro de usuario", currentEvent);

		} catch (Exception e) {
			Utils.eventFailed(currentEvent, e.getMessage());
		}
	}
}
