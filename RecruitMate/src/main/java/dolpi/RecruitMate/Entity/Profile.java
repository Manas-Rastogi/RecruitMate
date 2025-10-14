package dolpi.RecruitMate.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profiles")
@Data
public class Profile {
    @Id
    private String id;
    private String resumeFilePath;
    private String skills;
    private String education;
    private String experience;
    private String phone;
    private String jobId; // referenc user

}
