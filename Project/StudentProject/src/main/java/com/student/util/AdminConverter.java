package com.student.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.student.entity.Admin;
import com.student.model.AdminDTO;

@Component
public class AdminConverter {

	// convert AddressDto to Entity
	public Admin convertAdminEntity(AdminDTO adminDto) {
		Admin admin = new Admin();
		if (adminDto != null) {
			BeanUtils.copyProperties(adminDto, admin);
		}
		return admin;
	}

	// convert Adrees entity to AddressDto
	public AdminDTO convertToAdminDto(Admin admin) {
		AdminDTO adminDto = new AdminDTO();
		if (admin != null) {
			BeanUtils.copyProperties(admin, adminDto);
		}
		return adminDto;
	}
}
