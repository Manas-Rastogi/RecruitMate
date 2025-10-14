package dolpi.RecruitMate.UserController;

import dolpi.RecruitMate.Entity.Jobs;
import dolpi.RecruitMate.Entity.User;
import dolpi.RecruitMate.Repository.profile;
import dolpi.RecruitMate.Sevice.JobService;
import dolpi.RecruitMate.Sevice.ResumeParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
    @Autowired
    private JobService jobService;

    @Autowired
    private ResumeParserService resumeParserService;

    @Autowired
    private profile profileRepository;

    @GetMapping("/jobs")
    public List<User> getJobs() {
        return jobService.getAllApplicants();
    }

    @GetMapping("/apply")
    public ResponseEntity<String> applyJob(@RequestParam Jobs job, @RequestHeader("userId") String userId) {
        jobService.createJob(job, userId);
        return ResponseEntity.ok("Applied successfully");
    }

    @PostMapping("/uploadResume")
    public ResponseEntity<String> uploadResume(@RequestParam MultipartFile file, @RequestHeader("userId") String userId) {
        resumeParserService.parseAndSave(file, userId);
        return ResponseEntity.ok("Resume uploaded and parsed successfully");
    }
}
