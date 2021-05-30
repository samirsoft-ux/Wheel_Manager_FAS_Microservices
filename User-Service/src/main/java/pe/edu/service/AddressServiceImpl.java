package pe.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.domain.model.Address;
import pe.edu.domain.repository.AddressRepository;
import pe.edu.domain.repository.UserRepository;
import pe.edu.domain.service.AddressService;
import pe.edu.exception.ResourceNotFoundException;

import java.util.Optional;

@Service
public class AddressServiceImpl  implements AddressService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Transactional(readOnly = true)
    @Override
    public Page<Address> getAllModelsByModel2Id(Long userId, Pageable pageable) throws Exception {
        return addressRepository.findByUserId(userId,pageable);
    }

    @Override
    public Address getModelByIdAndModel2Id(Long userId, Long addressId) throws Exception {
        return addressRepository.findByIdAndUserId(addressId, userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Address not found with Id " + addressId+
                                " and User " + userId));
    }

    @Override
    public Address create(Long userId, Address address) throws Exception {
        return userRepository.findById(userId).map(user->{
           address.setUser(user);
            return addressRepository.save(address);
        }).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
    }

    @Override
    public Address update(Long userId, Long addressId, Address details) throws Exception {
        if(!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User", "Id", userId);

        return addressRepository.findById(addressId).map(address -> {
            address.setLatitude(details.getLatitude());
            address.setLongitude(details.getLongitude());
            address.setDescription(details.getDescription());

            return addressRepository.save(address);
        }).orElseThrow(() -> new ResourceNotFoundException("Address", "Id", addressId));

    }

    @Override
    public ResponseEntity<?> delete(Long userId, Long addressId) throws Exception {
        return addressRepository.findByIdAndUserId(addressId, userId).map(address -> {
            addressRepository.delete(address);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Address not found with Id " + addressId + " and ClientId" + userId));
    }
}
