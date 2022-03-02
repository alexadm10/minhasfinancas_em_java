package com.alex.minhasfinancas.service;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.alex.minhasfinancas.model.repository.UsuarioRepository;
import com.alex.minhasfinancas.service.impl.UsuarioServiceImpl;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {


	UsuarioService service;
	
	@MockBean
	UsuarioRepository repository;
	
	@org.junit.Before
	public void setup() {
		
		service = new UsuarioServiceImpl(repository);
	}
	
	
	public void deveValidarEmail() {
		
		Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(false);
		
		service.validarEmail("alexadm10@hotmail.com");
	}
	
	
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		
		Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(true);
		
		service.validarEmail("alexadm10@hotmail.com");
		
	}
}
