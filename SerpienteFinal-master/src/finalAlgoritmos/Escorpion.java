package finalAlgoritmos;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public abstract class Escorpion extends Thread {
	protected PApplet app;
	protected PVector pos, vel, ace;
	protected PImage escorpion;
	protected int fresas;
	protected float max;
	protected boolean vivo, congelado, encafeinado, dientes;
	protected int tam, contadorHielo, contadorCafe, ran, contadorDientes;
	protected Mundo mundo;

	public Escorpion (PApplet app, Mundo mundo) {
		this.app = app;
		this.mundo = mundo;
		vivo = true;
		tam=50;
	}

	public abstract void pintar();

	public void run() {
		try {
			while (vivo) {
				if (validarPerseguirSerpienteA(mundo.getSerA()) == true) {
					perseguirSerpienteA(mundo.getSerA());
				}
				else if (validarPerseguirSerpienteB(mundo.getSerB()) == true) {
					perseguirSerpienteB(mundo.getSerB());
				}
				sleep(50);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public abstract void mover(Recurso r);

	public abstract void perseguirSerpienteA(Serpiente s);
	public abstract void perseguirSerpienteB(SerpienteB s);

	public boolean validarSerpiente(Serpiente s) {

		if (PApplet.dist(pos.x, pos.y, s.getX().get(s.getX().size() - 1), s.getY().get(s.getY().size() - 1)) < 1200) {
			return true;
		}
		return false;

	}

	public boolean validarPerseguirSerpienteA(Serpiente s) {

		if (PApplet.dist(pos.x, pos.y, s.getX().get(s.getX().size() - 1),
				s.getY().get(s.getY().size() - 1)) < 1200) {
			return true;
		}
		return false;

	}
	public boolean validarPerseguirSerpienteB(SerpienteB s) {

		if (PApplet.dist(pos.x, pos.y, s.getX().get(s.getX().size() - 1),
				s.getY().get(s.getY().size() - 1)) < 1200) {
			return true;
		}
		return false;

	}

	public PVector getPos() {
		return pos;
	}
}
