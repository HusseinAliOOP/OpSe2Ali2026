package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class VolkshochschulkursModel {
	Volkshochschulkurs volkshochschulkurs;


	public Volkshochschulkurs getVolkshochschulkurs() {
		return volkshochschulkurs;
	}

	public void setVolkshochschulkurs(Volkshochschulkurs volkshochschulkurs) {
		this.volkshochschulkurs = volkshochschulkurs;
	}

	public void leseAusDatei(String typ) throws IOException{
			if("csv".equals(typ)){
				BufferedReader ein = new BufferedReader(new FileReader("Volkshochschulkurs.csv"));
				String[] zeile = ein.readLine().split(";");
				this.volkshochschulkurs = new Volkshochschulkurs(zeile[0],
					Integer.parseInt(zeile[1]),
					zeile[2],
					Float.parseFloat(zeile[3]),
					zeile[4].split("_"));
					ein.close();

			}

	}


	public void schreibeVolkshochschulkursnInCsvDatei() throws IOException{
		BufferedWriter aus
			= new BufferedWriter(new FileWriter("VolkshochschulkurseAusgabe.csv", true));
		aus.write(volkshochschulkurs.gibVolkshochschulkursZurueck(';'));
		aus.close();

	}

}
