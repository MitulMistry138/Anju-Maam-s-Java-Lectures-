package com.student.service;

import java.util.List;

import com.student.entity.Address;

import com.student.model.AddressDTO;


public interface AddressService {

	String createAddress(Address address);
	
	public AddressDTO updateAddress(int addressId, Address address);
	AddressDTO getAddressByID(int addressId );
	String deleteAddressById(int addressId);
	List<AddressDTO> getAllAddress();
	void deleteAllDataOfAddress(); 
	
	//List<AddressDTO>getAddressByCity(String city);
	
	
}
