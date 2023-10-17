package JavaProject.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import JavaProject.RentACar.business.abstracts.ModelService;
import JavaProject.RentACar.business.requests.CreateModelRequest;
import JavaProject.RentACar.business.responses.GetAllModelsResponse;
import JavaProject.RentACar.core.utilities.mappers.ModelMapperService;
import JavaProject.RentACar.dataAccess.abstracts.ModelRepository;
import JavaProject.RentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ModelManager implements ModelService{
private ModelRepository modelRepository;
private ModelMapperService modelMapperService;
	@Override
	public List<GetAllModelsResponse> getAll() {
		//brands ... with loop and every brand object maps to getAllBrandsEwsponse class.
		
				List<Model> models=modelRepository.findAll();
				
				//List<GetAllBrandsResponse> brandsResponse =new ArrayList<GetAllBrandsResponse>();
				
				List<GetAllModelsResponse> modelsResponse =models.stream()
						.map(model->this.modelMapperService.forResponse()
								.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
				
				return  modelsResponse;
	}
	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);
		this.modelRepository.save(model);
		
	}

}
