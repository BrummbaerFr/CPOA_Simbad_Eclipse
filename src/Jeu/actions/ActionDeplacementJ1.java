package Jeu.actions;

import Jeu.Controleur;

import javax.swing.*;
import javax.vecmath.Vector3d;
import java.awt.event.ActionEvent;

public class ActionDeplacement extends AbstractAction {
	public static final String HAUT_J1 = "haut1";
	public static final String BAS_J1 = "bas1";
	public static final String GAUCHE_J1 = "gauche1";
	public static final String DROITE_J1 = "droite1";

	public static final String HAUT_J2 = "haut2";
	public static final String BAS_J2 = "bas2";
	public static final String GAUCHE_J2 = "gauche2";
	public static final String DROITE_J2 = "droite2";

	private int joueur;

	public ActionDeplacement(int joueur) {
		this.joueur = joueur;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		System.out.println("actionEvent = " + actionEvent.getActionCommand());
		Controleur.j1.translateTo(new Vector3d(1.0, 0.0, 0.0));
	}
}
