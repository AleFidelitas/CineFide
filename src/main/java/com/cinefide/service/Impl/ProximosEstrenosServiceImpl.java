package com.cinefide.service.Impl;

import com.cinefide.dao.CarteleraDao;
import com.cinefide.domain.Cartelera;
import com.cinefide.service.CarteleraService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarteleraServiceImpl implements CarteleraService{
    
    @Autowired
    private CarteleraDao carteleraDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cartelera> getCartelera(boolean activo) {
        var lista=carteleraDao.findAll();

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Cartelera getCartelera(Cartelera cartelera) {
        return carteleraDao.findById(cartelera.getIdPelicula()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cartelera cartelera) {
        carteleraDao.save(cartelera);
    }

    @Override
    @Transactional
    public void delete(Cartelera cartelera) {
        carteleraDao.delete(cartelera);
    }
    
}
