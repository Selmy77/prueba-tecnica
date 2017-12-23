package com.asdtest.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

import com.asd.controller.ActiveController;
import com.asd.model.Active;
import com.asd.repository.ActiveRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ActiveController.class, secure = false)
public class ActiveControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ActiveRepository partyRepo;
	
	private Active active;
	
	@Before
	public void prepare() {
		active = new Active();
		active.setId(1l);
		active.setName("Garden");
		active.setDescripcion("Garden");
		active.setTipo("Inmueble");
		active.setSerial(2);
		active.setNumero_interno("222");
		active.setPeso("125");
		active.setAlto("12");
		active.setAncho("89");
		active.setLargo("15");
		active.setValor_compra("125000");
		active.setEstado("Activo");
		active.setColor("Azul");
	}

	@Test
	public void getActiveTest() throws Exception {
		given(partyRepo.findOne(1l)).willReturn(active);
		mvc.perform(get("/actives/1").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.Name", is("Garden")))
				.andExpect(jsonPath("$.Descripcion", is("Garden")))
				.andExpect(jsonPath("$.Tipo", is("Inmueble")))
				.andExpect(jsonPath("$.Serial", is(2)))
				.andExpect(jsonPath("$.Numero_interno", is("222")))
				.andExpect(jsonPath("$.Peso", is("125")))
				.andExpect(jsonPath("$.Alto", is("12")))
				.andExpect(jsonPath("$.Ancho", is("89")))
				.andExpect(jsonPath("$.Largo", is("15")))
				.andExpect(jsonPath("$.Valor_compra", is("125000")))
				.andExpect(jsonPath("$.Estado", is("Activo")))
				.andExpect(jsonPath("$.Color", is("Azul")));
	}
	
	@Test
	public void partyNotFoundTest() throws Exception {
		mvc.perform(get("/actives/2").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isNotFound());
	}
	
	@Test
	public void getPartiesTest() throws Exception {
		List<Active> Actives = new ArrayList<Active>();
		Actives.add(active);
		
		given(partyRepo.findAll()).willReturn(Actives);
		mvc.perform(get("/parties").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].location", is("Garden")));
	}

}
