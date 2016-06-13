package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the reservacion database table.
 * 
 */
@Entity
@NamedQuery(name="Reservacion.findAll", query="SELECT r FROM Reservacion r")
public class Reservacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="res_codigo")
	private Integer resCodigo;

	@Column(name="cli_codigo")
	private Integer cliCodigo;

	@Column(name="emp_codigo")
	private Integer empCodigo;

	@Column(name="res_abono")
	private BigDecimal resAbono;

	@Column(name="res_cancelada")
	private Boolean resCancelada;

	@Temporal(TemporalType.DATE)
	@Column(name="res_fecha_ingreso")
	private Date resFechaIngreso;

	@Temporal(TemporalType.DATE)
	@Column(name="res_fecha_reserva")
	private Date resFechaReserva;

	@Temporal(TemporalType.DATE)
	@Column(name="res_fecha_salido")
	private Date resFechaSalido;

	@Column(name="res_instancia")
	private Boolean resInstancia;

	public Reservacion() {
	}

	public Integer getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(Integer resCodigo) {
		this.resCodigo = resCodigo;
	}

	public Integer getCliCodigo() {
		return this.cliCodigo;
	}

	public void setCliCodigo(Integer cliCodigo) {
		this.cliCodigo = cliCodigo;
	}

	public Integer getEmpCodigo() {
		return this.empCodigo;
	}

	public void setEmpCodigo(Integer empCodigo) {
		this.empCodigo = empCodigo;
	}

	public BigDecimal getResAbono() {
		return this.resAbono;
	}

	public void setResAbono(BigDecimal resAbono) {
		this.resAbono = resAbono;
	}

	public Boolean getResCancelada() {
		return this.resCancelada;
	}

	public void setResCancelada(Boolean resCancelada) {
		this.resCancelada = resCancelada;
	}

	public Date getResFechaIngreso() {
		return this.resFechaIngreso;
	}

	public void setResFechaIngreso(Date resFechaIngreso) {
		this.resFechaIngreso = resFechaIngreso;
	}

	public Date getResFechaReserva() {
		return this.resFechaReserva;
	}

	public void setResFechaReserva(Date resFechaReserva) {
		this.resFechaReserva = resFechaReserva;
	}

	public Date getResFechaSalido() {
		return this.resFechaSalido;
	}

	public void setResFechaSalido(Date resFechaSalido) {
		this.resFechaSalido = resFechaSalido;
	}

	public Boolean getResInstancia() {
		return this.resInstancia;
	}

	public void setResInstancia(Boolean resInstancia) {
		this.resInstancia = resInstancia;
	}

}