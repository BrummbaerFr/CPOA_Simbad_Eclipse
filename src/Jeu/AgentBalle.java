package Jeu;

import java.awt.Color;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

import simbad.gui.Simbad;
import simbad.sim.Agent;
import simbad.sim.BallAgent;

import static Jeu.Sotchi2018.LIGNE_NORD;
import static Jeu.Sotchi2018.LIGNE_SUD;

public class AgentBalle extends BallAgent {
	private double x;
	private double y;
	private double z;

	public AgentBalle(Vector3d position, String name, Color3f color, float radius, float mass) {
		super(position, name, color, radius, mass);

	}

	public void initBehavior() {
		// On active les collisions avec la balle
		this.setCanBeTraversed(false);

		this.setColor(new Color3f(Color.RED));
	}

	public void performBehavior() {
		this.x = this.getCoords().getX();
		this.y = this.getCoords().getY();
		this.z = this.getCoords().getZ();

		// On vérifie si la balle n'est pas entrée dans le but du joueur 1
		if (this.z < -7 && this.x > - 1.3 && this.x < 1.7) {
			Controleur.simbad.getFrameScore().goalJoueur1();
			this.resetPosition();
			Controleur.j1.moveToStartPosition();
			Controleur.j2.moveToStartPosition();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// ... pareil pour le but du joueur 2.
		if (this.z > 7 && this.x > - 1.3 && this.x < 1.7) {
			Controleur.simbad.getFrameScore().goalJoueur2();
			this.resetPosition();
			Controleur.j1.moveToStartPosition();
			Controleur.j2.moveToStartPosition();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}