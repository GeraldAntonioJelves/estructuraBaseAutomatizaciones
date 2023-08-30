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

public class RegistroSitioEvent extends Tests{

	public RegistroSitioEvent(WebDriver driver) {
		Tests.driver = driver;
	}
	@BeforeMethod(description = "Registrar usuario")
	public static void registroUsuario(String firstName, String lastName, String email, String password, String genero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			Utils.outputInfo("Ha comenzado el evento: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			ElementFetch elementFetch = new ElementFetch();

			WebElement linkRegistroElement = elementFetch.getWebElement("XPATH",
					RegistroLoginElements.aRegisterRelativo);
			wait.until(ExpectedConditions.visibilityOf(linkRegistroElement));
			Events.clickButton(linkRegistroElement);
			
			Thread.sleep(3000);
			WebElement textoRegisterElement = elementFetch.getWebElement("XPATH",
					RegistroLoginElements.TextRegistro);
			wait.until(ExpectedConditions.visibilityOf(textoRegisterElement));
			String textoConfirmacion = textoRegisterElement.getText();
			
			Validations.trueBooleanCondition(textoConfirmacion.equals("Register"), "se valida que estamos en el sitio "+
					textoConfirmacion, "no se ingreso al sitio correcto ", currentEvent);
			
			WebElement rdSexofElement = elementFetch.getWebElement("XPATH",
					RegistroLoginElements.inputSexoF);
			wait.until(ExpectedConditions.visibilityOf(rdSexofElement));
			String femenino = rdSexofElement.getAttribute("value");
			
			WebElement rdSexomElement = elementFetch.getWebElement("XPATH",
					RegistroLoginElements.inputSexoM);
			wait.until(ExpectedConditions.visibilityOf(rdSexomElement));
			String masculino = rdSexomElement.getAttribute("value");
			
			if (genero.equals(femenino)) {
				System.out.println("el genero ingresado es "+ genero);
			} else if (genero.equals(masculino)) {
				System.out.println("el genero ingresado es "+ genero);
			}else {
				Utils.eventFailed(currentEvent, "No se ingreso ninguna opcion");
			}
			
			WebElement firtNameElement = elementFetch.getWebElement("XPATH",
					RegistroLoginElements.inputFirstName);
			wait.until(ExpectedConditions.visibilityOf(firtNameElement));
			Events.writeOnInput(firtNameElement,firstName);
			
			WebElement lastNameElement = elementFetch.getWebElement("XPATH",
					RegistroLoginElements.inputLastName);
			wait.until(ExpectedConditions.visibilityOf(lastNameElement));
			Events.writeOnInput(lastNameElement, lastName);
			
			WebElement emailElement = elementFetch.getWebElement("XPATH",
					RegistroLoginElements.inputEmail);
			wait.until(ExpectedConditions.visibilityOf(emailElement));
			Events.writeOnInput(emailElement, email);
			
			WebElement passwordElement = elementFetch.getWebElement("XPATH",
					RegistroLoginElements.inputPassword);
			wait.until(ExpectedConditions.visibilityOf(passwordElement));
			Events.writeOnInput(passwordElement, password);
			
			WebElement confirmPasswordElement = elementFetch.getWebElement("XPATH",
					RegistroLoginElements.inputConfirPassword);
			wait.until(ExpectedConditions.visibilityOf(confirmPasswordElement));
			Events.writeOnInput(confirmPasswordElement, password);
			
			WebElement btnRegisterElement = elementFetch.getWebElement("XPATH",
					RegistroLoginElements.btnRegister);
			wait.until(ExpectedConditions.visibilityOf(btnRegisterElement));
			Events.clickButton(btnRegisterElement);
			
			WebElement textoRegisterConfirmElement = elementFetch.getWebElement("XPATH",
					RegistroLoginElements.TextRegistroConfirm);
			wait.until(ExpectedConditions.visibilityOf(textoRegisterConfirmElement));
			String registroCompleto = textoRegisterConfirmElement.getText();
			
			Validations.trueBooleanCondition(registroCompleto.contains("Your registration completed"), "se valida que se registro en el sitio ",
					registroCompleto + "no se registro en el sitio " , currentEvent);
			
			WebElement btnContinueRegisterElement = elementFetch.getWebElement("XPATH",
					RegistroLoginElements.btnContinuar);
			wait.until(ExpectedConditions.visibilityOf(btnContinueRegisterElement));
			Events.clickButton(btnContinueRegisterElement);
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			Utils.eventFailed(currentEvent, e.getMessage());
		}
	}
}
