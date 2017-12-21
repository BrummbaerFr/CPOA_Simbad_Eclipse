package Jeu;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.vecmath.Color3f;

import Jeu.actions.ActionDeplacementJ1;
import Jeu.actions.ActionDeplacementJ2;
import simbad.gui.Simbad;
import simbad.sim.Agent;
import simbad.sim.EnvironmentDescription;

/**
 * Créé par Richard BLONDEL le 14/12/17.
 * Groupe C du département informatique de l'IUT du Havre.
 */
public class Controleur {
	public static Agent j1;
	public static Agent j2;

	private static final String HAUT = "haut";
	private static final String BAS = "bas";
	private static final String GAUCHE = "gauche";
	private static final String DROITE = "droite";

	private Sotchi2018 environmentDescription;
	public static Simbad simbad;

	public Controleur() {
		this.environmentDescription = new Sotchi2018();
		Controleur.simbad = new Simbad(this.environmentDescription, false);

		initialiserRobots();
		creerActions();
	}

	private void initialiserRobots() {
		Controleur.j1 = this.environmentDescription.getListeRobots().get(0);
		Controleur.j1.setColor(new Color3f(Color.BLUE));

		Controleur.j2 = this.environmentDescription.getListeRobots().get(1);
		Controleur.j2.setColor(new Color3f(Color.GREEN));
	}

	private void creerActions() {
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

	public static void main(String[] args) {
		new Controleur();
	}

	public static void goalJoueur1() {
		Controleur.simbad.getFrameScore().goalJoueur1();
	}

	public static void goalJoueur2() {
		Controleur.simbad.getFrameScore().goalJoueur2();
	}
}
