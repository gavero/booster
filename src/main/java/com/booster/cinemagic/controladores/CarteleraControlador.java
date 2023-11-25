package com.booster.cinemagic.controladores;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cinemagic/v0/cartelera")
public class CarteleraControlador {
    /*

    @Autowired
    ICarteleraServicio carteleraServicio;

    @GetMapping()
    public List<CarteleraEntidad> consultarcarteleras() {
        return carteleraServicio.obtenerCarteleras();
    }

    @GetMapping("/{id}")
    public CarteleraEntidad consultarCarteleraPorId(@PathVariable Integer id) {
        CarteleraEntidad cartelera;
        if(id < 1){
            throw new IdNoValidoExcepcion("El id debe ser numerico y mayor 0", "Error 410", HttpStatus.BAD_REQUEST);
        }

        cartelera = carteleraServicio.obtenerCarteleraPorId(id);
        if(cartelera == null){
            throw new ElementoNoEncontradoExcepcion("No se encontro ninguna cartelera con ese id:" + id,"Error 409",HttpStatus.NOT_FOUND);
        }
        return cartelera;
    }

    @PostMapping()
    public CarteleraEntidad agregarCartelera(@Valid @RequestBody CarteleraEntidad cartelera, BindingResult resultado) {
        if(resultado.hasErrors()){
            throw new DatosInvalidosExcepcion("Error de validacion - Favor de revisar los datos introducidos", "Error 408",HttpStatus.BAD_REQUEST, resultado);
        }
        return carteleraServicio.agregarCartelera(cartelera);
    }

    @PutMapping("/{id}")
    public CarteleraEntidad modificarCartelera(@PathVariable Integer id, @Valid  @RequestBody CarteleraEntidad carteleraModificada, BindingResult resultado) {
        CarteleraEntidad cartelera;
        if(id < 1){
            throw new IdNoValidoExcepcion("El id debe ser numerico y mayor 0", "Error 410",HttpStatus.BAD_REQUEST);
        }
        if(resultado.hasErrors()){
            throw new DatosInvalidosExcepcion("Error de validacion - Favor de revisar los datos introducidos", "Error 408",HttpStatus.BAD_REQUEST, resultado);
        }
        cartelera = carteleraServicio.modificarCartelera(id,carteleraModificada);
        if(cartelera == null){
            throw new ElementoNoEncontradoExcepcion("No se encontro ninguna cartelera con ese id:" + id,"Error 409",HttpStatus.NOT_FOUND);
        }

        return cartelera;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCartelera(@PathVariable Integer id){
        boolean respuesta;
        if(id < 1){
            throw new IdNoValidoExcepcion("El id debe ser numerico y mayor 0", "Error 410",HttpStatus.BAD_REQUEST);
        }
        respuesta = carteleraServicio.eliminarCartelera(id);
        if(!respuesta){
            throw new ElementoNoEncontradoExcepcion("No se encontro ninguna cartelera con ese id:" + id,"Error 409",HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok("Se eliminó la cartelera con id: "+ id);
    }

     */
}
