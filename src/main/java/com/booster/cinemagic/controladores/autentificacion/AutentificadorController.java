package com.booster.cinemagic.controladores.autentificacion;

import com.booster.cinemagic.servicios.autentificacion.DetallesUsuarioServicio;
import com.booster.cinemagic.servicios.autentificacion.JwtUtilService;
import com.booster.cinemagic.util.AutentificacionModelo;
import com.booster.cinemagic.util.TokenInfoModelo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinemagic/v0")
public class AutentificadorController {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    DetallesUsuarioServicio detallesUsuarioServicio;
    
    @Autowired
    private JwtUtilService jwtUtilService;

    private static final Logger logger = LoggerFactory.getLogger(AutentificadorController.class);


    @PostMapping("/autentificar")
    public ResponseEntity<TokenInfoModelo> autentificar(@RequestBody AutentificacionModelo autentificacion) {
        logger.info("Autenticando al usuario {}", autentificacion.getUsuario());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(autentificacion.getUsuario(),
                        autentificacion.getClave()));

        final UserDetails userDetails = detallesUsuarioServicio.loadUserByUsername(
                autentificacion.getUsuario());

        final String jwt = jwtUtilService.generateToken(userDetails);

        TokenInfoModelo tokenInfo = new TokenInfoModelo(jwt);

        return ResponseEntity.ok(tokenInfo);
    }
    
    
    
    
}
