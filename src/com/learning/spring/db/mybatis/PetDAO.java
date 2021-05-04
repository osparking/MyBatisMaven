package com.learning.spring.db.mybatis;

import java.util.List;

import com.learning.spring.db.PetDVO;

public interface PetDAO {
	List<PetDVO> getAllPets();
	PetDVO getPetObject(String petName) throws Exception;
	List<String> getAllSpecies();
	List<PetDVO> selectByGender(String sex) throws Exception;
	int insertPet(PetDVO petDVO) throws Exception;
	void updatePetData(PetDVO petDVO) throws Exception;
	int deletePet(String species, String name) throws Exception;
	public List<PetDVO> findSomePets();
	public List<PetDVO> findSnakePets();
	public List<PetDVO> selectPetsIn();
	public void updatePetDynamically(PetDVO petDVO);
}
