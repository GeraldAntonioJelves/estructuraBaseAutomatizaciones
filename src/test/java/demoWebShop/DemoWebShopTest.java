package test.java.carritocompras;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;
import main.java.pageEvents.RegistroEvents;
import main.java.utils.OpenCSV;
import main.java.utils.Utils;
import test.java.BaseTest;

public class DemoWebShopTest extends BaseTest {

	@Test(enabled = true, dataProvider = "demoWebShopData")
	public void CodigoCasoDePrueba(String args[]) throws InterruptedException {

		Utils.infoTestCase("Demo Web Shop",
				"Validar el registro de Usuario Correctamente");

		RegistroEvents.registrarUsuario(args[0],args[1],args[2],args[3]);

	}
	
	@DataProvider(name = "demoWebShopData")
	public Object[][] dataBrokerAPAlternative() throws CsvValidationException, InterruptedException, IOException {

		Object[][] data = OpenCSV.getCSVParameters("CSVParametersDemoWebShop.csv", 1, 5);
		return data;
	}
}
