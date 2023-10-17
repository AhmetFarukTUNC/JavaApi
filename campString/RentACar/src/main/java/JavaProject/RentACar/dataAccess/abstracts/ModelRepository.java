package JavaProject.RentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaProject.RentACar.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{

}
