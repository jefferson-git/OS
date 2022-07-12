package br.com.os.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
	
	@Bean
	public ModelMapper mapeando() {
		return new ModelMapper();
	}
}
