package ec.com.hoteleraWeb.safari.utils.enums;

public enum Titulo {
	PRIMARIA(1, "PRIMARIA"), SECUNDARIA(2, "SECUNDARIA"), SUPERIOR(3, "SUPERIOR");

	private final Integer id;
	private final String nombre;

	private Titulo(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
}
