package rules;

import org.springframework.stereotype.Service;

import JavaProject.RentACar.core.utilities.exceptions.BusinessException;
import JavaProject.RentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class BrandBusinessRules {
	private BrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {

		if (this.brandRepository.existsByName(name)) {
			
			throw new BusinessException("Brand already exists");
			
		}
		
	}
	

}
