package com.example.librarymanagementsystem.service;

import org.springframework.stereotype.Service;

import com.example.librarymanagementsystem.dao.LmsDao;
import com.example.librarymanagementsystem.dto.LmsDto;
import com.example.librarymanagementsystem.entity.LmsEntity;
import com.example.librarymanagementsystem.mapper.LmsMapper;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class LmsServiceImpl implements LmsService
{
	private final LmsDao lmsDao;
	private static final LmsMapper lmsMapper = LmsMapper.INSTANCE;
	
	@Override
	public LmsDto createNewBook(LmsDto lmsdt) 
	{
		
		LmsEntity dtEnt = lmsMapper.lmsDtotolmsEnt(lmsdt);
			
		LmsEntity savedEnt = lmsDao.save(dtEnt);
        return  lmsMapper.lmsEnttolmsDto(savedEnt);
 

	}
}
