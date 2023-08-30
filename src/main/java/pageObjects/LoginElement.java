package main.java.pageObjects;

public interface LoginElement {

    //link
    String linkLogin = "//a[@class='ico-login']";
    String linkUsuarioActual = "(//a[@class='account'])[1]";

    //texto
    String textoBienvenidoAlLogin = "//h1[text()='Welcome, Please Sign In!']";

    //input
    String inputEmail = "//input[@id='Email']";
    String inputPassword = "//input[@id='Password']";

    //checkBox
    String checkBoxRememberMe = "//input[@id='RememberMe']";

    //button
    String buttonLogIn = "//input[@class='button-1 login-button' and @value='Log in']";
}
