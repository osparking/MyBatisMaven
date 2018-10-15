package com.learning.spring.db.mybatis;

import java.util.List;

import com.learning.spring.db.PetDVO;

public interface PetDAO {
	List<PetDVO> getAllPetsData();
}
