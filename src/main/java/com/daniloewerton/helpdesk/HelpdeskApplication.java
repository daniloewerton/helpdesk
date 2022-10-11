package com.daniloewerton.helpdesk;

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
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelpdeskApplication.class, args);
    }

}
