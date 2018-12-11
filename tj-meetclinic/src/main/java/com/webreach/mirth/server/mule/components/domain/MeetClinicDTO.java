//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.webreach.mirth.server.mule.components.domain;

public class MeetClinicDTO {
    private String meetClinicId;
    private String organName;
    private String doctorName;
    private String departName;
    private String patientName;
    private String startTime;
    private String endTime;
    private String diagianName;

    public MeetClinicDTO(String meetClinicId, String organName, String doctorName, String departName, String patientName, String startTime, String endTime, String diagianName) {
        this.meetClinicId = meetClinicId;
        this.organName = organName;
        this.doctorName = doctorName;
        this.departName = departName;
        this.patientName = patientName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.diagianName = diagianName;
    }

    public String getDiagianName() {
        return this.diagianName;
    }

    public void setDiagianName(String diagianName) {
        this.diagianName = diagianName;
    }

    public String getMeetClinicId() {
        return this.meetClinicId;
    }

    public void setMeetClinicId(String meetClinicId) {
        this.meetClinicId = meetClinicId;
    }

    public String getOrganName() {
        return this.organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getDoctorName() {
        return this.doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDepartName() {
        return this.departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getPatientName() {
        return this.patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
