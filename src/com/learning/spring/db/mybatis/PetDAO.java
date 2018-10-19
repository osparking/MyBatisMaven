package com.learning.spring.db.mybatis;

import java.util.List;

import com.learning.spring.db.PetDVO;

/**
 * 파일 이름: PetDAO.java
 * @author Jongbum Park
 *
 */
public interface PetDAO {
	void callReadPet();
	List<PetDVO> callReadAllPets();
}
