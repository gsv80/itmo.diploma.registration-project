package com.itmo.projects_registration.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Equipment {

	public Equipment() {}

	public Equipment(String equipmentType) {
		super();
		this.equipmentType = equipmentType;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long equipmentId;
	
	private String equipmentType;

	public Long getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
}
