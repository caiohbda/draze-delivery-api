package draze.delivery.service.impl;

import draze.delivery.domain.model.Address;
import draze.delivery.domain.repository.AddressRepository;
import draze.delivery.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Address create(Address addressToCreate) {
        return addressRepository.save(addressToCreate);
    }
}
