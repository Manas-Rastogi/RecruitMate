package dolpi.RecruitMate.Repository;

import dolpi.RecruitMate.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface Userrepository extends MongoRepository<User,String> {

        User findByUsername(String username);

        boolean existsByEmail(String email);

    }


