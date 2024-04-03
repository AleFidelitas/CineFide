package com.cinefide.service.Impl;

import com.cinefide.dao.ReservasDao;
import com.cinefide.domain.Reservas;
import com.cinefide.service.ReservasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservasServiceImpl implements ReservasService {

    @Autowired
    private ReservasDao reservasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Reservas> getReservas(boolean activo) {
        var lista = reservasDao.findAll();

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Reservas getReservas(Reservas reservas) {
        return reservasDao.findById(reservas.getIdPelicula()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Reservas reservas) {
        reservasDao.save(reservas);
    }

    @Override
    @Transactional
    public void delete(Reservas reservas) {
        reservasDao.delete(reservas);
    }

}
