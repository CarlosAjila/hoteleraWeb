package ec.com.hoteleraWeb.safari.control.entityAux;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReporteClienteReservacionTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "cli_cedula")
	private String cliCedula;

	@Column(name = "cli_nombre")
	private String cliNombre;

	@Column(name = "hot_codigo")
	private String hotCodigo;

	@Column(name = "hot_nombre")
	private String hotNombre;
	
	@Column(name = "hot_ruc")
	private String hotRuc;

	public ReporteClienteReservacionTO() {

	}
	
	public ReporteClienteReservacionTO(Integer id, String cliCedula, String cliNombre, String hotCodigo,
			String hotNombre, String hotRuc) {
	
		this.id = id;
		this.cliCedula = cliCedula;
		this.cliNombre = cliNombre;
		this.hotCodigo = hotCodigo;
		this.hotNombre = hotNombre;
		this.hotRuc = hotRuc;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCliCedula() {
		return cliCedula;
	}

	public void setCliCedula(String cliCedula) {
		this.cliCedula = cliCedula;
	}

	public String getCliNombre() {
		return cliNombre;
	}

	public void setCliNombre(String cliNombre) {
		this.cliNombre = cliNombre;
	}

	public String getHotCodigo() {
		return hotCodigo;
	}

	public void setHotCodigo(String hotCodigo) {
		this.hotCodigo = hotCodigo;
	}

	public String getHotNombre() {
		return hotNombre;
	}

	public void setHotNombre(String hotNombre) {
		this.hotNombre = hotNombre;
	}

	public String getHotRuc() {
		return hotRuc;
	}

	public void setHotRuc(String hotRuc) {
		this.hotRuc = hotRuc;
	}



}
