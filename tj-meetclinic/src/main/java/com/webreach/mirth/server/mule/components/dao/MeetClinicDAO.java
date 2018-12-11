//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.webreach.mirth.server.mule.components.dao;

import com.webreach.mirth.server.mule.components.domain.Header;
import com.webreach.mirth.server.mule.components.domain.MeetClinic;
import com.webreach.mirth.server.mule.components.domain.MeetClinicDTO;
import com.webreach.mirth.server.mule.components.domain.MeetClinicResult;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.util.StringUtils;

public class MeetClinicDAO {
    private Connection conn;
    private MeetClinic mc = null;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://ngarihealth.mysql.rds.aliyuncs.com:3306/eh_base?useUnicode=true&amp;characterEncoding=utf-8";
    private String user = "ehbase_live";
    private String passWord = "LiveBase@2016_";

    public MeetClinicDAO() {
    }

    public List<Map<String, String>> findTianjinOrgans() {
        ArrayList result = new ArrayList();

        try {
            Class.forName(this.driver);
            Connection conn = DriverManager.getConnection(this.url, this.user, this.passWord);
            String sql = "SELECT\n\to.*\nFROM\n\tbase_organ o\nWHERE\n\to.AddrArea LIKE '1201%'";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
                Map<String, String> map = new HashMap();
                String organName = rs.getString("Name");
                String organId = rs.getString("OrganId");
                map.put("organId", organId);
                map.put("organName", organName);
                result.add(map);
            }

            rs.close();
            conn.close();
        } catch (ClassNotFoundException var9) {
            var9.printStackTrace();
        } catch (SQLException var10) {
            var10.printStackTrace();
        }

