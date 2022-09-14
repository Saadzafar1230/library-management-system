package com.example.librarymanagementsystem.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarymanagementsystem.dto.LmsDto;
import com.example.librarymanagementsystem.service.LmsService;

@RestController
@RequestMapping("/api/")
public class LmsController 
{
	private final LmsService lmsServiceRef;
	
	public LmsController(LmsService lmsservice) 
	{
		
		this.lmsServiceRef = lmsservice;
	}
	@PostMapping(value = "/new/book", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createNewBook(@Valid @RequestBody LmsDto lmsDto, BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) {
			Map<String, String> errorsMap = new HashMap<>();
			bindingResult.getFieldErrors()
					.forEach(fieldError -> errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage()));
			return new ResponseEntity<>(errorsMap, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(lmsServiceRef.createNewBook(lmsDto), HttpStatus.CREATED);
	}

}
