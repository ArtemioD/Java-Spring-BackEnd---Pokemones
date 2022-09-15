package clases;

public enum Ataque {
	LANZALLAMAS("Lanzallamas", 5),
	AGILIDAD("Agilidad", 2),
	TRUENO("Trueno", 4),
	COLA_DE_HIERRO("Cola de hierro", 3);
	
	private final String name;
	private final int potencia;
	
	private Ataque(String name, int potencia) {
		this.name = name;
		this.potencia = potencia;
	}

	public String getName() {
		return name;
	}

	public int getPotencia() {
		return potencia;
	}
	
	
}
