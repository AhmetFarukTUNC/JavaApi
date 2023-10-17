package JavaProject.RentACar;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import JavaProject.RentACar.core.utilities.exceptions.BusinessException;
import JavaProject.RentACar.core.utilities.exceptions.ProblemDetails;
import JavaProject.RentACar.core.utilities.exceptions.ValidationProblemDetails;
import JavaProject.RentACar.dataAccess.abstracts.BrandRepository;
import rules.BrandBusinessRules;



@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	@Bean
	public BrandBusinessRules getBusinessRules(BrandRepository brandRepository) {
		return new BrandBusinessRules(brandRepository);
	}
	
	@ExceptionHandler
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		
		ProblemDetails problemDetails = new ProblemDetails();
		
		problemDetails.setMessage(businessException.getMessage());
		
		return problemDetails;
		
	}
	
    @ExceptionHandler
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	
	public ProblemDetails handleBusinessException(MethodArgumentNotValidException methodArgumentNotValidException) {
		
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		
		validationProblemDetails.setMessage("VALIDATION.EXCEPTİON");
		
		validationProblemDetails.setValidationErrors(new HashMap<String,String>());
		 
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return validationProblemDetails;
		
	}
	
	
	
	

}
