package com.learning.spring.db.mybatis;

import java.util.List;

import com.learning.spring.db.PetDVO;

/**
 * 파일 이름: PetDAO.java
 * @author Jongbum Park
 *
 */
public interface PetDAO {
	default void callReadPet() {
		System.out.println("기본 callReadPet");
	};
	List<PetDVO> callReadAllPets() throws Exception ;
	default public void callPetOwnerFunction() {
		System.out.println("기본 callPetOwnerFunction");
	};
}
