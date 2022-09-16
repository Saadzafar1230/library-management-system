package com.example.librarymanagementsystem.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Objects;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;

import com.example.librarymanagementsystem.dto.LmsDto;
import com.example.librarymanagementsystem.service.LmsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class LmsControllerTest {
	
	LmsController lmsController;
	@Mock
	private LmsService lmsService;
	@Mock
	BindingResult bindingResult;
	MockMvc mockMvc;
	
	
	@BeforeEach
	void setUp() {
		lmsController = new LmsController(lmsService);
		mockMvc = MockMvcBuilders.standaloneSetup(lmsController).build();
	}
	private final ObjectMapper mapper = new ObjectMapper();

	@Test
	void testCreateNewBook() throws NoSuchMethodException
	{
		//given
		LmsDto lmsDto = getLmsDto("1234567891234");
		given(lmsService.createNewBook(any(LmsDto.class))).willReturn(lmsDto);
		
		// when
		ResponseEntity<Object> lms = lmsController.createNewBook(lmsDto, bindingResult);
		System.out.println(lms);
		
		//then
		assertNotNull(lms.getBody());
		
		assertEquals(HttpStatus.CREATED, lms.getStatusCode());
		assertEquals(lmsDto.getClass().getDeclaredMethod("getIsbn"), Objects.requireNonNull(lms.getBody()).getClass().getDeclaredMethod("getIsbn"));
		then(lmsService).should().createNewBook(any(LmsDto.class));
		then(lmsService).shouldHaveNoMoreInteractions();
	}
	
	@Test
	void testCreateNewBook400() throws Exception
	{
		//given
		LmsDto lmsDto = new LmsDto();
		lmsDto.setId(1L);
		lmsDto.setBookName("Data structures");
		lmsDto.setIsbn("");
		
		//when
		mockMvc.perform(post("/api/new/book").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(lmsDto)))
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.isbn", Is.is("ISBN Number is required")));
		
	}
	
	
	private LmsDto getLmsDto(String iSbn) 
	{
		
		LmsDto lmsDto = new LmsDto();
		lmsDto.setId(1L);
		lmsDto.setBookName("Data structures");
		lmsDto.setIsbn(iSbn);
		return lmsDto;
	}

}
