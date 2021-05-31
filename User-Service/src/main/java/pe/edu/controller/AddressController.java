package pe.edu.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.domain.model.Address;
import pe.edu.domain.service.AddressService;
import pe.edu.resource.AddressResource;
import pe.edu.resource.SaveAddressResource;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@Tag(name="Address",description = "Users API")
@RestController
@RequestMapping("/api")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/users/{userId}/address")
    public Page<AddressResource> getAllAddressByUserId(
            @PathVariable(value = "userId") Long userId,
            Pageable pageable) {
        Page<Address> addressPage = addressService.getAllModelsByModel2Id(userId,pageable);
        List<AddressResource> resources = addressPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/users/{userId}/address/{addressId}")
    public AddressResource getAddressByIdAndUserId(
            @PathVariable(name = "userId") Long userId,
            @PathVariable(name = "addressId") Long addressId) {
        return convertToResource(addressService.getModelByIdAndModel2Id(userId, addressId));
    }

    @PostMapping("/users/{userId}/address")
    public AddressResource createAddress(
            @PathVariable(value = "userId") Long userId,
            @Valid @RequestBody SaveAddressResource resource) {
        return convertToResource(addressService.create(userId,
                convertToEntity(resource)));
    }

    @PutMapping("/users/{userId}/address/{addressId}")
    public AddressResource updateAddress(
            @PathVariable (value = "userId") Long userId,
            @PathVariable (value = "addressId") Long addressId,
            @Valid @RequestBody SaveAddressResource resource) {
        return convertToResource(addressService.update(userId, addressId,
                convertToEntity(resource)));
    }

    @DeleteMapping("/users/{userId}/address/{addressId}")
    public ResponseEntity<?> deleteAddress(
            @PathVariable (value = "userId") Long userId,
            @PathVariable (value = "addressId") Long addressId) {
        return addressService.delete(userId, addressId);
    }

    private Address convertToEntity(SaveAddressResource resource)  { return mapper.map(resource, Address.class); }

    private AddressResource convertToResource(Address entity) {
        return mapper.map(entity, AddressResource.class);
    }
}
