package ec.com.hoteleraWeb.safari.utils.enums;

public enum TipoHabitacion {
	SIMPLE(1, "SIMPLE"), DOBLE(2, "DOBLE"), TRIPLE(3, "TRIPLE"), MATRIMONIAL(4, "MATRIMONIAL"), SUITE(4, "SUITE");

	private final Integer id;
	private final String nombre;

	private TipoHabitacion(Integer id, String nombre) {
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
