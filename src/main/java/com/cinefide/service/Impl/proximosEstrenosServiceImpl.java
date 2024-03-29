package com.cinefide.service.Impl;

import com.cinefide.dao.proximosEstrenosDao;
import com.cinefide.domain.proximosEstrenos;
import com.cinefide.service.proximosEstrenosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class proximosEstrenosServiceImpl implements proximosEstrenosService{
    
    @Autowired
    private proximosEstrenosDao proximosEstrenosDao;

    @Override
    @Transactional(readOnly = true)
    public List<proximosEstrenos> getProximosEstrenos(boolean activo) {
        var lista = proximosEstrenosDao.findAll();

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public proximosEstrenos getProximosEstrenos(proximosEstrenos proximosestrenos) {
        return proximosEstrenosDao.findById(proximosestrenos.getIdPelicula()).orElse(null);
    }

    @Override
    @Transactional
    public void save(proximosEstrenos proximosestrenos) {
        proximosEstrenosDao.save(proximosestrenos);
    }

    @Override
    @Transactional
    public void delete(proximosEstrenos proximosestrenos) {
        proximosEstrenosDao.delete(proximosestrenos);
    }
    
}
