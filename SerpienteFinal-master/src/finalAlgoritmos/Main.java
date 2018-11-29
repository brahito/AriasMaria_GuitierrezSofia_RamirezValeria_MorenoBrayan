package finalAlgoritmos;

import processing.core.PApplet;

public class Main extends PApplet {
	private Logica log;

	public static void main(String[] args) {
		PApplet.main("finalAlgoritmos.Main");
	}

	public void settings() {

		size(1200, 700);
	}

	public void setup() {
		log = new Logica(this);
	}

	public void draw() {
		background(255);
		log.pintar();
	}

	public void keyPressed() {
		log.tecla();
	}

	public void mousePressed() {
		log.mouse();
	}

}
