package Jeu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import simbad.sim.Agent;
import simbad.sim.Arch;
import simbad.sim.BlockWorldObject;
import simbad.sim.Box;
import simbad.sim.EnvironmentDescription;
import simbad.sim.Wall;



public class Sotchi2018 extends EnvironmentDescription {
	private static final String MUR = "Wall";
	private static final String ARCHE = "Arch";
	private static final String BOITE = "Box";

	public static final double LIGNE_NORD = -6.0;
	public static final double LIGNE_SUD = 6.0;

	/**
	 * Coordonnée X du but du joueur 1.
	 */
	//public static final double X_BUT_JOUEUR1;
	/**
	 * Coordonnée Z du but du joueur 1.
	 */
	//public static final double Z_BUT_JOUEUR1;

	/**
	 * Coordonnée X du but du joueur 2.
	 */
	//public static final double X_BUT_JOUEUR2;
	/**
	 * Coordonnée Z du but du joueur 2.
	 */
	//public static final double Z_BUT_JOUEUR2;

	private HashMap<String, ArrayList<BlockWorldObject>> envConfig;
	private ArrayList<Agent> listeRobots = new ArrayList<>();

	public Sotchi2018() {
		this.envConfig = new HashMap<>();
		this.envConfig.put(Sotchi2018.MUR, new ArrayList<>());
		this.envConfig.put(Sotchi2018.BOITE, new ArrayList<>());
		this.envConfig.put(Sotchi2018.ARCHE, new ArrayList<>());

		this.lireEnvironnement("src/Jeu/donnees/myenv.txt");

		for (BlockWorldObject w : this.envConfig.get(Sotchi2018.MUR))
			this.add((Wall) (w));

		for (BlockWorldObject b : this.envConfig.get(Sotchi2018.BOITE))
			this.add((Box) (b));

		for (BlockWorldObject a : this.envConfig.get(Sotchi2018.ARCHE))
			this.add((Arch) (a));

		for (Agent a : this.listeRobots)
			this.add(a);

		this.setUsePhysics(true);
		this.add(new AgentBalle(new Vector3d(0.0, 0, 0.0), "Ballon", new Color3f(), 0.3f, 0.05f));
	}

	private void lireEnvironnement(String cheminFichier) {
		try {
			Scanner sc = new Scanner(new File(cheminFichier));
			String s = "";

			while (sc.hasNextLine()) {
				String ligne = sc.nextLine();
				//System.out.println("Ligne courante : " + ligne);

				String[] decoupage = ligne.split(" ");

				this.lireBloc(decoupage);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void lireBloc(String[] bloc) {
		/*
		 * Première lettre : type du bloc.
		 * Les trois prochains nombres : les coordonnées (x, y, z) du bloc.
		 * 	Elles permettent de construire l'objet Vector3d (et/ou Vector3f).
		 * Le quatrième nombre : la longueur du bloc.
		 * Le cinquième nombre : la hauteur du bloc.
		 * Le dernier chiffre, 0 ou 1 : rotation ou pas à 90° du bloc.
		 */

		// Type de bloc : mur (W), boîte (B), arche (A)
		switch (bloc[0]) {
			case "W": {
				Vector3d vector3d = new Vector3d(Double.parseDouble(bloc[1]), Double.parseDouble(bloc[2]),
						Double.parseDouble(bloc[3]));

				boolean rotation90 = bloc[bloc.length - 1].equals("1");

				BlockWorldObject mur = new Wall(vector3d, Float.parseFloat(bloc[4]), Float.parseFloat(bloc[5]), this);
				//BlockWorldObject mur = new Wall(new Vector3d(9.0, 0.0, 0.0), 19, 1, this);
				if (rotation90)
					mur.rotate90(1);
				mur.setColor(new Color3f(139f / 255f, 69f / 255f, 19f / 255f));
				this.envConfig.get(Sotchi2018.MUR).add(mur);
				break;
			}
			case "B": {
				/* Pour les boîtes, on a :
				 * (x, y, z) les coordonnées de la boîte dans l'espace, et
				 * (x2, y2, z2) les dimensions de la boîte. */
				Vector3d vector3d = new Vector3d(Double.parseDouble(bloc[1]), Double.parseDouble(bloc[2]),
						Double.parseDouble(bloc[3]));
				Vector3f vector3f = new Vector3f(Float.parseFloat(bloc[4]), Float.parseFloat(bloc[5]),
						Float.parseFloat(bloc[6]));

				boolean rotation90 = bloc[bloc.length - 1].equals("1");

				BlockWorldObject boite = new Box(vector3d, vector3f, this);
				if (rotation90)
					boite.rotate90(1);
				boite.setColor(green);
				this.envConfig.get(Sotchi2018.BOITE).add(boite);
				break;
			}
			case "A": {
				Vector3d vector3d = new Vector3d(Double.parseDouble(bloc[1]), Double.parseDouble(bloc[2]),
						Double.parseDouble(bloc[3]));

				boolean rotation90 = bloc[bloc.length - 1].equals("1");

				BlockWorldObject arche = new Arch(vector3d, this);
				if (rotation90)
					arche.rotate90(1);

				this.envConfig.get(Sotchi2018.ARCHE).add(arche);
				break;
			}
			case "R":
				this.ajouterRobots();
				break;
		}
	}

	private void ajouterRobots() {
		Agent robot1 = new Robot(new Vector3d(0.0, 0.0, -4.0), "Robot 1");
		this.listeRobots.add(robot1);

		Agent robot2 = new Robot(new Vector3d(0.0, 0.0, 4.0), "Robot 2");
		this.listeRobots.add(robot2);
	}

	public ArrayList<Agent> getListeRobots() {
		return this.listeRobots;
	}
}
