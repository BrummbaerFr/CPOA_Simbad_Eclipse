package TP2;

import javax.vecmath.Vector3d;

import simbad.sim.Agent;
import simbad.sim.RangeSensorBelt;
import simbad.sim.RobotFactory;

public class RobotSonars extends Agent {
	RangeSensorBelt sensors;

	public RobotSonars(Vector3d position, String name) {
		super(position, name);
		this.sensors = RobotFactory.addSonarBeltSensor(this, 8);
	}

	public void performBehavior() {
		// avance à 0.5 m/s
		this.setTranslationalVelocity(0.5);
		// changer l'angle fréquemment
		if ((getCounter() % 100) == 0)
			this.setRotationalVelocity(Math.PI / 2 * (0.5 - Math.random()));
		
		/*
		 * Si un des capteurs à l'avant du robot a détecté un obstacle,
		 * on ralentit le robot et on lui fait faire demi-tour. 
		 */
		if (this.sensors.getFrontQuadrantHits() > 0) {
			this.setRotationalVelocity(1.0);
			this.setTranslationalVelocity(0.2);
		}

		// toutes les 20 frames
		if (getCounter() % 20 == 0) {// afficher les mesures de chaque sonar
			for (int i = 0; i < sensors.getNumSensors(); i++) {
				double range = sensors.getMeasurement(i);
				double angle = sensors.getSensorAngle(i);
				boolean hit = sensors.hasHit(i);
				//System.out.println("Bumpers at angle " + angle 
				//		+ " has hit something:"+hit);
			}
		}
	}
}