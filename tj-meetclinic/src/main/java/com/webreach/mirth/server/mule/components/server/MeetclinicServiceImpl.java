//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.webreach.mirth.server.mule.components.server;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.webreach.mirth.server.mule.components.TCM_RC_03SoapBindingStub;
import com.webreach.mirth.server.mule.components._Proxy7Service;
import com.webreach.mirth.server.mule.components._Proxy7ServiceLocator;
import com.webreach.mirth.server.mule.components.dao.MeetClinicDAO;
import com.webreach.mirth.server.mule.components.domain.Header;
import com.webreach.mirth.server.mule.components.domain.MeetClinic;
import com.webreach.mirth.server.mule.components.domain.MeetClinicDTO;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.rpc.ServiceException;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

public class MeetclinicServiceImpl implements MeetclinicService {
    MeetClinicDAO dao = new MeetClinicDAO();
    private static Map tjmap;
    static {
        String str="{\"1000873\":\"\",\"1001023\":\"\",\"1001024\":\"\",\"1001028\":\"\",\"1001086\":\"\",\"1001124\":\"\",\"1001125\":\"\",\"1001126\":\"\",\"1001127\":\"\",\"1001128\":\"\",\t\n" +
                "\"1001129\":\"\",\"1001130\":\"\",\"1001251\":\"\",\"1001252\":\"\",\"1001253\":\"\",\"1001255\":\"\",\"1001256\":\"\",\"1001290\":\"\",\"1001291\":\"40125132\",\n" +
                "\"1001292\":\"40124532-4\",\"1001293\":\"66030787-6\",\"1001294\":\"10730020\",\"1001295\":\"401245340\",\"1001296\":\"78939206\",\"1001297\":\"\",\"1001298\":\"\",\t\n" +
                "\"1001299\":\"\",\"1001300\":\"40125134\",\"1001301\":\"10730020_0\",\"1001302\":\"E0166019\",\"1001304\":\"000502\",\"1001305\":\"\",\"1001309\":\"\",\"1001327\":\"\",\t\n" +
                "\"1001443\":\"\",\"1001455\":\"401322000\",\"1001457\":\"\",\"1001459\":\"\",\"1001461\":\"\",\"1001463\":\"401321905\",\"1001464\":\"\",\t\"1001466\":\"401321729\",\n" +
                "\"1001468\":\"401321737\",\"1001469\":\"401321999\",\"1001470\":\"\",\"1001472\":\"\",\"1001474\":\"\",\"1001477\":\"401321710\",\"1001479\":\"401322019\",\"1001482\":\"\",\t\n" +
                "\"1001483\":\"\",\"1001484\":\"40126812-0\",\"1001485\":\"40126819-8\",\"1001486\":\"68472269-5\",\"1001487\":\"\",\"1001488\":\"68472171-3\",\"1001489\":\"40126809-1\",\n" +
                "\"1001490\":\"40124116-3\",\"1001491\":\"E0182035-2\",\"1001492\":\"40126815-5\",\"1001493\":\"41026803-2\",\"1001494\":\"\",\"1001495\":\"40126810-4\",\n" +
                "\"1001496\":\"401254992\",\"1001497\":\"\",\"1001498\":\"\",\"1001499\":\"401253033\",\"1001500\":\"40125306-8\",\"1001501\":\"40122566\",\"1001502\":\"40122565\",\n" +
                "\"1001503\":\"40122571\",\"1001504\":\"40122566_0\",\"1001505\":\"40122574\",\"1001506\":\"401225796\",\"1001507\":\"40122570-2\",\"1001508\":\"12120103401225649N\",\n" +
                "\"1001509\":\"40122578-8\",\"1001510\":\"000057\",\"1001511\":\"\",\"1001512\":\"40122619\",\"1001518\":\"40124113-9\",\"1001519\":\"40121578-2\",\n" +
                "\"1001520\":\"\",\"1001521\":\"40121571-5\",\"1001522\":\"40121645-1\",\"1001523\":\"40121570-7\",\"1001524\":\"40123550-5\",\"1001525\":\"\",\"1001526\":\"121201064012410241\",\n" +
                "\"1001527\":\"\",\"1001528\":\"12120106718294722E\",\"1001529\":\"\",\"1001530\":\"40123565-2\",\"1001531\":\"40123544-1\",\"1001532\":\"12120106401241091Y\",\n" +
                "\"1001533\":\"74403917-8\",\"1001534\":\"40123548-4\",\"1001535\":\"12120106401241817N\",\"1001536\":\"\",\"1001537\":\"12120106401241163P\",\"1001538\":\"40124107-5\",\n" +
                "\"1001539\":\"40123552-1\",\"1001540\":\"40123549-2\",\"1001541\":\"40123543-3\",\"1001542\":\"40126400-7\",\"1001543\":\"E0178044－2\",\"1001544\":\"40126395－2\",\n" +
                "\"1001545\":\"\",\"1001546\":\"40123558-0\",\"1001547\":\"\",\"1001548\":\"40121397-9\",\"1001549\":\"\",\"1001550\":\"401335792\",\"1001551\":\"401335864\",\n" +
                "\"1001552\":\"\",\"1001554\":\"\",\"1001555\":\"40130335-2\",\"1001556\":\"\",\"1001558\":\"\",\"1001559\":\"401335522\",\"1001560\":\"\",\"1001561\":\"\",\t\n" +
                "\"1001562\":\"\",\"1001563\":\"401335821\",\"1001564\":\"\",\"1001565\":\"\",\"1001566\":\"\",\"1001567\":\"401335514\",\"1001568\":\"\",\t\n" +
                "\"1001569\":\"401335717\",\"1001570\":\"\",\"1001571\":\"\",\"1001572\":\"\",\"1001573\":\"\",\"1001574\":\"\",\"1001575\":\"40130332－1\",\"1001576\":\"401335856\",\n" +
                "\"1001577\":\"\",\"1001578\":\"40130332-8\",\"1001579\":\"40130324-8\",\"1001580\":\"\",\"1001581\":\"\",\"1001582\":\"40133567X\",\"1001583\":\"\",\"1001584\":\"40133583X\",\n" +
                "\"1001585\":\"401335610\",\"1001586\":\"\",\"1001587\":\"401335709\",\"1001588\":\"401336015\",\"1001589\":\"\",\"1001590\":\"40130329-9\",\"1001591\":\"401335557\",\n" +
                "\"1001592\":\"\",\"1001593\":\"\",\"1001594\":\"401335602\",\"1001595\":\"\",\"1001596\":\"\",\"1001597\":\"\",\"1001598\":\"\",\"1001599\":\"\",\"1001600\":\"40123140-8\",\n" +
                "\"1001601\":\"40123185-4\",\"1001602\":\"\",\"1001603\":\"40123206\",\"1001604\":\"\",\"1001605\":\"40123199-3\",\"1001606\":\"40123129-9\",\"1001607\":\"401231387\",\n" +
                "\"1001608\":\"40123201-3\",\"1001609\":\"\",\"1001610\":\"E0146103-8\",\"1001611\":\"\",\"1001612\":\"40127349-9\",\"1001613\":\"\",\"1001614\":\"\",\t\n" +
                "\"1001615\":\"\",\"1001616\":\"\",\"1001617\":\"40127345-6\",\"1001618\":\"\",\"1001619\":\"\",\"1001620\":\"\",\"1001621\":\"\",\"1001622\":\"\",\t\n" +
                "\"1001623\":\"401273368\",\"1001624\":\"401273376\",\"1001625\":\"401273421\",\"1001626\":\"\",\"1001627\":\"\",\"1001628\":\"73280626-1\",\"1001629\":\"40125835-2\",\n" +
                "\"1001630\":\"40125833-6\",\"1001631\":\"\",\"1001632\":\"40125839-5\",\"1001633\":\"73282079-2\",\"1001634\":\"401258408\",\"1001635\":\"40125831X\",\n" +
                "\"1001636\":\"40125834-4\",\"1001688\":\"E0138044-9\",\"1001689\":\"40122045-0\",\"1001690\":\"\",\"1001691\":\"\",\"1001692\":\"40122042-6\",\"1001693\":\"E0318045-7\",\n" +
                "\"1001694\":\"40122054-9\",\"1001695\":\"\",\"1001696\":\"40122044-2\",\"1001697\":\"40122051-4\",\"1001698\":\"E0138047-3\",\"1001699\":\"40122048-5\",\n" +
                "\"1001778\":\"\",\"1001788\":\"\",\"1001789\":\"\",\"1001867\":\"\",\"1002018\":\"\"}\t";
        tjmap = (Map) JSON.parse(str);
        System.out.println("初始化天津机构数据完成...");
    }
    public MeetclinicServiceImpl() {
    }

