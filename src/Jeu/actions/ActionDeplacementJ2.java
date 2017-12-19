package Jeu.actions;

import Jeu.Controleur;

import javax.swing.*;
import javax.vecmath.Vector3d;
import java.awt.event.ActionEvent;

import static Jeu.Controleur.j2;

public class ActionDeplacementJ2 extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		System.out.println("actionEvent.getActionCommand() = " + actionEvent.getActionCommand());

		switch (actionEvent.getActionCommand()) {
			case "z":
				j2.translateTo(new Vector3d(0.0, 0.0, -1.0));
				break;
			case "q":
				j2.translateTo(new Vector3d(-1.0, 0.0, 0.0));
				break;
			case "s":
				j2.translateTo(new Vector3d(0.0, 0.0, 1.0));
				break;
			case "d":
				j2.translateTo(new Vector3d(1.0, 0.0, 0.0));
				break;
		}

	}
}
