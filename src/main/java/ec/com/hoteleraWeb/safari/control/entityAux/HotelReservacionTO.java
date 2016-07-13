package ec.com.hoteleraWeb.safari.control.entityAux;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class HotelReservacionTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "hot_codigo")
	private Integer codigoHotel;

	@Column(name = "hot_nombre")
	private String nombreHotel;

	@Column(name = "costo_reservacion")
	private BigDecimal costoReservacion;

	@Column(name = "cantidad_reservacion")
	private Integer cantidadReservacion;

	public HotelReservacionTO(Integer codigoHotel, String nombreHotel, BigDecimal costoReservacion,
			Integer cantidadReservacion) {
		this.codigoHotel = codigoHotel;
		this.nombreHotel = nombreHotel;
		this.costoReservacion = costoReservacion;
		this.cantidadReservacion = cantidadReservacion;
	}

	public Integer getCodigoHotel() {
		return codigoHotel;
	}

	public void setCodigoHotel(Integer codigoHotel) {
		this.codigoHotel = codigoHotel;
	}

	public String getNombreHotel() {
		return nombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	public BigDecimal getCostoReservacion() {
		return costoReservacion;
	}

	public void setCostoReservacion(BigDecimal costoReservacion) {
		this.costoReservacion = costoReservacion;
	}

	public Integer getCantidadReservacion() {
		return cantidadReservacion;
	}

	public void setCantidadReservacion(Integer cantidadReservacion) {
		this.cantidadReservacion = cantidadReservacion;
	}

}