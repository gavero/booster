package com.booster.cinemagic.servicios.implementacion;

import com.booster.cinemagic.servicios.ICarteleraServicio;
import org.springframework.stereotype.Service;

@Service
public class CarteleraServicio implements ICarteleraServicio {

    /*
    @Autowired
    ICarteleraRepositorio carteleraRepositorio;

    @Override
    public List<CarteleraEntidad> obtenerCarteleras() {
        List<CarteleraEntidad> listaCarteleras = new ArrayList<>();
        listaCarteleras = carteleraRepositorio.findAll();
        return listaCarteleras;
    }

    @Override
    public CarteleraEntidad obtenerCarteleraPorId(Integer id) {
        CarteleraEntidad cartelera = new CarteleraEntidad();
        cartelera = carteleraRepositorio.findById(id).orElse(null);
        return cartelera;
    }

    @Override
    public CarteleraEntidad agregarCartelera(CarteleraEntidad cartelera) {
        return carteleraRepositorio.save(cartelera);
    }

    @Override
    public CarteleraEntidad modificarCartelera(Integer id, CarteleraEntidad cartelera) {
        CarteleraEntidad existeCartelera = obtenerCarteleraPorId(id);

        if (existeCartelera != null) {
            existeCartelera.setFecha(cartelera.getFecha());
            existeCartelera.setHoraInicio(cartelera.getHoraInicio());
            existeCartelera.setHoraFin(cartelera.getHoraFin());
            existeCartelera.setIdEstado(cartelera.getIdEstado());
            existeCartelera.setEstadoDesc(cartelera.getEstadoDesc());
            existeCartelera.setIdSala(cartelera.getIdSala());
            existeCartelera.setSalaDesc(cartelera.getSalaDesc());
            existeCartelera.setIdPelicula(cartelera.getIdPelicula());
            existeCartelera.setPeliculaDesc(cartelera.getPeliculaDesc());
            return carteleraRepositorio.save(existeCartelera);
        } else {
            return null;
        }
    }

    @Override
    public boolean eliminarCartelera(Integer id) {
        boolean esEliminado = true;
        try {
            carteleraRepositorio.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            esEliminado = false;
        }
        return esEliminado;
    }

     */
}
