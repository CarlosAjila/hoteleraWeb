package ec.com.hoteleraWeb.safari.control.entity;

import java.io.Serializable;

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
@Table(name = "usuario_detalle")
public class UsuarioDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	//
	@Id
	@SequenceGenerator(allocationSize = 1, name = "usuario_detalle_usu_det_id_seq", sequenceName = "usuario_detalle_usu_det_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_detalle_usu_det_id_seq")
	@Column(name = "usu_det_id")
	private Integer usuDetId;

	@Column(name = "usu_det_nick")
	private String usuDetNick;

	@Column(name = "usu_det_activo")
	private Boolean usuDetActivo;

	// bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name = "hot_codigo")
	private Hotel hotel;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "usu_id")
	private Usuario usuario;

	public UsuarioDetalle() {
	}

	public Integer getUsuDetId() {
		return this.usuDetId;
	}

	public void setUsuDetId(Integer usuDetId) {
		this.usuDetId = usuDetId;
	}
	
	public String getUsuDetNick() {
		return this.usuDetNick;
	}

	public void setUsuDetNick(String usuDetNick) {
		this.usuDetNick = usuDetNick;
	}

	public Boolean getUsuDetActivo() {
		return this.usuDetActivo;
	}

	public void setUsuDetActivo(Boolean usuDetActivo) {
		this.usuDetActivo = usuDetActivo;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}