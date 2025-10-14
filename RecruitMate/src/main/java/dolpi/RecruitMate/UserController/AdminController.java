package dolpi.RecruitMate.UserController;

import dolpi.RecruitMate.Entity.Jobs;
import dolpi.RecruitMate.Entity.Profile;
import dolpi.RecruitMate.Entity.User;
import dolpi.RecruitMate.Repository.profile;
import dolpi.RecruitMate.Sevice.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private JobService jobService;

    @Autowired
    private profile profileRepository;

    @PostMapping("/job")
    public ResponseEntity<?> createJob(@RequestBody Jobs job, @RequestHeader("userId") String adminId) {
        return new ResponseEntity(jobService.createJob(job, adminId),HttpStatus.OK);
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<?> getJob(@PathVariable String jobId) {
        return new ResponseEntity(jobService.getJob(jobId),HttpStatus.OK);
    }

    @GetMapping("/applicants")
    public ResponseEntity<List<User>> getAllApplicants() {
        return new ResponseEntity(jobService.getAllApplicants(), HttpStatus.OK);
    }

    @GetMapping("/applicant/{applicantId}")
    public ResponseEntity<Profile> getApplicantProfile(@PathVariable String applicantId) {
        return new ResponseEntity(profileRepository.findByUserId(applicantId), HttpStatus.OK);
}

}
