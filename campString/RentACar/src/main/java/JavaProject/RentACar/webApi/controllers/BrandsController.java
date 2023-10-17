package JavaProject.RentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.RentACar.business.abstracts.BrandService;
import JavaProject.RentACar.business.requests.CreateBrandRequest;
import JavaProject.RentACar.business.requests.UpdateBrandRequest;
import JavaProject.RentACar.business.responses.GetAllBrandsResponse;
import JavaProject.RentACar.business.responses.GetByIdBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController //This is a anotation.

@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {

	private BrandService brandService;

	
	
	@GetMapping("/getAll")
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id){
		return brandService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequest){
		
		this.brandService.add(createBrandRequest);
		
	}
	//for update response
	
	@PutMapping
	public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		brandService.delete(id);
	}
	
	
}
