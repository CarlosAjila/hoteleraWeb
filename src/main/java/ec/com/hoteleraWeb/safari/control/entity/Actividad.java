package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "actividad")
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "actividad_act_codigo_seq", sequenceName = "actividad_act_codigo_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actividad_act_codigo_seq")
	@Column(name="act_codigo")
	private Integer actCodigo;

	@Column(name="act_descripcion")
	private String actDescripcion;

	@Column(name="act_nombre")
	private String actNombre;

	@Column(name="act_pagado")
	private Boolean actPagado;

	@Column(name="act_valor")
	private BigDecimal actValor;

	@Column(name="emp_codigo")
	private Integer empCodigo;

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

	public void setActPagado(Boolean actPagado) {
		this.actPagado = actPagado;
	}

	public BigDecimal getActValor() {
		return this.actValor;
	}

	public void setActValor(BigDecimal actValor) {
		this.actValor = actValor;
	}

	public Integer getEmpCodigo() {
		return this.empCodigo;
	}

	public void setEmpCodigo(Integer empCodigo) {
		this.empCodigo = empCodigo;
	}

}