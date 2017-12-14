package Ex1;

import java.awt.image.BufferedImage;

import javax.vecmath.Vector3d;

import simbad.sim.Agent;
import simbad.sim.CameraSensor;
import simbad.sim.RangeSensorBelt;
import simbad.sim.RobotFactory;

public class RobotBumpers extends Agent {
	RangeSensorBelt sonars;
	
	CameraSensor camera;
	BufferedImage cameraImage;

	public RobotBumpers(Vector3d position, String name) {
		super(position, name);
		sonars = RobotFactory.addSonarBeltSensor(this, 8);
		camera = RobotFactory.addCameraSensor(this);
		this.cameraImage = this.camera.createCompatibleImage();
	}

	public void performBehavior() {
		this.camera.copyVisionImage(this.cameraImage);
		
		// avance à 0.5 m/s
		this.setTranslationalVelocity(0.5);
		// changer l'angle fréquemment
		if ((getCounter() % 100) == 0)
			this.setRotationalVelocity(Math.PI / 2 * (0.5 - Math.random()));

		// toutes les 20 frames
		if (getCounter() % 20 == 0) {// afficher les mesures de chaque sonar
			for (int i = 0; i < sonars.getNumSensors(); i++) {
				double range = sonars.getMeasurement(i);
				double angle = sonars.getSensorAngle(i);
				boolean hit = sonars.hasHit(i);
				System.out
						.println("Sonar at angle " + angle + "measured range =" + range + " has hit something:" + hit);
			}
		}
	}
}