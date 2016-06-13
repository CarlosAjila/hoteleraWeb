package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cliente_actividad database table.
 * 
 */
@Entity
@Table(name="cliente_actividad")
@NamedQuery(name="ClienteActividad.findAll", query="SELECT c FROM ClienteActividad c")
public class ClienteActividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cli_act_id")
	private Integer cliActId;

	@Column(name="act_codigo")
	private Integer actCodigo;

	@Column(name="num_persona")
	private Integer numPersona;

	@Column(name="res_codigo")
	private Integer resCodigo;

	public ClienteActividad() {
	}

	public Integer getCliActId() {
		return this.cliActId;
	}

	public void setCliActId(Integer cliActId) {
		this.cliActId = cliActId;
	}

	public Integer getActCodigo() {
		return this.actCodigo;
	}

	public void setActCodigo(Integer actCodigo) {
		this.actCodigo = actCodigo;
	}

	public Integer getNumPersona() {
		return this.numPersona;
	}

	public void setNumPersona(Integer numPersona) {
		this.numPersona = numPersona;
	}

	public Integer getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(Integer resCodigo) {
		this.resCodigo = resCodigo;
	}

}