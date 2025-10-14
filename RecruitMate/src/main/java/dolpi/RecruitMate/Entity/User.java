package dolpi.RecruitMate.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "users")
@Data
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private String usertype; //admin ya applicant
    private String profileHeadline;
    private String address;




}
