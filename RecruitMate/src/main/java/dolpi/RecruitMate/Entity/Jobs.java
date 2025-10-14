package dolpi.RecruitMate.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "jobs")
@Data
public class Jobs {
    @Id
    private String id;
    private String title;
    private String description;
    private String companyName;
    private LocalDateTime postedOn;
    private Integer totalApplications = 0;
    private String postedBy; // Admin userId
    private List<String> applicantIds; // List of applicant ids

}
