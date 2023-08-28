package main.java.pageObjects;

public interface RegistroLoginElements {

	// a link 
	String aRegisterRelativo = "//a[@class='ico-register' and text()='Register']"; 
	
	// Text 
	String TextRegistro = "//h1[text()='Register']";
	String textoRegistroCompletado = "//div[@class='result' and contains(text(),'Your registration completed')]";
	
    // input 
    String inputFirstName = "//input[@id='FirstName']";
    String inputLastName = "//input[@id='LastName']";
    String inputEmail = "//input[@id='Email']";
    String inputPassword = "//input[@id='Password']";
    String inputConfirPassword = "//input[@id='ConfirmPassword']";
   
	// button
    String inputRegisterBtn = "//input[@id='register-button']"; 
    String inputContinuarBtn = "//input[@class='button-1 register-continue-button' and @value='Continue']";  
	
    // Radio-button
    String inputSexoM = "//input[@id='gender-male']";
    String inputSexoF = "//input[@id='gender-female']"; 
	
	// list


}