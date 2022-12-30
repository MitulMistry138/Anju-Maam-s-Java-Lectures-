package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Address;
import com.student.model.AddressDTO;
import com.student.service.AddressService;
import com.student.util.AddressConverter;

@RestController
@RequestMapping("/api")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private  AddressConverter addressConverter;
	
	@PostMapping("/newAddress")
	public String createAddress(@RequestBody AddressDTO addressDTO)
	{
		final Address address= addressConverter.convertToAddressEntity(addressDTO);
		return addressService.createAddress(address);
	}
	// for updation use put mapping and requestbody from DTO class
	@PutMapping("/updateAddress/{id}")
	public AddressDTO updateAddress(@PathVariable("id") int addressId, @RequestBody AddressDTO addressDTO)
	{
		// create a object for Address class and convert it to entity
		Address address13 = addressConverter.convertToAddressEntity(addressDTO);
		
		// returning  from using service class and callinng updateAddress
		return addressService.updateAddress(addressId, address13);
		
	}
	// finding address by id
	@GetMapping("/getAddress/{id}")
	public AddressDTO getAddressById(@PathVariable("id") int addressId)
	{
		return addressService.getAddressByID(addressId);
	}
	
	// deleting address by id
	@DeleteMapping("/deleteAddress/{id}")
	public String deleteAddressById(@PathVariable("id") int addressId)
	{
		return addressService.deleteAddressById(addressId);
	}
	
	//geting all address
	@GetMapping("/getAllAddress")
	public List<AddressDTO>getAllAddress()
	{
		return addressService.getAllAddress();
	}
	
	@DeleteMapping("/deleteAllAddress")
	public void deleteAllAddress()
	{
		addressService.deleteAllDataOfAddress();
	}
}
