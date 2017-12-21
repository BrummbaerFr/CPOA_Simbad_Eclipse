package Jeu;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

import simbad.sim.Agent;
import simbad.sim.KeyInputSensor;
import simbad.sim.RangeSensorBelt;
import simbad.sim.RobotFactory;

import java.awt.*;
import java.awt.event.KeyListener;

public class Robot extends Agent {

	public Robot(Vector3d position, String name) {
		super(position, name);
	}

	public void initBehavior() {
		this.setTranslationalVelocity(2.0);
	}

	public void performBehavior() {

	}

}