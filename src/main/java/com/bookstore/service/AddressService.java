package com.bookstore.service;

import com.bookstore.model.Address;
import com.bookstore.repository.AddressRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class AddressService {

    private final AddressRepository addressRepository;

    public void save(Address address) {
        addressRepository.save(address);
    }
}
