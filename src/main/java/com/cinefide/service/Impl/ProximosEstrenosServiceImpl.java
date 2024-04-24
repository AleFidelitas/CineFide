package com.cinefide.service.Impl;

import com.cinefide.dao.CarteleraDao;
import com.cinefide.domain.Cartelera;
import com.cinefide.service.CarteleraService;
import com.cinefide.dao.proximosEstrenosDao;
import com.cinefide.domain.proximosEstrenos;
import com.cinefide.service.proximosEstrenosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarteleraServiceImpl implements CarteleraService{
public class proximosEstrenosServiceImpl implements proximosEstrenosService{
    
    @Autowired
    private CarteleraDao carteleraDao;
    private proximosEstrenosDao proximosEstrenosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cartelera> getCartelera(boolean activo) {
        var lista=carteleraDao.findAll();
    public List<proximosEstrenos> getProximosEstrenos(boolean activo) {
        var lista = proximosEstrenosDao.findAll();

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Cartelera getCartelera(Cartelera cartelera) {
        return carteleraDao.findById(cartelera.getIdPelicula()).orElse(null);
    public proximosEstrenos getProximosEstrenos(proximosEstrenos proximosestrenos) {
        return proximosEstrenosDao.findById(proximosestrenos.getIdPelicula()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cartelera cartelera) {
        carteleraDao.save(cartelera);
    public void save(proximosEstrenos proximosestrenos) {
        proximosEstrenosDao.save(proximosestrenos);
    }

    @Override
    @Transactional
    public void delete(Cartelera cartelera) {
        carteleraDao.delete(cartelera);
    public void delete(proximosEstrenos proximosestrenos) {
        proximosEstrenosDao.delete(proximosestrenos);
    }
    
}
