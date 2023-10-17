package JavaProject.RentACar.dataAccess.abstracts;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.stereotype.Repository;

import JavaProject.RentACar.entities.concretes.Brand;



public interface BrandRepository extends JpaRepository<Brand, Integer>{
   
   boolean existsByName(String name);
	
}
