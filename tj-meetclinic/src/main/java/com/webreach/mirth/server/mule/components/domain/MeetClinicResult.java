//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.webreach.mirth.server.mule.components.domain;

public class MeetClinicResult {
    public String id;
    public String exeOrgCode;
    public String exeDepartCode;
    public String exeDepartName;
    public String exeDoctorCode;
    public String exeDoctorName;
    public String meetReport;
    public String mId;

    public MeetClinicResult(String id, String exeOrgCode, String exeDepartCode, String exeDepartName, String exeDoctorCode, String exeDoctorName, String meetReport, String mId) {
        this.id = id;
        this.exeOrgCode = exeOrgCode;
        this.exeDepartCode = exeDepartCode;
        this.exeDepartName = exeDepartName;
        this.exeDoctorCode = exeDoctorCode;
        this.exeDoctorName = exeDoctorName;
        this.meetReport = meetReport;
        this.mId = mId;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExeOrgCode() {
        return this.exeOrgCode;
    }

    public void setExeOrgCode(String exeOrgCode) {
        this.exeOrgCode = exeOrgCode;
    }

    public String getExeDepartCode() {
        return this.exeDepartCode;
    }

    public void setExeDepartCode(String exeDepartCode) {
        this.exeDepartCode = exeDepartCode;
    }

    public String getExeDepartName() {
        return this.exeDepartName;
    }

    public void setExeDepartName(String exeDepartName) {
        this.exeDepartName = exeDepartName;
    }

    public String getExeDoctorCode() {
        return this.exeDoctorCode;
    }

    public void setExeDoctorCode(String exeDoctorCode) {
        this.exeDoctorCode = exeDoctorCode;
    }

    public String getExeDoctorName() {
        return this.exeDoctorName;
    }

    public void setExeDoctorName(String exeDoctorName) {
        this.exeDoctorName = exeDoctorName;
    }

    public String getMeetReport() {
        return this.meetReport;
    }

    public void setMeetReport(String meetReport) {
        this.meetReport = meetReport;
    }

    public String getmId() {
        return this.mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }
}
