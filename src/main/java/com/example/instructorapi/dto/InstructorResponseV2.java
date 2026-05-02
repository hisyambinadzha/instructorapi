package com.example.instructorapi.dto;

public class InstructorResponseV2 {
    String id;
    String fullName;
    String primarySkill;
    String availabilityStatus;
    String experienceLevel;
    String profileSummary;

    public InstructorResponseV2() {}

    public InstructorResponseV2(String id, String fullName, String primarySkill, String availabilityStatus, String experienceLevel, String profileSummary) {
        this.id = id;
        this.fullName = fullName;
        this.primarySkill = primarySkill;
        this.availabilityStatus = availabilityStatus;
        this.experienceLevel = experienceLevel;
        this.profileSummary = profileSummary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public String getProfileSummary() {
        return profileSummary;
    }

    public void setProfileSummary(String profileSummary) {
        this.profileSummary = profileSummary;
    }

}
