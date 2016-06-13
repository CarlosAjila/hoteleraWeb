package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hotel database table.
 * 
 */
@Entity
@NamedQuery(name="Hotel.findAll", query="SELECT h FROM Hotel h")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="hot_codigo")
	private Integer hotCodigo;

	@Column(name="hot_direccion")
	private String hotDireccion;

	@Column(name="hot_estrella")
	private Long hotEstrella;

	@Column(name="hot_nombre")
	private String hotNombre;

	@Column(name="hot_ruc")
	private String hotRuc;

	@Column(name="hot_telefono")
	private String hotTelefono;

	public Hotel() {
	}

	public Integer getHotCodigo() {
		return this.hotCodigo;
	}

	public void setHotCodigo(Integer hotCodigo) {
		this.hotCodigo = hotCodigo;
	}

	public String getHotDireccion() {
		return this.hotDireccion;
	}

	public void setHotDireccion(String hotDireccion) {
		this.hotDireccion = hotDireccion;
	}

	public Long getHotEstrella() {
		return this.hotEstrella;
	}

	public void setHotEstrella(Long hotEstrella) {
		this.hotEstrella = hotEstrella;
	}

	public String getHotNombre() {
		return this.hotNombre;
	}

	public void setHotNombre(String hotNombre) {
		this.hotNombre = hotNombre;
	}

	public String getHotRuc() {
		return this.hotRuc;
	}

	public void setHotRuc(String hotRuc) {
		this.hotRuc = hotRuc;
	}

	public String getHotTelefono() {
		return this.hotTelefono;
	}

	public void setHotTelefono(String hotTelefono) {
		this.hotTelefono = hotTelefono;
	}

}