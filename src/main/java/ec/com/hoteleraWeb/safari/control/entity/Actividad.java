package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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

@Entity
@Table(name = "actividad")
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "actividad_act_codigo_seq", sequenceName = "actividad_act_codigo_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actividad_act_codigo_seq")
	@Column(name = "act_codigo")
	private Integer actCodigo;

	@Column(name = "act_descripcion")
	private String actDescripcion;

	@Column(name = "act_nombre")
	private String actNombre;

	@Column(name = "act_numero_personas")
	private Integer actNumeroPersonas;

	@Column(name = "act_pagado")
	private Boolean actPagado;

	@Column(name = "act_activo")
	private Boolean actActivo;

	@Column(name = "act_valor")
	private BigDecimal actValor;

	// bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name = "emp_codigo")
	private Empleado empleado;

	// bi-directional many-to-one association to Calendario
	@OneToMany(mappedBy = "actividad")
	private List<Calendario> calendarios;

	// bi-directional many-to-one association to ClienteActividad
	@OneToMany(mappedBy = "actividad")
	private List<ClienteActividad> clienteActividads;

	public Actividad() {
	}

	public Integer getActCodigo() {
		return this.actCodigo;
	}

	public void setActCodigo(Integer actCodigo) {
		this.actCodigo = actCodigo;
	}

	public String getActDescripcion() {
		return this.actDescripcion;
	}

	public void setActDescripcion(String actDescripcion) {
		this.actDescripcion = actDescripcion;
	}

	public String getActNombre() {
		return this.actNombre;
	}

	public void setActNombre(String actNombre) {
		this.actNombre = actNombre;
	}

	public Boolean getActPagado() {
		return this.actPagado;
	}

	public Boolean getActActivo() {
		return actActivo;
	}

	public void setActActivo(Boolean actActivo) {
		this.actActivo = actActivo;
	}

	public void setActPagado(Boolean actPagado) {
		this.actPagado = actPagado;
	}

	public BigDecimal getActValor() {
		return this.actValor;
	}

	public void setActValor(BigDecimal actValor) {
		this.actValor = actValor;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Integer getActNumeroPersonas() {
		return actNumeroPersonas;
	}

	public void setActNumeroPersonas(Integer actNumeroPersonas) {
		this.actNumeroPersonas = actNumeroPersonas;
	}

	public List<Calendario> getCalendarios() {
		return this.calendarios;
	}

	public void setCalendarios(List<Calendario> calendarios) {
		this.calendarios = calendarios;
	}

	public Calendario addCalendario(Calendario calendario) {
		getCalendarios().add(calendario);
		calendario.setActividad(this);

		return calendario;
	}

	public Calendario removeCalendario(Calendario calendario) {
		getCalendarios().remove(calendario);
		calendario.setActividad(null);

		return calendario;
	}

	public List<ClienteActividad> getClienteActividads() {
		return this.clienteActividads;
	}

	public void setClienteActividads(List<ClienteActividad> clienteActividads) {
		this.clienteActividads = clienteActividads;
	}

	public ClienteActividad addClienteActividad(ClienteActividad clienteActividad) {
		getClienteActividads().add(clienteActividad);
		clienteActividad.setActividad(this);

		return clienteActividad;
	}

	public ClienteActividad removeClienteActividad(ClienteActividad clienteActividad) {
		getClienteActividads().remove(clienteActividad);
		clienteActividad.setActividad(null);

		return clienteActividad;
	}

}