        return result;
    }

    public List<MeetClinicDTO> findByOrganIds(List<String> organIds, int start, int limit) {
        StringBuilder sb = new StringBuilder();
        Iterator i$ = organIds.iterator();

        String sb2;
        while(i$.hasNext()) {
            sb2 = (String)i$.next();
            sb.append(sb2 + ",");
        }

        String sb1 = sb.toString();
        sb2 = sb1.substring(0, sb1.length() - 1);
        System.out.println(sb2);
        MeetClinicDTO mc = null;
        ArrayList meetClinics = new ArrayList();

        try {
            Class.forName(this.driver);
            Connection conn = DriverManager.getConnection(this.url, this.user, this.passWord);
            String sql = "SELECT DISTINCT\n\tp.PatientName,\n\td. NAME AS DepartName,\n\to. NAME AS organName,\n\tdt. NAME AS doctorName,\n\tm.*\nFROM\n\tbus_meetclinic m,\n\tbase_organ o,\n\tmpi_patient p,\n\tbase_department d,\n\tbase_doctor dt\nWHERE\n\tm.RequestDepart = d.DeptId\nAND m.RequestDoctor = dt.DoctorId\nAND m.RequestOrgan = o.OrganId\nAND m.MPIID = p.MPIID\nAND m.sendFlag = 0\nAND m.RequestOrgan IN (" + sb2 + ")\n" + "ORDER BY m.RequestTime DESC " + "limit ?,?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String patientName = rs.getString("patientName");
                String departName = rs.getString("departName");
                String organName = rs.getString("organName");
                String doctorName = rs.getString("doctorName");
                String meetClinicId = rs.getString("meetClinicId");
                String startTime = rs.getString("requestTime");
                String endTime = rs.getString("sessionEndTime");
                String diagianName = rs.getString("diagianName");
                mc = new MeetClinicDTO(meetClinicId, organName, doctorName, departName, patientName, startTime, endTime, diagianName);
                meetClinics.add(mc);
            }

            rs.close();
            conn.close();
        } catch (ClassNotFoundException var21) {
            var21.printStackTrace();
        } catch (SQLException var22) {
            var22.printStackTrace();
        }

        return meetClinics;
    }

    public void upDateSendFlag(String meetClinicId) {
        try {
            Class.forName(this.driver);
            Connection conn = DriverManager.getConnection(this.url, this.user, this.passWord);
            Statement statement = conn.createStatement();
            String sql = "UPDATE bus_meetclinic SET sendFlag=1 WHERE meetClinicId=" + meetClinicId;
            statement.execute(sql);
            conn.close();
        } catch (ClassNotFoundException var5) {
            var5.printStackTrace();
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

    }

    public List<String> findAllMCRequestByTianjin() {
        ArrayList meetClinicIds = new ArrayList();

        try {
            Class.forName(this.driver);
            Connection conn = DriverManager.getConnection(this.url, this.user, this.passWord);
            Statement statement = conn.createStatement();
            String sql = "select m.meetClinicId from bus_meetclinic m,base_organ o where m.sendFlag=0 and m.RequestOrgan=o.OrganId and o.AddrArea like '1201%'";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
                String meetClinicId = rs.getString("meetClinicId");
                meetClinicIds.add(meetClinicId);
            }

            rs.close();
            conn.close();
        } catch (ClassNotFoundException var7) {
            var7.printStackTrace();
        } catch (SQLException var8) {
            var8.printStackTrace();
        }

        return meetClinicIds;
    }

    public MeetClinic getMeetClinic(String meetClinicId) {
        MeetClinic mc = null;

        try {
            Class.forName(this.driver);
            Connection conn = DriverManager.getConnection(this.url, this.user, this.passWord);
            Statement statement = conn.createStatement();
            String sql = "SELECT\n\to.OrganizeCode,\n\tp.PatientName,\n\tp.IDCard,\n\td. NAME AS DepartName,\n\tm.*\nFROM\n\tbus_meetclinic m,\n\tbase_organ o,\n\tmpi_patient p,\n\tbase_department d\nWHERE\n\tm.RequestDepart = d.DeptId\nAND m.MPIID = p.MPIID\nAND m.sendFlag = 0\nAND o.OrganId = m.RequestOrgan\nAND m.MeetClinicId =" + meetClinicId;
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
                String patientIdCard = rs.getString("IDCard");
                String patiName = rs.getString("patientName");
                String patiId = rs.getString("mpiId");
                String orgCode = rs.getString("RequestOrgan");
                String telephone = rs.getString("AnswerTel");
                String id = rs.getString("meetClinicId");
                String type = rs.getString("MeetClinicType");
                String requestOrgCode = rs.getString("RequestOrgan");
                String requestDepartCode = rs.getString("RequestDepart");
                String requestDepartName = rs.getString("DepartName");
                String requestDoctorCode = rs.getString("RequestDoctor");
                String diagCode = rs.getString("DiagianCode");
                String diagName = rs.getString("DiagianName");
                String patiCondition = rs.getString("PatientCondition");
                String leaveMess = rs.getString("LeaveMess");
                if (StringUtils.isEmpty(leaveMess)) {
                    leaveMess = patiCondition;
                }

                mc = new MeetClinic(patientIdCard,patiName, patiId, orgCode, telephone, id, type, requestOrgCode, requestDepartCode, requestDepartName, requestDoctorCode, diagCode, diagName, patiCondition, leaveMess);
                String sql2 = "SELECT\n\to.OrganizeCode,\n\td. NAME AS TargetDoctorName,\n\tdm. NAME AS TargetDepartName,\n\tm.*\nFROM\n\tbus_meetclinicresult m,\n\tbase_organ o,\n\tbase_doctor d,\n\tbase_department dm\nWHERE\n\tm.targetDoctor = d.doctorId\nAND m.TargetDepart = dm.DeptId\nAND o.OrganId = m.TargetOrgan\nAND m.meetclinicId =" + id;
                rs = statement.executeQuery(sql2);
                ArrayList list = new ArrayList();

                while(rs.next()) {
                    String id2 = rs.getString("MeetClinicResultID");
                    String exeOrgCode = rs.getString("OrganizeCode");
                    String exeDepartCode = rs.getString("TargetDepart");
                    String exeDepartName = rs.getString("TargetDepartName");
                    String exeDoctorCode = rs.getString("TargetDoctor");
                    String exeDoctorName = rs.getString("TargetDoctorName");
                    String meetReport = rs.getString("MeetReport");
                    if (StringUtils.isEmpty(meetReport)) {
                        meetReport="该医生没有回复会诊意见";
                    }
                    MeetClinicResult mr = new MeetClinicResult(id2, exeOrgCode, exeDepartCode, exeDepartName, exeDoctorCode, exeDoctorName, meetReport, id);
                    list.add(mr);
                }

                mc.setMeetClinicResultList(list);
            }

            rs.close();
            conn.close();
        } catch (ClassNotFoundException var32) {
            var32.printStackTrace();
        } catch (SQLException var33) {
            var33.printStackTrace();
        }

        return mc;
    }

    public String getRequestOrganByMeetClinic(String meetClinicId) {
        String organId = null;

        try {
            Class.forName(this.driver);
            Connection conn = DriverManager.getConnection(this.url, this.user, this.passWord);
            String sql = "SELECT m.RequestOrgan FROM bus_meetclinic m WHERE m.meetclinicId=" + meetClinicId;
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
                 organId = rs.getString("RequestOrgan");
            }

            rs.close();
            conn.close();
        } catch (ClassNotFoundException var9) {
            var9.printStackTrace();
        } catch (SQLException var10) {
            var10.printStackTrace();
        }

        return organId;
    }
}
