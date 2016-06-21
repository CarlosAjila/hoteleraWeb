package ec.com.hoteleraWeb.safari.utils.enums;

/*
 empleados de gestión (a los cuales debe de pertenecer el director de cada hotel), camareros, limpieza, mantenimiento de las instalaciones, y empleados de animación.
 */
public enum TipoEmpleado {
	DIRECTOR(1, "DIRECTOR"), CAMARERO(2, "CAMARERO"), LIMPIEZA(3, "LIMPIEZA"), MANTENIMIENTO(3, "MANTENIMIENTO DE LAS INSTALACIONES"), ANIMACION(3, "EMPLEADO DE ANIMACIÓN");

	private final Integer id;
	private final String nombre;

	private TipoEmpleado(Integer id, String nombre) {
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
