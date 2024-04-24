package com.cinefide.service.Impl;

import com.cinefide.dao.ValoracionDao;
import com.cinefide.domain.Valoracion;
import com.cinefide.service.ValoracionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ValoracionServiceImpl implements ValoracionService{
    
    @Autowired
    private ValoracionDao valoracionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Valoracion> getValoracion(boolean activo) {
        var lista=valoracionDao.findAll();

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Valoracion getValoracion(Valoracion valoracion) {
        return valoracionDao.findById(valoracion.getIdPelicula()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Valoracion valoracion) {
        valoracionDao.save(valoracion);
    }

    @Override
    @Transactional
    public void delete(Valoracion valoracion) {
        valoracionDao.delete(valoracion);
    }
    
}
