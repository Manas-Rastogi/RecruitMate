package dolpi.RecruitMate.Repository;

import dolpi.RecruitMate.Entity.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface profile extends MongoRepository<Profile,String> {

    List<Profile> findByUserId(String jobId);

    Profile findByJobId(String jobId);



}
