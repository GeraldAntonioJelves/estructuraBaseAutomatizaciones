package main.java.pageObjects;

public interface LoginPageElements {
	
	//a Link 
	
	String linkLogin = "//a[@class='ico-login']";
	String textOlvidoContrasena = "//a [text()='Forgot password?']";
	String textLogeado = "(//a [@class='account' ])[1]";
	String textLibros = "(//a[contains(text(),'Books')])[1]";
	
	// Text 
	
	String textWelcome = "//h1[text()='Welcome, Please Sign In!']";
	String textPagLibros = "//h1[text()='Books']"; 
	
	// input 
	
	String inputEmail = "//input[@id='Email']";
	String inputContrasena = "//input[@id='Password']";
	String inputRecordarme = "//input[@id='RememberMe']"; 
	
	// boton 
	 
	String btnLogin = "//input[@class='button-1 login-button']";
	String btnAñadirCarrito = "(//input[@class='button-2 product-box-add-to-cart-button'])[1]";
	
	// select 
	
	String selectSortby = "//select[@id='products-orderby']";
	
	

}
