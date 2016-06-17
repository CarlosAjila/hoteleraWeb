package ec.com.hoteleraWeb.safari.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import ec.com.hoteleraWeb.safari.utils.Conexion;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:database.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/javax.faces.resource/**", "/resources/**", "/login.jsf")
				.permitAll().antMatchers("/views/home.jsf").access("isAuthenticated()")

				.antMatchers("/views/sistema/listadoHoteles.jsf").hasAnyAuthority("ADMINISTRADOR")

				.antMatchers("/views/seguridad/404.jsf").access("isAuthenticated()")
				.antMatchers("/views/seguridad/accesoDenegado.jsf").access("isAuthenticated()")
				.antMatchers("/views/seguridad/cambiarClave.jsf").access("isAuthenticated()")
				.antMatchers("/views/seguridad/cambiarClaveNueva.jsf").access("isAuthenticated()")
				.antMatchers("/views/seguridad/error.jsf").access("isAuthenticated()")

				.and().formLogin().loginPage("/login.jsf").defaultSuccessUrl("/views/home.jsf").and().logout()
				.logoutUrl("/logout.jsf").logoutSuccessUrl("/login.jsf").invalidateHttpSession(true)
				.deleteCookies("JSESSIONID").and().sessionManagement().invalidSessionUrl("/login.jsf")
				.maximumSessions(1);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(this.dataSource()).passwordEncoder(new ShaPasswordEncoder(256))
				.usersByUsernameQuery(getUserQuery()).authoritiesByUsernameQuery(getAuthoritiesQuery());
	}

	@Bean
	public DataSource dataSource() {
		Conexion.iniciarConeccion("postgresql", "org.postgresql.Driver", env.getProperty("jdbc.server"),
				env.getProperty("jdbc.port"), env.getProperty("jdbc.database"), env.getProperty("jdbc.user"),
				env.getProperty("jdbc.password"));

		Conexion conexion = Conexion.getConexion();

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(conexion.getDriver());
		dataSource.setUrl("jdbc:" + conexion.getDb() + "://" + conexion.getServer() + ":" + conexion.getPort() + "/"
				+ conexion.getDatabase());
		dataSource.setUsername(conexion.getUser());
		dataSource.setPassword(conexion.getPassword());

		return dataSource;
	}

	// consulta para saber los roles o permisos de ese usuario
	private String getAuthoritiesQuery() {
		return "select u.usu_nick , r.rol_nombre "
				+ "from public.usuario as u, public.rol as r, public.rol_usuario as ur "
				+ "where u.usu_id = ur.usu_id and r.rol_id = ur.rol_id and ur.rol_usul_ativo=true and u.usu_nick = ?";
	}

	// consulta para el login
	private String getUserQuery() {
		return "select usu_nick, usu_password, usu_activo from public.usuario " + "where usu_nick = ?";
	}
}
