package SpringBoot.SpringBoot.DB;

import SpringBoot.SpringBoot.model.PeopleModel;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<PeopleModel, Integer> {
}
