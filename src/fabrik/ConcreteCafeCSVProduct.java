package fabrik;

import java.io.BufferedReader;
import java.io.FileReader;

public class ConcreteCafeCSVProduct extends Product {

	private BufferedReader br;

	public ConcreteCafeCSVProduct() throws Exception {
		super();
		this.br = new BufferedReader(new FileReader("Cafe.csv"));
	}

	@Override
	public String[] leseAusDatei() throws Exception {
		String[] zeile = br.readLine().split(";");
		return zeile;
	}

	@Override
	public void schliessedatei() throws Exception {
		if (br != null) {
			br.close();
		}
	}
}
