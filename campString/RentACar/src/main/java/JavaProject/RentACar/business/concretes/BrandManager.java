package JavaProject.RentACar.business.concretes;

//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import JavaProject.RentACar.business.abstracts.BrandService;
import JavaProject.RentACar.business.requests.CreateBrandRequest;
import JavaProject.RentACar.business.requests.UpdateBrandRequest;
import JavaProject.RentACar.business.responses.GetAllBrandsResponse;
import JavaProject.RentACar.business.responses.GetByIdBrandResponse;
import JavaProject.RentACar.core.utilities.mappers.ModelMapperService;
import JavaProject.RentACar.dataAccess.abstracts.BrandRepository;
import JavaProject.RentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import rules.BrandBusinessRules;
@Service
@AllArgsConstructor
public class BrandManager implements BrandService{
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;
	
	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		//brands ... with loop and every brand object maps to getAllBrandsEwsponse class.
		
		List<Brand> brands=brandRepository.findAll();
		
		//List<GetAllBrandsResponse> brandsResponse =new ArrayList<GetAllBrandsResponse>();
		
		List<GetAllBrandsResponse> brandsResponse =brands.stream()
				.map(brand->this.modelMapperService.forResponse()
						.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		return  brandsResponse;
	}
	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		//createBrandRequest is mapping to brand class. 
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
		this.brandRepository.save(brand);
		
	}
	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse response = modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return response;
	}
	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
		brandRepository.save(brand);
		
	}
	@Override
	public void delete(int id) {
		brandRepository.deleteById(id);
		
	}
	
	

}
