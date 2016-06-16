package ec.com.hoteleraWeb.safari.seguridad.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bitacora")
public class Bitacora implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(allocationSize = 1, name = "bitacora_bit_cod_seq", sequenceName = "bitacora_bit_cod_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bitacora_bit_cod_seq")
	@Column(name = "bit_cod")
	private Integer bitCod;

	@Column(name = "bit_fecha")
	private Timestamp bitFecha;

	@Column(name = "bit_metodo")
	private String bitMetodo;

	@ManyToOne
	@JoinColumn(name = "usu_id", nullable = false)
	private Usuario bitUsuario;

	public Bitacora() {
	}

	public Bitacora(Timestamp bitFecha, String bitMetodo, Usuario bitUsuario) {
		this.bitFecha = bitFecha;
		this.bitMetodo = bitMetodo;
		this.bitUsuario = bitUsuario;
	}

	public Integer getBitCod() {
		return this.bitCod;
	}

	public void setBitCod(Integer bitCod) {
		this.bitCod = bitCod;
	}

	public Usuario getBitUsuario() {
		return this.bitUsuario;
	}

	public void setBitUsuario(Usuario bitUsuario) {
		this.bitUsuario = bitUsuario;
	}

	public Timestamp getBitFecha() {
		return this.bitFecha;
	}

	public void setBitFecha(Timestamp bitFecha) {
		this.bitFecha = bitFecha;
	}

	public String getBitMetodo() {
		return this.bitMetodo;
	}

	public void setBitMetodo(String bitMetodo) {
		this.bitMetodo = bitMetodo;
	}

}