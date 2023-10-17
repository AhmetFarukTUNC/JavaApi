package JavaProject.RentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.RentACar.business.abstracts.ModelService;
//import JavaProject.RentACar.business.requests.CreateBrandRequest;
import JavaProject.RentACar.business.requests.CreateModelRequest;
import JavaProject.RentACar.business.responses.GetAllModelsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
@RestController   
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;
    @GetMapping("getAll")
    public List<GetAllModelsResponse> getAll(){
    	return modelService.getAll();
    }
    
    @PostMapping("add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid  CreateModelRequest createModelRequest){
		
		this.modelService.add(createModelRequest);
		
	}
}
