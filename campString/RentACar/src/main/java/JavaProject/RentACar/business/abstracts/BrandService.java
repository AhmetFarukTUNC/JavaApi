package JavaProject.RentACar.business.abstracts;

import java.util.List;

import JavaProject.RentACar.business.requests.CreateBrandRequest;
import JavaProject.RentACar.business.requests.UpdateBrandRequest;
import JavaProject.RentACar.business.responses.GetAllBrandsResponse;
import JavaProject.RentACar.business.responses.GetByIdBrandResponse;

public interface BrandService {

	List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse getById(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
	
}
