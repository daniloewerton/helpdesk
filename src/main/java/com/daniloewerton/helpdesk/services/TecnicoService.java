package com.daniloewerton.helpdesk.services;

import com.daniloewerton.helpdesk.domain.Pessoa;
import com.daniloewerton.helpdesk.domain.Tecnico;
import com.daniloewerton.helpdesk.domain.dtos.TecnicoDTO;
import com.daniloewerton.helpdesk.repositories.PessoaRepository;
import com.daniloewerton.helpdesk.repositories.TecnicoRepository;
import com.daniloewerton.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.daniloewerton.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico create(TecnicoDTO objDTO) {
        objDTO.setId(null);
        validaPorCpfEEmail(objDTO);
        Tecnico newObj = new Tecnico(objDTO);
        return repository.save(newObj);
    }

    private void validaPorCpfEEmail(TecnicoDTO objDTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }

        obj = pessoaRepository.findByEmail(objDTO.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
        }
    }
}
