package Jeu.actions;

import Jeu.Controleur;

import javax.swing.*;
import javax.vecmath.Vector3d;
import java.awt.event.ActionEvent;
	
import static Jeu.Controleur.j1;

public class ActionDeplacementJ1 extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		switch (actionEvent.getActionCommand()) {
			case "z":
				j1.setTranslationalVelocity(2.0);
				j1.rotateY(Math.PI);
				break;
			case "q":
				j1.setTranslationalVelocity(2.0);
				j1.rotateY(Math.PI / 2);
				break;
			case "s":
				j1.setTranslationalVelocity(2.0);
				j1.rotateY(-Math.PI);
				break;
			case "d":
				j1.setTranslationalVelocity(2.0);
				j1.rotateY(-Math.PI / 2);
				break;
		}

	}
}
