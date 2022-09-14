package com.example.librarymanagementsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.librarymanagementsystem.entity.*;
import com.example.librarymanagementsystem.dto.*;


@Mapper
public interface LmsMapper 
{
	LmsMapper INSTANCE = Mappers.getMapper(LmsMapper.class);
	
	LmsDto lmsEnttolmsDto(LmsEntity lmsEntity);
	LmsEntity lmsDtotolmsEnt(LmsDto lmsDto);
}
