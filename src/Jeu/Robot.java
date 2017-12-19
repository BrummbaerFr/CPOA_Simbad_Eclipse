package Jeu;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

import simbad.sim.Agent;
import simbad.sim.RangeSensorBelt;
import simbad.sim.RobotFactory;

import java.awt.*;
import java.awt.event.KeyListener;

public class Robot extends Agent {
	private RangeSensorBelt sonars;

	public Robot(Vector3d position, String name) {
		super(position, name);
		sonars = RobotFactory.addSonarBeltSensor(this, 8);
	}

	public void initBehavior() {
		this.setTranslationalVelocity(2.0);
	}

	public void performBehavior() {
		/*// avance à 0.5 m/s
		this.setTranslationalVelocity(0.5);
		// changer l'angle fréquemment
		if ((getCounter() % 100) == 0)
			this.setRotationalVelocity(Math.PI / 2 * (0.5 - Math.random()));

		if (sonars.oneHasHit()) {
			double left = sonars.getFrontLeftQuadrantMeasurement();
			double right = sonars.getFrontRightQuadrantMeasurement();
			double front = sonars.getFrontQuadrantMeasurement();
			if ((front > 0.5) || (left > 0.5) || (right > 0.5)) {
				if (left < right)
					setRotationalVelocity(-1);
				else
					setRotationalVelocity(1);
			}
		}
		if (this.collisionDetected()) {
			setTranslationalVelocity(-1.0);
			setRotationalVelocity(0.5);
		}*/
	}

}