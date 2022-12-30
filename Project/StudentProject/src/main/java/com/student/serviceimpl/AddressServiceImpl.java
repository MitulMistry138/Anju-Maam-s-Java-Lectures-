package com.student.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.student.entity.Address;
import com.student.entity.Student;
import com.student.model.AddressDTO;
import com.student.model.StudentDTO;
import com.student.repository.AddressRepository;
import com.student.service.AddressService;
import com.student.util.AddressConverter;

import lombok.experimental.NonFinal;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
 AddressRepository addressRepository;
	
	@Autowired
	AddressConverter addressConverter;
	
	@Override
	public String createAddress(Address address) {
		String message= null;
		addressRepository.save(address);
		if(address!=null)
		{
			message =" New address saved successfully";
		}
		else 
		{
			message = "address not saved"; 
		}
		return message;
	}

	//updating Address
	@Override
	public AddressDTO updateAddress(int addressId, Address address) {
		Address existingAddress=addressRepository.findById(addressId).get();
		existingAddress.setCity(address.getCity());
		existingAddress.setState(address.getState());
		existingAddress.setPincode(address.getPincode());
		
		addressRepository.save(existingAddress);
		
		
		return addressConverter.convertToAddressDTO(existingAddress);
	}

	// using get mapping to fetch data by ID
	@Override
	public AddressDTO getAddressByID(int addressId) {
		
		Address address= addressRepository.findById(addressId).get();
				
		return addressConverter.convertToAddressDTO(address);
	}

	//Deleting by id 
	
	@Override
	public String deleteAddressById(int addressId) {
		
		//giving message = null.
		String message = null;
		
		//using optional for boolean to check the id is present or not 
		Optional<Address> deleteAddressId = addressRepository.findById(addressId);
		
		//checking the id if presen or not and deleting it  
		
		if(deleteAddressId.isPresent())
		{
			addressRepository.deleteById(addressId); 
			message="Id DEleted successfully";
		}
		else 
		{
			message="address not fpunf";
		}
		
		return message;
		
	}

	@Override
	public List<AddressDTO> getAllAddress() {
	List<Address> address= addressRepository.findAll(); 
	
	List<AddressDTO> addressDTO=new ArrayList<>();
		for(Address ar: address)
		{
			addressDTO.add(addressConverter.convertToAddressDTO(ar));
		}
		
		return addressDTO;
	}

	@Override
	public void deleteAllDataOfAddress() {
		
		addressRepository.deleteAll();
		
	}
		
	
	
	
}
