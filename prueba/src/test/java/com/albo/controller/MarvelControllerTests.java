package com.albo.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MarvelController.class)

public class MarvelControllerTests {
	
	@Autowired
	private MockMvc mvc;
	
	
	//@Test
	void getColaboratorsByCharacterNameTests() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/marvel/colaborators/cap");
		MvcResult result =  mvc.perform(request).andReturn();
		//assertEquals("", result.getResponse().getContentAsString());
	}
	

}
