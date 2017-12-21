package Jeu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FrameScore extends JInternalFrame {
	private int scoreJoueur1 = 0;
	private int scoreJoueur2 = 0;

	private JLabel labelScoreJoueur1;
	private JLabel labelScoreJoueur2;

	public FrameScore() {
		super("Scores", false, false, false, false);

		this.labelScoreJoueur1 = new JLabel(String.valueOf(this.scoreJoueur1), JLabel.CENTER);
		this.labelScoreJoueur2 = new JLabel(String.valueOf(this.scoreJoueur2), JLabel.CENTER);

		this.setLayout(new GridLayout(2, 2, 10, 10));

		// Étiquettes des joueurs
		this.add(new JLabel("Joueur 1"));
		this.add(new JLabel("Joueur 2"));

		// On ajoute du padding à la fenêtre
		this.setBorder(BorderFactory.createCompoundBorder(this.getBorder(), new EmptyBorder(0, 5, 0, 5)));

		// Scores des joueurs
		this.add(this.labelScoreJoueur1);
		this.add(this.labelScoreJoueur2);

		this.pack();
	}

	public void resetScore() {
		this.scoreJoueur1 = this.scoreJoueur2 = 0;
	}

	public void goalJoueur1() {
		this.labelScoreJoueur1.setText(String.valueOf(++this.scoreJoueur1));

		for (int i = 0; i < 3; i++) {
			try {
				this.labelScoreJoueur1.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
				Thread.sleep(500);
				this.labelScoreJoueur1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void goalJoueur2() {
		this.labelScoreJoueur2.setText(String.valueOf(++this.scoreJoueur2));

		for (int i = 0; i < 3; i++) {
			try {
				this.labelScoreJoueur2.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
				Thread.sleep(500);
				this.labelScoreJoueur2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
