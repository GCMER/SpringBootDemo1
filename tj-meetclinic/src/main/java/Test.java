//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.webreach.mirth.server.mule.components;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.webreach.mirth.server.mule.components.domain.Header;
import com.webreach.mirth.server.mule.components.domain.MeetClinic;
import com.webreach.mirth.server.mule.components.domain.MeetClinicResult;
import com.webreach.mirth.server.mule.components.domain.Request;
import java.io.Writer;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.xml.rpc.ServiceException;
import org.springframework.util.StringUtils;

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        List<MeetClinic> meetClinics = findTianJinMeetClinicDate();

        String result;
        for(Iterator i$ = meetClinics.iterator(); i$.hasNext(); System.out.println(result)) {
            MeetClinic mc = (MeetClinic)i$.next();
            Request res = new Request();
            Header header = new Header();
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String time = df.format(new Date());
            header.setSendTime(time);
            header.setMsgID("RC" + time);
            header.setMsgType("TCM_RC_03");
            header.setReceiver("PLAT");
            header.setSender("RC");
            res.setHeader(header);
            res.setMeetClinic(mc);
            XStream stream = new XStream(new XppDriver() {
                public HierarchicalStreamWriter createWriter(Writer out) {
                    return new PrettyPrintWriter(out) {
                        public void startNode(String name) {
                            if (name.indexOf(".") > -1) {
                                name = name.substring(name.lastIndexOf(".") + 1);
                            }

                            super.startNode(name);
                        }
                    };
                }
            });
            String request = stream.toXML(res);
            System.out.println(request);
            _Proxy7Service p = new _Proxy7ServiceLocator();
            TCM_RC_03SoapBindingStub t = null;

            try {
                t = (TCM_RC_03SoapBindingStub)p.getTCM_RC_03();
            } catch (ServiceException var15) {
                var15.printStackTrace();
            }

            result = null;

            try {
                result = t.acceptMessage(request);
            } catch (RemoteException var14) {
                var14.printStackTrace();
            }
        }

    }

    public static List<MeetClinic> findTianJinMeetClinicDate() {
        MeetClinic mc = null;
        List<MeetClinic> meetClinics = new ArrayList();
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test_v10";
        String user = "root";
        String passWord = "";

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, passWord);
            Statement statement = conn.createStatement();
            String sql = "SELECT\n\tp.PatientName,\n\td. NAME AS DepartName,\n\tm.*\nFROM\n\tbus_meetclinic m,\n\tbase_organ o,\n\tmpi_patient p,\n\tbase_department d\nWHERE\n\tm.RequestDepart = d.DeptId\nAND m.MPIID = p.MPIID\nAND m.RequestOrgan = o.OrganId\nAND o.AddrArea LIKE '1201%';";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
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

                mc = new MeetClinic(null,patiName, patiId, orgCode, telephone, id, type, requestOrgCode, requestDepartCode, requestDepartName, requestDoctorCode, diagCode, diagName, patiCondition, leaveMess);
                String sql2 = "SELECT\n\td. NAME AS TargetDoctorName,\n\tdm. NAME AS TargetDepartName,\n\tm.*\nFROM\n\tbus_meetclinicresult m,\n\tbase_doctor d,\n\tbase_department dm\nWHERE\n\tm.targetDoctor = d.doctorId\nAND m.TargetDepart = dm.DeptId\nAND m.meetclinicId =" + id;
                rs = statement.executeQuery(sql2);
                ArrayList list = new ArrayList();

                while(rs.next()) {
                    String id2 = rs.getString("MeetClinicResultID");
                    String exeOrgCode = rs.getString("TargetOrgan");
                    String exeDepartCode = rs.getString("TargetDepart");
                    String exeDepartName = rs.getString("TargetDepartName");
                    String exeDoctorCode = rs.getString("TargetDoctor");
                    String exeDoctorName = rs.getString("TargetDoctorName");
                    String meetReport = rs.getString("MeetReport");
                    MeetClinicResult mr = new MeetClinicResult(id2, exeOrgCode, exeDepartCode, exeDepartName, exeDoctorCode, exeDoctorName, meetReport, id);
                    list.add(mr);
                }

                mc.setMeetClinicResultList(list);
                meetClinics.add(mc);
            }

            rs.close();
            conn.close();
        } catch (ClassNotFoundException var35) {
            var35.printStackTrace();
        } catch (SQLException var36) {
            var36.printStackTrace();
        }

        return meetClinics;
    }
}
