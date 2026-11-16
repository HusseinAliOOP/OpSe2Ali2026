package gui;

import java.io.IOException;

import business.Volkshochschulkurs;
import business.VolkshochschulkursModel;
import javafx.stage.Stage;

public class VolkshochschulkursControl {
	private VolkshochschulkursModel model;
	private VolkshochschulkursView view;

	public VolkshochschulkursControl(Stage primaryStage) {
		this.model = new VolkshochschulkursModel();
		this.view= new VolkshochschulkursView(this, primaryStage, model);
	}

	public void nehmeVolkshochschulkursAuf(String kursname, String kursbeitrag, String wochentag, String startuhrzeit, String vorkenntnisse){
		try{
			Volkshochschulkurs a = new Volkshochschulkurs(
				kursname,
				Integer.parseInt(kursbeitrag),
				wochentag,
				Float.parseFloat(startuhrzeit),
				vorkenntnisse.split(";"));
			this.model.setVolkshochschulkurs(a);
			this.view.zeigeInformationsfensterAn("Der Volkshochschulkurs wurde aufgenommen!");
		}
		catch(Exception exc){
			this.view.zeigeFehlermeldungsfensterAn(exc.getMessage());
		}
	}


	public void leseAusDatei(String typ){
		try {
			if("csv".equals(typ)){
				this.model.leseAusDatei(typ);
				this.view.zeigeInformationsfensterAn(
					"Der Volkshochschulkurs wurde gelesen!");
			}
			else{
				this.view.zeigeInformationsfensterAn(
					"Noch nicht implementiert!");
			}
		}
		catch(IOException exc){
			this.view.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			this.view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}

	public void schreibeVolkshochschulkursnInCsvDatei() {
		try {
			this.model.schreibeVolkshochschulkursnInCsvDatei();
			this.view.zeigeInformationsfensterAn(
				"Die Volkshochschulkurse wurden gespeichert!");
		}
		catch(IOException exc){
			this.view.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			this.view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

}
