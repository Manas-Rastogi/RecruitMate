package dolpi.RecruitMate.Sevice;

import dolpi.RecruitMate.Entity.Profile;
import dolpi.RecruitMate.Repository.profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ResumeParserService {
    @Autowired
    private profile profileRepository;

    public void parseAndSave(MultipartFile file, String userId) {
        // Call third-party resume parser API
        // Parse JSON -> extract skills, education, experience, phone
        // Save to Profile
        Profile profile =  profileRepository.findByJobId(userId);
        if (profile == null) profile = new Profile();

        profile.getJobId();
        profile.setResumeFilePath("/uploads/" + file.getOriginalFilename());
        profile.setSkills("Extracted skills here");
        profile.setEducation("Extracted education here");
        profile.setExperience("Extracted experience here");
        profile.setPhone("Extracted phone here");

        profileRepository.save(profile);
    }
}
