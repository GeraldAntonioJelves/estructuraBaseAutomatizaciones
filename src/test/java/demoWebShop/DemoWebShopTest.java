package test.java.demoWebShop;

import java.io.IOException;

import main.java.pageEvents.LogInEvents;
import main.java.pageEvents.RegistroUsuarioEvents;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;
import main.java.utils.OpenCSV;
import main.java.utils.Utils;
import test.java.BaseTest;

public class DemoWebShopTest extends BaseTest {

	@Test(enabled = false, dataProvider = "demoWebShopData", priority = 1)
	public void QASRegistroUsuario(String args[]) throws InterruptedException {

		Utils.infoTestCase("Demo Web Shop",
				"Validar el registro de Usuario Correctamente");

		RegistroUsuarioEvents.registrarUsuario(args[0],args[1],args[2],args[3]);
	}

	@Test(enabled = true, dataProvider = "demoWebShopData", priority = 2)
	public void QASLoginUsuario(String args[]) throws InterruptedException {

		Utils.infoTestCase("Demo Web Shop",
				"Validar el ingreso de Usuario Correctamente");

		LogInEvents.LoginUsuario(args[2],args[3]);
	}
	
	@DataProvider(name = "demoWebShopData")
	public Object[][] dataBrokerAPAlternative() throws CsvValidationException, InterruptedException, IOException {

		Object[][] data = OpenCSV.getCSVParameters("CSVParametersRegistroDemoWebShop.csv",1,4);
		return data;
	}
}
