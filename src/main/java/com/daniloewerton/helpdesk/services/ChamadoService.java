package com.daniloewerton.helpdesk.services;

import com.daniloewerton.helpdesk.domain.Chamado;
import com.daniloewerton.helpdesk.repositories.ChamadoRepository;
import com.daniloewerton.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;

    public Chamado findById(Integer id) {
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
    }
}
