package main.java.pageEvents;

import main.java.pageObjects.LoginElement;
import main.java.pageObjects.RegistroElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import main.java.utils.ElementFetch;
import main.java.utils.Events;
import main.java.utils.Utils;
import main.java.utils.Validations;
import test.java.sitioCompras.Tests;

public class LogInEvents extends Tests {

    public LogInEvents(WebDriver driver) {
        Tests.driver = driver;
    }

    @BeforeMethod(description = "Realizamos un login de usuario ya registrado")
    public static void LoginUsuario(String email, String password) {

        String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

        try {
            Utils.outputInfo("Ha comenzado el evento: " + currentEvent);

            WebDriverWait wait = new WebDriverWait(driver, 50);
            ElementFetch elementFetch = new ElementFetch();

            WebElement linkLoginElement = elementFetch.getWebElement("XPATH",
                    LoginElement.linkLogin);
            wait.until(ExpectedConditions.visibilityOf(linkLoginElement));
            Events.clickButton(linkLoginElement);

            WebElement textoBienvenidaLoginElemet = elementFetch.getWebElement("XPATH",
                    LoginElement.textoBienvenidoAlLogin);
            wait.until(ExpectedConditions.visibilityOf(textoBienvenidaLoginElemet));

            Thread.sleep(2000);
            String textoBienvenidaLogin = textoBienvenidaLoginElemet.getText();
            Validations.trueBooleanCondition(textoBienvenidaLogin.equalsIgnoreCase("Welcome, Please Sign In!"),
                    "Se ha ingresado al Log In del sitio; '" + textoBienvenidaLogin + "' correctamente",
                    "No se ha ingresado a la página correcta", currentEvent);

            WebElement inputEmailElement = elementFetch.getWebElement("XPATH",
                    LoginElement.inputEmail);
            wait.until(ExpectedConditions.visibilityOf(inputEmailElement));
            Events.writeOnInput(inputEmailElement,email);

            WebElement inputPasswordElement = elementFetch.getWebElement("XPATH",
                    LoginElement.inputPassword);
            wait.until(ExpectedConditions.visibilityOf(inputPasswordElement));
            Events.writeOnInput(inputPasswordElement,password);

            WebElement checkBoxRememberMe = elementFetch.getWebElement("XPATH",
                    LoginElement.checkBoxRememberMe);
            wait.until(ExpectedConditions.visibilityOf(checkBoxRememberMe));
            Events.clickButton(checkBoxRememberMe);

            Thread.sleep(3000);
            WebElement buttonLogInElement = elementFetch.getWebElement("XPATH",
                    LoginElement.buttonLogIn);
            wait.until(ExpectedConditions.visibilityOf(buttonLogInElement));
            Events.clickButton(buttonLogInElement);

            WebElement linkUsuarioActualElement = elementFetch.getWebElement("XPATH",
                    LoginElement.linkUsuarioActual);
            wait.until(ExpectedConditions.visibilityOf(linkUsuarioActualElement));
            String usuarioActual = linkUsuarioActualElement.getText();

            if (usuarioActual == email){
                System.out.println("El usuario ingresado actualmente es: "+email);
            }else{
                Utils.eventFailed(currentEvent, "No se ingreso correctamente al sitio web");
            }

        } catch (Exception e) {
            Utils.eventFailed(currentEvent, e.getMessage());
        }
    }
}
