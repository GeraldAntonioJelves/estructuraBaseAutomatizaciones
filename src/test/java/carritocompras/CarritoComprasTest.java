package test.java.carritocompras;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import main.java.pageEvents.CarritoComprasEvents;
import main.java.pageEvents.RegistroSitioEvent;
import main.java.utils.OpenCSV;
import main.java.utils.Utils;
import test.java.BaseTest;

public class CarritoComprasTest extends BaseTest {

	@Test(enabled = true, dataProvider = "carritoComprasData")
	public void CasopruebaRegistroUsuario(String args[]) throws InterruptedException {

		Utils.infoTestCase("Register User",
				"Validar que al registar un usuario se cree correctamente en el sitio web");

		RegistroSitioEvent.registroUsuario(args[0],args[1],args[2],args[3],args[4]);

	}
	
	@DataProvider(name = "carritoComprasData")
	public Object[][] dataBrokerAPAlternative() throws CsvValidationException, InterruptedException, IOException {

		Object[][] data = OpenCSV.getCSVParameters("CSVParametersCarritoCompras.csv", 1, 5);
		return data;
	}
}
