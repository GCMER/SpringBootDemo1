//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.webreach.mirth.server.mule.components.controller;

import com.webreach.mirth.server.mule.components.domain.MeetClinicDTO;
import com.webreach.mirth.server.mule.components.server.MeetclinicService;
import com.webreach.mirth.server.mule.components.server.MeetclinicServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/meetClinicService"})
public class MeetclinicController {
    MeetclinicService service = new MeetclinicServiceImpl();

    public MeetclinicController() {
    }

    @RequestMapping({"/batchSendMeetClinic"})
    public Map<String, Object> batchSend() {
        return this.service.batchSend();
    }

    @RequestMapping({"/senderMeetClinic"})
    public Map<String, Object> sender(@RequestBody List<String> meetClinicIds) {
        return this.service.sender(meetClinicIds);
    }

    @RequestMapping({"/findTianJinOrgans"})
    public List<Map<String, String>> findTianJinOrgans() {
        return this.service.findTianJinOrgans();
    }

    @RequestMapping({"/findByOrganIds"})
    public List<MeetClinicDTO> findByOrganIds(@RequestBody Map<String, Object> map) {
        List<String> organIds = (List)map.get("organIds");
        int start = (Integer)map.get("start");
        int limit = (Integer)map.get("limit");
        return this.service.findByOrganIds(organIds, start, limit);
    }
}
