package dolpi.RecruitMate.Sevice;

import dolpi.RecruitMate.Entity.Jobs;
import dolpi.RecruitMate.Entity.User;
import dolpi.RecruitMate.Repository.Userrepository;
import dolpi.RecruitMate.Repository.job;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JobService {
    @Autowired
    private job jobRepository;

    @Autowired
    private Userrepository userRepository;

    public Jobs createJob(Jobs job, String adminId) {
        job.setPostedBy(adminId);
        job.setPostedOn(LocalDateTime.now());
        job.setTotalApplications(0);
        job.setApplicantIds(new ArrayList<>());
        return jobRepository.save(job);
    }

    public Jobs getJob(String jobId) {
        return jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }

    public List<User> getAllApplicants() {
        return userRepository.findAll().stream()
                .filter(u -> u.getUsertype().equalsIgnoreCase("Applicant"))
                .collect(Collectors.toList());
}



}
