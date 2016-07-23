package ec.com.hoteleraWeb.safari.control.entityAux;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FacturaTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "hot_codigo")
	private String hotCodigo;

	@Column(name = "hot_ruc")
	private String hotRuc;

	@Column(name = "hot_nombre")
	private String hotNombre;

	@Column(name = "hot_direccion")
	private String hotDireccion;

	@Column(name = "hot_telefono")
	private String hotTelefono;

	@Column(name = "cli_cedula")
	private String cliCedula;

	@Column(name = "cli_nombres")
	private String cliNombres;

	@Column(name = "cli_direccion")
	private String cliDireccion;

	@Column(name = "cli_telefono")
	private String cliTelefono;

	@Column(name = "cli_movil")
	private String cliMovil;

	@Column(name = "total_suplemento")
	private BigDecimal totalSuplemento;

	@Column(name = "total_suplemento_temporada")
	private BigDecimal totalSuplementoTemporada;

	@Column(name = "total_habitacion")
	private BigDecimal totalHabitacion;

	@Column(name = "total_actividad")
	private BigDecimal totalActividad;

	@Column(name = "subtotal_a_pagar")
	private BigDecimal subtotalPagar;

	@Column(name = "total_abono")
	private BigDecimal totalAbono;

	@Column(name = "total_a_pagar")
	private BigDecimal totalPagar;

	@Column(name = "iva_vigente")
	private BigDecimal ivaVigente;

	@Column(name = "monto_iva")
	private BigDecimal montoIva;

	public FacturaTO() {

	}

	public BigDecimal getTotalSuplemento() {
		return totalSuplemento;
	}

	public void setTotalSuplemento(BigDecimal totalSuplemento) {
		this.totalSuplemento = totalSuplemento;
	}

	public BigDecimal getTotalSuplementoTemporada() {
		return totalSuplementoTemporada;
	}

	public void setTotalSuplementoTemporada(BigDecimal totalSuplementoTemporada) {
		this.totalSuplementoTemporada = totalSuplementoTemporada;
	}

	public BigDecimal getTotalHabitacion() {
		return totalHabitacion;
	}

	public void setTotalHabitacion(BigDecimal totalHabitacion) {
		this.totalHabitacion = totalHabitacion;
	}

	public BigDecimal getTotalActividad() {
		return totalActividad;
	}

	public void setTotalActividad(BigDecimal totalActividad) {
		this.totalActividad = totalActividad;
	}

	public BigDecimal getSubtotalPagar() {
		return subtotalPagar;
	}

	public void setSubtotalPagar(BigDecimal subtotalPagar) {
		this.subtotalPagar = subtotalPagar;
	}

	public BigDecimal getTotalAbono() {
		return totalAbono;
	}

	public void setTotalAbono(BigDecimal totalAbono) {
		this.totalAbono = totalAbono;
	}

	public BigDecimal getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(BigDecimal totalPagar) {
		this.totalPagar = totalPagar;
	}

	public BigDecimal getIvaVigente() {
		return ivaVigente;
	}

	public void setIvaVigente(BigDecimal ivaVigente) {
		this.ivaVigente = ivaVigente;
	}

	public BigDecimal getMontoIva() {
		return montoIva;
	}

	public void setMontoIva(BigDecimal montoIva) {
		this.montoIva = montoIva;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHotCodigo() {
		return hotCodigo;
	}

	public void setHotCodigo(String hotCodigo) {
		this.hotCodigo = hotCodigo;
	}

	public String getHotRuc() {
		return hotRuc;
	}

	public void setHotRuc(String hotRuc) {
		this.hotRuc = hotRuc;
	}

	public String getHotNombre() {
		return hotNombre;
	}

	public void setHotNombre(String hotNombre) {
		this.hotNombre = hotNombre;
	}

	public String getHotDireccion() {
		return hotDireccion;
	}

	public void setHotDireccion(String hotDireccion) {
		this.hotDireccion = hotDireccion;
	}

	public String getHotTelefono() {
		return hotTelefono;
	}

	public void setHotTelefono(String hotTelefono) {
		this.hotTelefono = hotTelefono;
	}

	public String getCliCedula() {
		return cliCedula;
	}

	public void setCliCedula(String cliCedula) {
		this.cliCedula = cliCedula;
	}

	public String getCliNombres() {
		return cliNombres;
	}

	public void setCliNombres(String cliNombres) {
		this.cliNombres = cliNombres;
	}

	public String getCliDireccion() {
		return cliDireccion;
	}

	public void setCliDireccion(String cliDireccion) {
		this.cliDireccion = cliDireccion;
	}

	public String getCliTelefono() {
		return cliTelefono;
	}

	public void setCliTelefono(String cliTelefono) {
		this.cliTelefono = cliTelefono;
	}

	public String getCliMovil() {
		return cliMovil;
	}

	public void setCliMovil(String cliMovil) {
		this.cliMovil = cliMovil;
	}

}