package com.cinefide.service.Impl;

import com.cinefide.dao.PromocionDao;
import com.cinefide.domain.Promocion;
import com.cinefide.service.PromocionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PromocionServiceImpl implements PromocionService{
    
    @Autowired
    private PromocionDao promocionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Promocion> getPromocion(boolean activo) {
        var lista=promocionDao.findAll();
        
        if (activo){
            lista.removeIf(c -> !c.isActivo());
        }
        
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Promocion getPromocion(Promocion promocion) {
        return promocionDao.findById(promocion.getIdPromocion()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Promocion promocion) {
        promocionDao.save(promocion);
    }

    @Override
    @Transactional
    public void delete(Promocion promocion) {
        promocionDao.delete(promocion);
    }
    
}
