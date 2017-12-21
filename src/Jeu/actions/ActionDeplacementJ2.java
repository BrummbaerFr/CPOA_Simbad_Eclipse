package Jeu.actions;

import Jeu.Controleur;

import javax.swing.*;
import javax.vecmath.Vector3d;
import java.awt.event.ActionEvent;

import static Jeu.Controleur.j2;

public class ActionDeplacementJ2 extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		switch (actionEvent.getActionCommand()) {
			case "o":
				j2.rotateY(Math.PI);
				break;
			case "k":
				j2.rotateY(Math.PI / 2);
				break;
			case "l":
				j2.rotateY(-Math.PI);
				break;
			case "m":
				j2.rotateY(-Math.PI / 2);
				break;
		}

	}
}
