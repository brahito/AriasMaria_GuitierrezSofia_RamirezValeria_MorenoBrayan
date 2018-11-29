package finalAlgoritmos;

import java.util.ArrayList;
import java.util.LinkedList;

import processing.core.PApplet;

public class Mundo {
	private PApplet app;

	private ArrayList<Arana> aranas;
	private ArrayList<Escorpion> escorpiones;
	private LinkedList<Bonificador> bonificadores;
	private int  contadorFresasA, contadorFresasB, generarBonificador;
	private Serpiente serpiente;
	private SerpienteB serpienteB;
	private Recurso fresa;

	public Mundo(PApplet app) {
		this.app = app;
		fresa = new Recurso(app);
		aranas = new ArrayList<Arana>();
		escorpiones = new ArrayList<Escorpion>();
		bonificadores = new LinkedList<Bonificador>();

		serpiente = new Serpiente(app, this);
		serpienteB = new SerpienteB(app, this);
		for (int i = 0; i < 3; i++) {
			Arana a = new AranaA(app, this);
			aranas.add(a);
			a.start();
		}

		for (int i = 0; i < 3; i++) {
			Arana a = new AranaR(app, this);
			aranas.add(a);
			a.start();
		}
		for (int i = 0; i < 3; i++) {
			Escorpion e = new EscorpionA(app, this);
			e.start();
			escorpiones.add(e);
		}
		serpiente.start();
		serpienteB.start();
		contadorFresasA = 0;
		contadorFresasB = 0;
	}

	public void pintar() {
		fresa.pintar();
		serpiente.pintar();
		serpienteB.pintar();
		generarBonificador++;
		for (int i = 0; i < aranas.size(); i++) {
			aranas.get(i).pintar();
		}
		for (int i = 0; i < escorpiones.size(); i++) {
			escorpiones.get(i).pintar();
		}
		for (int i = 0; i < aranas.size(); i++) {
			aranas.get(i).pintar();
		}
		if (generarBonificador >= 400) {
			int generar = (int) app.random(1, 5);
			switch (generar) {
			case 1:
				bonificadores.add(new Cafe(app));
				break;
			case 2:
				bonificadores.add(new Hielo(app));
				break;
			case 3:
				bonificadores.add(new Dientes(app));
				break;
			case 4:
				bonificadores.add(new Hongo(app));
				break;
			}
			generarBonificador = 0;
		}
		for (int i = 0; i < bonificadores.size(); i++) {
			bonificadores.get(i).pintar();
		}
	}



	public LinkedList<Bonificador> getBonificadores() {
		return bonificadores;
	}

	public Serpiente getSerA() {
		return serpiente;
	}

	public void serpienteATecla() {
		serpiente.mover();
	}
	

	public SerpienteB getSerB() {
		return serpienteB;
	}

	public void serpienteBTecla() {
		serpienteB.mover();
	}

	public Recurso getRecurso() {
		return fresa;
	}

	public ArrayList<Arana> getAranas() {
		return aranas;
	}

	public ArrayList<Escorpion> getEscorpion() {
		return escorpiones;
	}

	public void setRecurso(Recurso fresa) {
		this.fresa = fresa;
	}
	public int getContadorFresaA() {
		return contadorFresasA;
	}
	public int getContadorFresaB() {
		return contadorFresasB;
	}
	/**
	 * suma el numero de fresas de la serpiente
	 * 
	 * @param a - la cantidad que sumaran las fresas
	 */
	public void masContadorFresaA(int a) {
		contadorFresasA += a;
	}

	public void masContadorFresaB(int a) {
		contadorFresasB += a;
	}

	/**
	 * resta el numero de fresas de la serpiente
	 * 
	 * @param a - la cantidad que restaran las fresas
	 */
	public void BajarContadorFresaA(int a) {
		contadorFresasA -= a;
	}
	
	public void BajarContadorFresaB(int a) {
		contadorFresasB -= a;
	}
	public boolean ganar() {
		boolean ganoA = false;
		for (int i = 0; i < aranas.size(); i++) {

			if (contadorFresasA > aranas.get(i).getFresas() && contadorFresasA> contadorFresasB) {
				ganoA = true;
			} else if (contadorFresasA < aranas.get(i).getFresas()) {
				ganoA = false;
			}
			else if (contadorFresasA < contadorFresasB) {
				ganoA = false;
			}

		}
		return ganoA;
	}
}
