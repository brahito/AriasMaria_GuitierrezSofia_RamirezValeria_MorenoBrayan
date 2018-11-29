package finalAlgoritmos;

import processing.core.PApplet;
import processing.core.PVector;

public class EscorpionA extends Escorpion {

		public EscorpionA(PApplet app, Mundo mundo) {
			super(app, mundo);
			escorpion = app.loadImage("malo.png");
			pos = new PVector(app.random(app.width), app.random(app.height));
			vel = new PVector(0, 0);
			ran = (int) app.random(3, 6);
			max = ran;
		}

		@Override
		public void pintar() {
		
			app.imageMode(PApplet.CENTER);
			app.image(escorpion, pos.x, pos.y, tam, tam);
			app.imageMode(PApplet.CORNER);
		}
		@Override
		public void mover(Recurso r) {
			PVector seguir = new PVector(r.getX(), r.getY());
			PVector dir = PVector.sub(seguir, pos);
			dir.normalize();
			dir.mult((float) 0.5);
			ace = dir;
			vel.add(ace);
			vel.limit(max);
			pos.add(vel);
		}

		@Override
		public void perseguirSerpienteA(Serpiente s) {
			PVector seguir = new PVector(s.getX().get(s.getX().size() - 1), s.getY().get(s.getY().size() - 1));
			PVector dir = PVector.sub(seguir, pos);
			dir.normalize();
			dir.mult((float) 0.5);
			ace = dir;
			vel.add(ace);
			vel.limit(max);
			pos.add(vel);

		}
		public void perseguirSerpienteB(SerpienteB s) {
			PVector seguir = new PVector(s.getX().get(s.getX().size() - 1), s.getY().get(s.getY().size() - 1));
			PVector dir = PVector.sub(seguir, pos);
			dir.normalize();
			dir.mult((float) 0.5);
			ace = dir;
			vel.add(ace);
			vel.limit(max);
			pos.add(vel);

		}

	
		}

