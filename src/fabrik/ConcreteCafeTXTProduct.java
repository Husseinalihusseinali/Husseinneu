package fabrik;

import java.io.BufferedReader;
import java.io.FileReader;

public class ConcreteCafeTXTProduct extends Product {

	private BufferedReader bReader;

	public ConcreteCafeTXTProduct() throws Exception {
		super();
		this.bReader = new BufferedReader(new FileReader("Cafe.txt"));
	}

	@Override
	public String[] leseAusDatei() throws Exception {
		String[] ergebnisZeile = new String[5];
		String zeile = bReader.readLine();
		int i = 0;
		while (i < ergebnisZeile.length) {
			ergebnisZeile[i] = zeile;
			zeile = bReader.readLine();
			i++;
		}
		return ergebnisZeile;
	}

	@Override
	public void schliessedatei() throws Exception {
		bReader.close();
	}
}
