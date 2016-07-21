package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "reservacion")
public class Reservacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "reservacion_res_codigo_seq", sequenceName = "reservacion_res_codigo_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservacion_res_codigo_seq")
	@Column(name = "res_codigo")
	private Integer resCodigo;

	@Column(name = "res_abono")
	private BigDecimal resAbono;

	@Column(name = "res_cancelada")
	private Boolean resCancelada;

	@Temporal(TemporalType.DATE)
	@Column(name = "res_fecha_ingreso")
	private Date resFechaIngreso;

	@Temporal(TemporalType.DATE)
	@Column(name = "res_fecha_reserva")
	private Date resFechaReserva;

	@Temporal(TemporalType.DATE)
	@Column(name = "res_fecha_salido")
	private Date resFechaSalido;

	@Column(name = "res_instancia")
	private Boolean resInstancia;

	// bi-directional many-to-one association to ClienteActividad
	@OneToMany(mappedBy = "reservacion")
	private List<ClienteActividad> clienteActividads;

	// bi-directional many-to-one association to Factura
	@OneToMany(mappedBy = "reservacion")
	private Factura facturas;

	// bi-directional many-to-one association to HabitacionDetalle
	@OneToMany(mappedBy = "reservacion")
	private List<HabitacionDetalle> habitacionDetalles;

	// bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name = "cli_codigo")
	private Cliente cliente;

	// bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name = "usu_id")
	private Usuario usuario;

	public Reservacion() {
	}

	public Integer getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(Integer resCodigo) {
		this.resCodigo = resCodigo;
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

	public List<ClienteActividad> getClienteActividads() {
		return this.clienteActividads;
	}

	public void setClienteActividads(List<ClienteActividad> clienteActividads) {
		this.clienteActividads = clienteActividads;
	}

	public ClienteActividad addClienteActividad(ClienteActividad clienteActividad) {
		getClienteActividads().add(clienteActividad);
		clienteActividad.setReservacion(this);

		return clienteActividad;
	}

	public ClienteActividad removeClienteActividad(ClienteActividad clienteActividad) {
		getClienteActividads().remove(clienteActividad);
		clienteActividad.setReservacion(null);

		return clienteActividad;
	}

	public Factura getFacturas() {
		return this.facturas;
	}

	public void setFacturas(Factura facturas) {
		this.facturas = facturas;
	}

//	public Factura addFactura(Factura factura) {
//		getFacturas().add(factura);
//		factura.setReservacion(this);
//
//		return factura;
//	}
//
//	public Factura removeFactura(Factura factura) {
//		getFacturas().remove(factura);
//		factura.setReservacion(null);
//
//		return factura;
//	}

	public List<HabitacionDetalle> getHabitacionDetalles() {
		return this.habitacionDetalles;
	}

	public void setHabitacionDetalles(List<HabitacionDetalle> habitacionDetalles) {
		this.habitacionDetalles = habitacionDetalles;
	}

	public HabitacionDetalle addHabitacionDetalle(HabitacionDetalle habitacionDetalle) {
		getHabitacionDetalles().add(habitacionDetalle);
		habitacionDetalle.setReservacion(this);

		return habitacionDetalle;
	}

	public HabitacionDetalle removeHabitacionDetalle(HabitacionDetalle habitacionDetalle) {
		getHabitacionDetalles().remove(habitacionDetalle);
		habitacionDetalle.setReservacion(null);

		return habitacionDetalle;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}