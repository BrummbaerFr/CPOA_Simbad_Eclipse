package Jeu;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

import simbad.sim.Agent;
import simbad.sim.BallAgent;
import simbad.sim.RangeSensorBelt;
import simbad.sim.RobotFactory;

import java.awt.*;

public class AgentBalle extends BallAgent {
	public AgentBalle(Vector3d position, String name, Color3f color, float radius, float mass) {
		super(position, name, color, radius, mass);
	}

	public void initBehavior() {
		this.setCanBeTraversed(false);
	}

	public void performBehavior() {
		int r = (int)(Math.random() * 255);
		int g = (int)(Math.random() * 255);
		int b = (int)(Math.random() * 255);

		this.setColor(new Color3f(new Color(r, g, b)));
	}

}