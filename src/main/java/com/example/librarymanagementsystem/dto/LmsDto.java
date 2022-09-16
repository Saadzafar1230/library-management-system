package com.example.librarymanagementsystem.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LmsDto 
{
	@Id
	@GeneratedValue
	private Long id;
	@NotBlank(message = "Book Name is required")
	private String bookName;
	@NotBlank(message = "ISBN Number is required")
	private String isbn;
}
