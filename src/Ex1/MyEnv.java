package Ex1;

import javax.vecmath.Vector3d;

import simbad.sim.Arch;
import simbad.sim.EnvironmentDescription;
import simbad.sim.Wall;

public class MyEnv extends EnvironmentDescription {
	public MyEnv() {
		// Ajout d'une arche
		this.add(new Arch(new Vector3d(3, 0, -3), this));
		
		// Ajout de murs tout autour du terrain
		Wall w1 = new Wall(new Vector3d(10, 0, 0), 20, 2, this);
        w1.rotate90(1);
        this.add(w1);
        Wall w2 = new Wall(new Vector3d(-10, 0, 0), 20, 2, this);
        w2.rotate90(1);
        this.add(w2);
        Wall w3 = new Wall(new Vector3d(0, 0, 10), 20, 2, this);
        this.add(w3);
        Wall w4 = new Wall(new Vector3d(0, 0, -10), 20, 2, this);
        this.add(w4);
		
        this.add(new MyRobot(new Vector3d(1, 0, 0), "Mon robot"));
		this.add(new RobotSonars(new Vector3d(0, 0, 0), "Mon robot"));
		this.add(new RobotBumpers(new Vector3d(-1, 0, 0), "Mon robot"));
	}
}
