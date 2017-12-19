package Jeu;

import simbad.gui.Simbad;
import simbad.sim.Agent;

import Jeu.actions.*;

import javax.swing.*;
import javax.vecmath.Color3f;
import java.awt.*;

/**
 * Créé par Richard BLONDEL le 14/12/17.
 * Groupe C du département informatique de l'IUT du Havre.
 */
public class Controleur {
	public static Agent j1;
	public static Agent j2;

	public static final String HAUT = "haut";
	public static final String BAS = "bas";
	public static final String GAUCHE = "gauche";
	public static final String DROITE = "droite";

	public static void main(String[] args) {
		MyEnv myEnv = new MyEnv();
		Simbad simbad = new Simbad(myEnv, false);

		Controleur.j1 = myEnv.getListeRobots().get(0);
		Controleur.j1.setColor(new Color3f(Color.BLUE));

		Controleur.j2 = myEnv.getListeRobots().get(1);
		Controleur.j2.setColor(new Color3f(Color.RED));

		// Actions joueur 1
		simbad.getDesktopPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("Z"), HAUT + "1");
		simbad.getDesktopPane().getActionMap().put(HAUT + "1", new ActionDeplacementJ1());

		simbad.getDesktopPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("Q"), GAUCHE + "1");
		simbad.getDesktopPane().getActionMap().put(GAUCHE + "1", new ActionDeplacementJ1());

		simbad.getDesktopPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), BAS + "1");
		simbad.getDesktopPane().getActionMap().put(BAS + "1", new ActionDeplacementJ1());

		simbad.getDesktopPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), DROITE + "1");
		simbad.getDesktopPane().getActionMap().put(DROITE + "1", new ActionDeplacementJ1());

		// Actions joueur 2
		simbad.getDesktopPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("O"), HAUT + "2");
		simbad.getDesktopPane().getActionMap().put(HAUT + "2", new ActionDeplacementJ2());

		simbad.getDesktopPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("K"), GAUCHE + "2");
		simbad.getDesktopPane().getActionMap().put(GAUCHE + "2", new ActionDeplacementJ2());

		simbad.getDesktopPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("L"), BAS + "2");
		simbad.getDesktopPane().getActionMap().put(BAS + "2", new ActionDeplacementJ2());

		simbad.getDesktopPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("M"), DROITE + "2");
		simbad.getDesktopPane().getActionMap().put(DROITE + "2", new ActionDeplacementJ2());
	}
}
