package com.learning.spring.db;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@SuppressWarnings("serial")
public class PetDVO implements Serializable {
	private int id;
	private String name;
	private String owner;
	private String species;
	private String sex;
	private LocalDate birth;
	private LocalDate death;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public LocalDate getDeath() {
		return death;
	}

	public void setDeath(LocalDate death) {
		this.death = death;
	}

	@Override
	public String toString() {
		return "애완동물 [이름=" + name + ", 소유자=" + owner + ", 종류=" + species + ", 암수=" + sex + ", 출생=" + birth + ", 사망="
				+ death + "]";
	}

}
