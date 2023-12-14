package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.Api.ApiException;
import com.example.schoolmanagement.DTO.AddressDTO;
import com.example.schoolmanagement.Model.Address;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.AddressRepository;
import com.example.schoolmanagement.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

        private final AddressRepository addressRepository;
        private final TeacherRepository teacherRepository;
        public List<Address> getAllAddresses(){
            return addressRepository.findAll();
        }


        public void addAddress(AddressDTO addressDTO){
            Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacherid());
            if(teacher == null) throw new ApiException("Teacher not found");

            Address address = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
            addressRepository.save(address);
        }

        public String updateAddress(AddressDTO addressDTO){
            Address address = addressRepository.findAddressById(addressDTO.getTeacherid());
            if(address == null) throw new ApiException("Address not found");
            Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacherid());
            if(teacher == null) throw new ApiException("Teacher not found");
            Address newAddress = new Address(addressDTO.getTeacherid(),addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
            addressRepository.save(newAddress);
            return "Address updated";
        }

        public String deleteAddress(Integer id){
            Teacher teacher = teacherRepository.findTeacherById(id);
            if(teacher == null) throw new ApiException("Teacher not found");
            Address address = teacher.getAddress();
            if(address == null) throw  new ApiException("Address not found");
            else{
                teacher.setAddress(null);
                teacherRepository.save(teacher);
                addressRepository.delete(address);
                return "Address deleted";
            }
        }




}
