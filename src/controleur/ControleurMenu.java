package controleur;

import vue.VueAbonnement;
import vue.VueClient;
import vue.VuePeriodicite;
import vue.VueRevue;

public class ControleurMenu {
	
	
	public void lanceRevue() {
		VueRevue vue = new VueRevue();
	}
	
	public void lanceClient() {
		VueClient vue = new VueClient();
	}

	public void lanceAbonnement() {
		VueAbonnement vue = new VueAbonnement();
	}
	
	public void lancePeriodicite() {
		VuePeriodicite vue = new VuePeriodicite();
	}
}
