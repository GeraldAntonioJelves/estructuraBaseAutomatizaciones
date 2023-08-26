package main.java.pageObjects;

public interface RegistroLoginElements {

	//a link 
	String aRegisterRelativo = "//a[@class='ico-register' and text()='Register']"; 
	
	//Text 
	String TextRegistro = "//h1[text()='Register']";
	
    // input 
    String inputSexoM = "//input[@id='gender-male']";
    String inputSexoF = "//input[@id='gender-female']"; 
    String inputFirstName = "//input[@id='FirstName']";
    String inputLastName = "//input[@id='LastName']";
    String inputEmail = "//input[@id='Email']";
    String inputPassword = "//input[@id='Password']";
    String inputConfirPassword = "//input[@id='ConfirmPassword']";
    String inputRegisterBtn = "//input[@id='register-button']"; 
      
      

	// button

	

	
	//list


}