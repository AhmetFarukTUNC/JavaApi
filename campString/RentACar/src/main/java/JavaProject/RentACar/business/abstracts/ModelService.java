package JavaProject.RentACar.business.abstracts;

import java.util.List;

//import JavaProject.RentACar.business.requests.CreateBrandRequest;
import JavaProject.RentACar.business.requests.CreateModelRequest;
import JavaProject.RentACar.business.responses.GetAllModelsResponse;

public interface ModelService {
   List<GetAllModelsResponse> getAll(); 
   void add(CreateModelRequest createModelRequest);
}
