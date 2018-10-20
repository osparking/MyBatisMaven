package com.learning.db.mybatis.java;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.learning.spring.db.PetDVO;

public interface PetMapper {
	@Select(value="{CALL read_all_pets()}")
	@Options(statementType = StatementType.CALLABLE)
	public List<PetDVO> callReadAllPets();
}
