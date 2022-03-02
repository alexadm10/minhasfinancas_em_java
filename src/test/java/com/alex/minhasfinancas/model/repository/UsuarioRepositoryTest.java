package com.alex.minhasfinancas.model.repository;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.alex.minhasfinancas.model.entity.Usuario;



@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioRepositoryTest {
	
	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	TestEntityManager entityManager;
	
	@Test
	public void deveVerificarAExistenciaDeUmEmail() {
		
		//cenário = cadastrando usuario
		Usuario usuario = Usuario.builder().nome("usuario").email("alexadm10@hotmail.com").build();
		entityManager.persist(usuario);
		
		
		//acão/execução
		boolean result = repository.existsByEmail("alexadm10@hotmail.com");
		
		
		//verificação
		org.assertj.core.api.Assertions.assertThat(result).isTrue();
	}
	
	
	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOEmail() {
		
		repository.deleteAll();
		
		boolean result = repository.existsByEmail("alexadm10@hotmail.com");
		
		org.assertj.core.api.Assertions.assertThat(result).isFalse();
		
	}
	
	

}
