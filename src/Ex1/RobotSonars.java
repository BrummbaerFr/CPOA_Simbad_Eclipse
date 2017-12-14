package Ex1;

import javax.vecmath.Vector3d;

import simbad.sim.Agent;
import simbad.sim.RangeSensorBelt;
import simbad.sim.RobotFactory;

public class RobotSonars extends Agent {
	RangeSensorBelt bumpers;

	public RobotSonars(Vector3d position, String name) {
		super(position, name);
		bumpers = RobotFactory.addBumperBeltSensor(this, 8);
	}

	public void performBehavior() {
		// avance à 0.5 m/s
		this.setTranslationalVelocity(0.5);
		// changer l'angle fréquemment
		if ((getCounter() % 100) == 0)
			this.setRotationalVelocity(Math.PI / 2 * (0.5 - Math.random()));

		// toutes les 20 frames
		if (getCounter() % 20 == 0) {// afficher les mesures de chaque sonar
			for (int i = 0; i < bumpers.getNumSensors(); i++) {
				double range = bumpers.getMeasurement(i);
				double angle = bumpers.getSensorAngle(i);
				boolean hit = bumpers.hasHit(i);
				System.out.println("Bumpers at angle " + angle 
						+ " has hit something:"+hit);
			}
		}
	}
}