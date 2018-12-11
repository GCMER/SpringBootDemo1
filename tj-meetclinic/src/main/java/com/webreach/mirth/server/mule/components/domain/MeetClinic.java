//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.webreach.mirth.server.mule.components.domain;

import java.util.List;

public class MeetClinic {
    public String patientIdCard;
    public String patiName;
    public String patiId;
    public String orgCode;
    public String telephone;
    public String id;
    public String type;
    public String requestOrgCode;
    public String requestDepartCode;
    public String requestDepartName;
    public String requestDoctorCode;
    public String diagCode;
    public String diagName;
    public String patiCondition;
    public String leaveMess;
    public List<MeetClinicResult> meetClinicResultList;

    public MeetClinic(String patientIdCard,String patiName, String patiId, String orgCode, String telephone, String id, String type, String requestOrgCode, String requestDepartCode, String requestDepartName, String requestDoctorCode, String diagCode, String diagName, String patiCondition, String leaveMess) {
        this.patientIdCard = patientIdCard;
        this.patiName = patiName;
        this.patiId = patiId;
        this.orgCode = orgCode;
        this.telephone = telephone;
        this.id = id;
        this.type = type;
        this.requestOrgCode = requestOrgCode;
        this.requestDepartCode = requestDepartCode;
        this.requestDepartName = requestDepartName;
        this.requestDoctorCode = requestDoctorCode;
        this.diagCode = diagCode;
        this.diagName = diagName;
        this.patiCondition = patiCondition;
        this.leaveMess = leaveMess;
    }

    public MeetClinic() {
    }

    public String getPatientIdCard() {
        return patientIdCard;
    }

    public void setPatientIdCard(String patientIdCard) {
        this.patientIdCard = patientIdCard;
    }

    public String getPatiName() {
        return this.patiName;
    }

    public void setPatiName(String patiName) {
        this.patiName = patiName;
    }

    public String getPatiId() {
        return this.patiId;
    }

    public void setPatiId(String patiId) {
        this.patiId = patiId;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequestOrgCode() {
        return this.requestOrgCode;
    }

    public void setRequestOrgCode(String requestOrgCode) {
        this.requestOrgCode = requestOrgCode;
    }

    public String getRequestDepartCode() {
        return this.requestDepartCode;
    }

    public void setRequestDepartCode(String requestDepartCode) {
        this.requestDepartCode = requestDepartCode;
    }

    public String getRequestDepartName() {
        return this.requestDepartName;
    }

    public void setRequestDepartName(String requestDepartName) {
        this.requestDepartName = requestDepartName;
    }

    public String getRequestDoctorCode() {
        return this.requestDoctorCode;
    }

    public void setRequestDoctorCode(String requestDoctorCode) {
        this.requestDoctorCode = requestDoctorCode;
    }

    public String getDiagCode() {
        return this.diagCode;
    }

    public void setDiagCode(String diagCode) {
        this.diagCode = diagCode;
    }

    public String getDiagName() {
        return this.diagName;
    }

    public void setDiagName(String diagName) {
        this.diagName = diagName;
    }

    public String getPatiCondition() {
        return this.patiCondition;
    }

    public void setPatiCondition(String patiCondition) {
        this.patiCondition = patiCondition;
    }

    public String getLeaveMess() {
        return this.leaveMess;
    }

    public void setLeaveMess(String leaveMess) {
        this.leaveMess = leaveMess;
    }

    public List<MeetClinicResult> getMeetClinicResultList() {
        return this.meetClinicResultList;
    }

    public void setMeetClinicResultList(List<MeetClinicResult> meetClinicResultList) {
        this.meetClinicResultList = meetClinicResultList;
    }
}
