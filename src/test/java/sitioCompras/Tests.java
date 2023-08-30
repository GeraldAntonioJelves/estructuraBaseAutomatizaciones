package test.java.sitioCompras;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import main.java.utils.OpenCSV;
import main.java.utils.Utils;
import test.java.BaseTest;

public class Tests extends BaseTest {

	public void test_usuario_valido() {

//		CarritoComprasEvents.iniciarSesion("usuario_valido", "clave_valida");
//		CarritoComprasEvents.validarPaginaPrincipal();
		
	}
	
	
	public void test_usuario_invalido() {

//		CarritoComprasEvents.iniciarSesion("usuario_invalido", "clave_invalida");
//		CarritoComprasEvents.validarMensajeUsuarioInvalido();
	}
	
	
	
	
	@Test(enabled = true, dataProvider = "carritoComprasData")
	public void QAS12(String args[]) throws InterruptedException {

		Utils.infoTestCase("Carrito de compras",
				"Validar la generación de una compra al agregar un producto al carrito de compras");

//		CarritoComprasEvents.iniciarSesion(args[0], args[1]);
//		CarritoComprasEvents.seleccionarProducto(args[2]);
	}
	
	
	@Test(enabled = true)
	public void comprarBicicleta(){

		Utils.infoTestCase("Carrito de compras",
				"Validar la generación de una compra al agregar una bicicleta al carrito de compras");

		//Todo el código para comprar una bicicleta en la página va en este método
	}
	
	@DataProvider(name = "carritoComprasData")
	public Object[][] dataBrokerAPAlternative() throws CsvValidationException, InterruptedException, IOException {

		Object[][] data = OpenCSV.getCSVParameters("CSVParametersCarritoCompras.csv", 1, 3);
		return data;
	}
}
