package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "hotel_hot_codigo_seq", sequenceName = "hotel_hot_codigo_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_hot_codigo_seq")
	@Column(name = "hot_codigo")
	private Integer hotCodigo;

	@Column(name = "hot_direccion")
	private String hotDireccion;

	@Column(name = "hot_estrella")
	private Long hotEstrella;

	@Column(name = "hot_nombre")
	private String hotNombre;

	@Column(name = "hot_ruc")
	private String hotRuc;

	@Column(name = "hot_telefono")
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