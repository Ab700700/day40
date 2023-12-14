package com.example.schoolmanagement.Contorller;

import com.example.schoolmanagement.DTO.AddressDTO;
import com.example.schoolmanagement.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sm/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAllAddressed(){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAllAddresses());
    }
    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Address added");
    }
    @PutMapping("/update")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO addressDTO){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.updateAddress(addressDTO));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.deleteAddress(id));
    }

}
