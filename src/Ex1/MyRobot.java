package Ex1;

import javax.vecmath.Vector3d;

import simbad.sim.Agent;

public class MyRobot extends Agent {
	public MyRobot(Vector3d position, String name) {
		super(position, name);
	}

	public void initBehavior() {
	}

	public void performBehavior() {
		// avance à 0.5 m/s
		this.setTranslationalVelocity(0.5);
		// changer l'angle fréquemment
		if ((getCounter() % 100) == 0)
			this.setRotationalVelocity(Math.PI / 2 * (0.5 - Math.random()));
		
		// si on est entré en collision avec le décor
		if (this.collisionDetected()) {
			this.moveToStartPosition();
		}
	}
	
	
}