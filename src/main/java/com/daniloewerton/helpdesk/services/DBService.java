package com.daniloewerton.helpdesk.services;

import com.daniloewerton.helpdesk.domain.Chamado;
import com.daniloewerton.helpdesk.domain.Cliente;
import com.daniloewerton.helpdesk.domain.Tecnico;
import com.daniloewerton.helpdesk.domain.enums.Perfil;
import com.daniloewerton.helpdesk.domain.enums.Prioridade;
import com.daniloewerton.helpdesk.domain.enums.Status;
import com.daniloewerton.helpdesk.repositories.ChamadoRepository;
import com.daniloewerton.helpdesk.repositories.ClienteRepository;
import com.daniloewerton.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instaciaDB() {

        Tecnico tec1 = new Tecnico(null, "Danilo Ewerton", "38644846000", "danilo@email.com", "123");
        tec1.addPerfil(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Linus Torvalds", "66593361097", "torvalds@email.com", "123");

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1));
    }
}