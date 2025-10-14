package dolpi.RecruitMate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableMongoRepositories(basePackages = "dolpi.RecruitMate.Repository")
public class RecruitMateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitMateApplication.class, args);
	}

    @Bean
    public PlatformTransactionManager add(MongoDatabaseFactory dbFactory){
        return new MongoTransactionManager(dbFactory);
    }

}
