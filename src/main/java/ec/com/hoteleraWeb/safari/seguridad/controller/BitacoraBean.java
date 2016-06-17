package ec.com.hoteleraWeb.safari.seguridad.controller;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("session")
public class BitacoraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// @Autowired
	// BitacoraService bitacoraService;
	//
	// @Autowired
	// UsuarioService usuarioService;
	//
	// private Usuario usuario;
	// private String criterio;
	// private Date fechaInicio;
	//
	// List<Bitacora> listaBitacora;
	// List<Usuario> listausuarioes;
	//
	// public BitacoraBean() {
	// }
	//
	// public void buscarUsuario() {
	// listausuarioes = usuarioService.obtenerTodosPorBusqueda(criterio);
	// }
	//
	// public void cargarUsuario(SelectEvent event) {
	// usuario = usuarioService.obtenerPorUsuarioId(usuario.getUsuId());
	// }
	//
	// public void consultar() {
	// listaBitacora = new ArrayList<Bitacora>();
	// listaBitacora = bitacoraService.obtener(usuario.getUsuId(), fechaInicio);
	// }
	//
	// public String getCriterio() {
	// return criterio;
	// }
	//
	// public Date getFechaInicio() {
	// return fechaInicio;
	// }
	//
	// public List<Bitacora> getListaBitacora() {
	// return listaBitacora;
	// }
	//
	// public List<Usuario> getListausuarioes() {
	// return listausuarioes;
	// }
	//
	// public Usuario getusuario() {
	// return usuario;
	// }
	//
	// @PostConstruct
	// public void init() {
	// usuario = new Usuario();
	// fechaInicio = new Date();
	// }
	//
	// public void setCriterio(String criterio) {
	// this.criterio = criterio;
	// }
	//
	// public void setFechaInicio(Date fechaInicio) {
	// this.fechaInicio = fechaInicio;
	// }
	//
	// public void setListaBitacora(List<Bitacora> listaBitacora) {
	// this.listaBitacora = listaBitacora;
	// }
	//
	// public void setListausuarioes(List<Usuario> listausuarioes) {
	// this.listausuarioes = listausuarioes;
	// }
	//
	// public void setusuario(Usuario usuario) {
	// this.usuario = usuario;
	// }

}