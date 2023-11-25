package com.booster.cinemagic.configuracion;

import com.booster.cinemagic.filtros.JwtSolicitudFiltro;
import com.booster.cinemagic.servicios.autentificacion.DetallesUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SeguridadConfiguracion extends WebSecurityConfigurerAdapter {

    @Autowired
    DetallesUsuarioServicio detallesUsuarioServicio;

    @Autowired
    private JwtSolicitudFiltro jwtSolicitudFiltro;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .csrf().disable()///en la documentacion si es api rest csrf debe estar disable
                .authorizeRequests()
                .antMatchers("/cinemagic/v0/autentificar").permitAll()
                .anyRequest().authenticated()
                .and().cors()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtSolicitudFiltro, UsernamePasswordAuthenticationFilter.class);
    }


    /*
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .httpBasic(Customizer.withDefaults())
                .authorizeRequests()
                .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("veronica.guapo").password("{noop}" + "1234567890").roles("");
    }

     */



}
