package com.example.librarymanagementsystem;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.librarymanagementsystem.controller.LmsController;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class LibraryManagementSystemApplicationTestIT {

	@Autowired
	LmsController lmsController;
	@Test
	void contextLoads() {
		assertNotNull(lmsController);
	}

}
