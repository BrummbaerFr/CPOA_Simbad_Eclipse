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
				j2.rotateY(Math.PI);
				break;
			case "q":
				j2.rotateY(Math.PI / 2);
				break;
			case "s":
				j2.rotateY(-Math.PI);
				break;
			case "d":
				j2.rotateY(-Math.PI / 2);
				break;
		}

	}
}
