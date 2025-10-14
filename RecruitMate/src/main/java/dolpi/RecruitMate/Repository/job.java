package dolpi.RecruitMate.Repository;

import dolpi.RecruitMate.Entity.Jobs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface job extends MongoRepository<Jobs,String> {
    //List<Jobs> findByTitleContainingIgnoreCase(String title);



}
