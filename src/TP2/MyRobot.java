package TP2;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

import simbad.sim.Agent;
import simbad.sim.RangeSensorBelt;
import simbad.sim.RobotFactory;

import java.awt.*;

public class MyRobot extends Agent {
	private RangeSensorBelt sonars;

	public MyRobot(Vector3d position, String name) {
		super(position, name);
		sonars = RobotFactory.addSonarBeltSensor(this, 8);
	}

	public void initBehavior() {
	}

	public void performBehavior() {
		if ((getCounter() % 20) == 0) {
			int r = (int)(Math.random() * 255);
			int g = (int)(Math.random() * 255);
			int b = (int)(Math.random() * 255);

			this.setColor(new Color3f(new Color(r, g, b)));
		}

		// avance à 0.5 m/s
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
		}
	}

}