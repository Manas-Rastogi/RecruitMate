# RecruitMate – Recruitment Management System Backend
--------
*RecruitMate* is a backend server for a Recruitment Management System that streamlines the hiring process by connecting applicants with job openings efficiently. It provides APIs for user authentication, profile management, resume processing, job postings, and applications. Admins can manage job openings and view applicant data, while applicants can upload resumes, view job listings, and apply for jobs.

---------------------------------------------------
------
## *Key Features*

- *User Management:* Applicants and Admins can sign up and log in using JWT-based authentication.
- *Resume Upload & Parsing:* Applicants can upload resumes in PDF or DOCX format. Resumes are processed using a third-party API to extract skills, education, experience, and contact details.
- *Job Management:* Admins can create job openings and view applicant details.
- *Job Application:* Applicants can view available jobs and apply for specific positions.
- *Secure Access:* Role-based access control ensures that only authorized users can perform certain actions.

---------------------------------------------------

## *APIs*

| Method | Endpoint | Description | Access |
|--------|----------|------------|--------|
| POST   | /signup | Create a new user profile | All users |
| POST   | /login | Authenticate and generate JWT token | All users |
| POST   | /uploadResume | Upload and parse resume | Applicant only |
| POST   | /admin/job | Create job openings | Admin only |
| GET    | /admin/job/{job_id} | Fetch job details and applicants | Admin only |
| GET    | /admin/applicants | Get list of all users | Admin only |
| GET    | /admin/applicant/{applicant_id} | Get extracted applicant data | Admin only |
| GET    | /jobs | List all job openings | All users |
| GET    | /jobs/apply?job_id={job_id} | Apply to a job | Applicant only |

---------------------------------------------------

## *Data Models*

*User*  
- Name, Email, Address  
- UserType (Applicant/Admin)  
- PasswordHash  
- Profile Headline  
- Profile (linked to Applicant details)

*Profile (Applicant)*  
- Resume File Address  
- Skills  
- Education  
- Experience  
- Contact Information

*Job*  
- Title, Description  
- PostedOn  
- TotalApplications  
- Company Name  
- PostedBy (Admin)

---------------------------------------------------

## *Third-party Resume Parsing API*

- *Endpoint:* https://api.apilayer.com/resume_parser/upload  
- *Request Type:* POST  
- *Headers:*  
  - Content-Type: application/octet-stream  
  - apikey: YOUR_API_KEY_HERE  
- *Description:* Upload PDF/DOCX resumes, receive extracted JSON data containing education, experience, skills, and contact information.

---------------------------------------------------

Technologies Used

- Backend: Java (Spring Boot)  
- Database: MySQL / MongoDB  
- Authentication: JWT (JSON Web Tokens)  
- File Handling:  Resume upload and storage  
- Third-party Integration: Resume parsing API  

---------------------------------------------------
-----
Getting Started

1. Clone the repository:
bash
git clone https://github.com/Avenger-manas/RecruitMate.git
