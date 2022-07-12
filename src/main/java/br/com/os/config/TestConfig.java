package br.com.os.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.os.enuns.Prioridade;
import br.com.os.enuns.Status;
import br.com.os.model.Cliente;
import br.com.os.model.Os;
import br.com.os.model.Tecnico;
import br.com.os.repository.ClienteRepository;
import br.com.os.repository.OsRepository;
import br.com.os.repository.TecnicoRepository;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired ClienteRepository clienteRepository;
	@Autowired TecnicoRepository tecnicoRepository;
	@Autowired OsRepository osRepository;
	
	@Bean
	public void CreateDados() {		

		Cliente cliente = new Cliente(null, "jefferson", "253.642.170-86", "(63) 2550-5745");		
		Tecnico tecnico = new Tecnico(null, "jose", "405.420.670-05", "(79) 2291-5995");		
		Os os = new Os(null, "reparo tela celular moto g8", Prioridade.MEDIA, Status.ENCERADO, tecnico, cliente);
		clienteRepository.save(cliente);
		tecnicoRepository.save(tecnico);
		osRepository.save(os);	
	}
}
