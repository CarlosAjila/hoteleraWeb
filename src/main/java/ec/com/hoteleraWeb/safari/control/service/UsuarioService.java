package ec.com.hoteleraWeb.safari.control.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ec.com.hoteleraWeb.safari.control.entity.Usuario;

public interface UsuarioService {

	@Transactional
	public void cambiarClave(String claveActual, String clave1, String clave2);

	@Transactional
	public boolean compararClave(String clave1, String clave2);

	@Transactional
	public boolean comprobarRol(String cedula, String rol);

	@Transactional
	public Long contar();

	@Transactional
	public void eliminar(Usuario usuario);

	@Transactional
	public String generarClave(String clave);

	@Transactional
	public boolean insertar(Usuario usuario);

	@Transactional
	public String insertarRoles(Usuario usuario, List<String> roles);

	@Transactional
	public List<Usuario> obtener(Boolean activo);

	@Transactional
	public Usuario obtenerActivoPorNick(String nick);

	@Transactional
	public Usuario obtenerPorCedula(String cedula);

	@Transactional
	public Usuario obtenerPorUsuarioId(Integer usuarioId);

	@Transactional
	public List<Usuario> obtenerTodosPorBusqueda(String criterioBusqueda);

	@Transactional
	public List<String> obtenerListaUsuarioAutoComplete(String criterioUsuarioBusqueda);

	@Transactional
	public List<Usuario> obtenerUsuarios(String criterioUsuarioBusqueda);

	@Transactional
	public Usuario cargarUsuario(String usuario);
}