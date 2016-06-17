package ec.com.hoteleraWeb.safari.seguridad.aspect;

import java.io.Serializable;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BitacoraAspect implements Serializable {

	private static final long serialVersionUID = 1L;

	// @Autowired
	// public BitacoraDao bitacoraDao;
	//
	// @Autowired
	// public UsuarioService usuarioService;
	//
	// @After("execution(public *
	// ec.com.hoteleraWeb.safari.control.service..*.eliminar(..)) "
	// + "|| execution(public *
	// ec.com.hoteleraWeb.safari.control.service..*.eliminar(..)) ")
	// public void auditarEliminar(JoinPoint joinPoint) {
	// Object obj = (joinPoint.getArgs())[0];
	// String mensaje = "";
	// try {
	// String nombreObjeto = obj.getClass().getSimpleName();
	// Method metodo = obj.getClass().getMethod("get" + nombreObjeto + "id", new
	// Class[] {});
	// Method metodoEliminar = obj.getClass().getMethod("getActivo", new Class[]
	// {});
	//
	// if ((Boolean) metodoEliminar.invoke(obj, new Object[] {}))
	// mensaje = "Se Activó el objeto " + nombreObjeto + " con la llave: # "
	// + metodo.invoke(obj, new Object[] {});
	// else
	// mensaje = "Se Desactivó el objeto " + nombreObjeto + " con la llave: # "
	// + metodo.invoke(obj, new Object[] {});
	//
	// } catch (Exception e) {
	// mensaje = "error al leer método";
	// }
	// String cedula =
	// SecurityContextHolder.getContext().getAuthentication().getName();
	// if (cedula.compareTo("0123456789") != 0)
	// bitacoraDao.insertar(new Bitacora(new Timestamp((new Date()).getTime()),
	// mensaje,
	// usuarioService.obtenerPorCedula(cedula)));
	// }
	//
	// @After("execution(public *
	// ec.com.hoteleraWeb.safari.control.service..*.insertar(..)) "
	// + "|| execution(public *
	// ec.com.hoteleraWeb.safari.control.service..*.actualizar(..)) ")
	// public void auditar(JoinPoint joinPoint) {
	// Object obj = (joinPoint.getArgs())[0];
	// String mensaje = "";
	// try {
	// String nombreObjeto = obj.getClass().getSimpleName();
	// Method metodo = obj.getClass().getMethod("get" + nombreObjeto + "id", new
	// Class[] {});
	// mensaje = "Se acaba de " + joinPoint.getSignature().getName() + " el
	// objeto " + nombreObjeto
	// + " con la llave: # " + metodo.invoke(obj, new Object[] {});
	// } catch (Exception e) {
	// mensaje = "error al leer método";
	// }
	// String cedula =
	// SecurityContextHolder.getContext().getAuthentication().getName();
	// System.out.println(cedula);
	// if (cedula.compareTo("0123456789") != 0)
	// bitacoraDao.insertar(new Bitacora(new Timestamp((new Date()).getTime()),
	// mensaje,
	// usuarioService.obtenerPorCedula(cedula)));
	// }
	//
	// @After("execution(public *
	// ec.com.hoteleraWeb.safari.seguridad.service.MenuService.obtenerPorUsuario(..))
	// ")
	// public void ingreso(JoinPoint joinPoint) {
	// String cedula =
	// SecurityContextHolder.getContext().getAuthentication().getName();
	// if (cedula.compareTo("0123456789") != 0)
	// bitacoraDao.insertar(new Bitacora(new Timestamp((new Date()).getTime()),
	// "Ingresó al Sistema",
	// usuarioService.obtenerActivoPorNick(cedula)));
	// }
}