package draze.delivery.service;

import draze.delivery.domain.model.Address;

public interface AddressService {

    Address findById(Long id);

    Address create(Address addressToCreate);
}