    public List<MeetClinic> getMeetClinicData() {
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
                String idcard = null;
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

                mc = new MeetClinic(idcard,patiName, patiId, orgCode, telephone, id, type, requestOrgCode, requestDepartCode, requestDepartName, requestDoctorCode, diagCode, diagName, patiCondition, leaveMess);
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
        } catch (ClassNotFoundException var36) {
            var36.printStackTrace();
        } catch (SQLException var37) {
            var37.printStackTrace();
        }

        return meetClinics;
    }

    public Map<String, Object> batchSend() {
        List<String> meetClinicIds = this.dao.findAllMCRequestByTianjin();
        System.out.println(meetClinicIds);
        return this.sender(meetClinicIds);
    }

    public Map<String, Object> sender(List<String> meetClinicIds) {

        Map<String, Object> map = new HashMap();
        List<String> success = new ArrayList();
        if (!CollectionUtils.isEmpty(meetClinicIds)) {
            Iterator i$ = meetClinicIds.iterator();

            while(i$.hasNext()) {
                String meetClinicId = (String)i$.next();
                MeetClinic mc = this.dao.getMeetClinic(meetClinicId);
                String tjOrgan = (String)tjmap.get(mc.getOrgCode());
                System.out.println("天津医院机构代码对比" + tjOrgan);
                if (!StringUtils.isEmpty(tjOrgan)) {
                    mc.setOrgCode(tjOrgan);
                    mc.setRequestOrgCode(tjOrgan);
                } else {
                    String organId = dao.getRequestOrganByMeetClinic(meetClinicId);
                    mc.setOrgCode(organId);
                    mc.setRequestOrgCode(organId);
                }
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
                } catch (ServiceException var18) {
                    var18.printStackTrace();
                }

                String result = null;

                try {
                    result = t.acceptMessage(request);
                } catch (RemoteException var17) {
                    var17.printStackTrace();
                }

                System.out.println(result);
                if (null != result) {
                    success.add(meetClinicId);
                    this.dao.upDateSendFlag(meetClinicId);
                }
            }

            if (success.size() > 0) {
                map.put("code", 200);
                map.put("msg", "success");
                map.put("successSend", success);
            } else {
                map.put("code", 609);
                map.put("msg", "发送失败");
            }
        }

        return map;
    }

    public List<Map<String, String>> findTianJinOrgans() {
        MeetClinicDAO dao = new MeetClinicDAO();
        return dao.findTianjinOrgans();
    }

    public List<MeetClinicDTO> findByOrganIds(List<String> organIds, int start, int limit) {
        MeetClinicDAO dao = new MeetClinicDAO();
        return dao.findByOrganIds(organIds, start, limit);
    }
}
