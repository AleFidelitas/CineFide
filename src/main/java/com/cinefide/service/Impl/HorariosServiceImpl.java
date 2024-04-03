package com.cinefide.service.Impl;

import com.cinefide.dao.HorariosDao;
import com.cinefide.domain.Horarios;
import com.cinefide.service.HorariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HorariosServiceImpl implements HorariosService {

    @Autowired
    private HorariosDao horariosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Horarios> getHorarios(boolean activo) {
        var lista = horariosDao.findAll();

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Horarios getHorarios(Horarios horarios) {
        return horariosDao.findById(horarios.getIdPelicula()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Horarios horarios) {
        horariosDao.save(horarios);
    }

    @Override
    @Transactional
    public void delete(Horarios horarios) {
        horariosDao.delete(horarios);
    }

}
