package pe.edu.upc.producto_service.services.impls;

import pe.edu.upc.producto_service.entities.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface BrandServiceImpl {

    Page<Brand> getAllBrands(Pageable pageable);
    Brand getBrandById(Long brandId);
    Brand createBrand(Brand brand);
    Brand updateBrand(Long brandId, Brand messageRequest);
    ResponseEntity<?> deleteBrand(Long brandId);
}
