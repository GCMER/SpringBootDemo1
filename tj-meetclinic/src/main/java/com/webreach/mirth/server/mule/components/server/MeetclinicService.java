//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.webreach.mirth.server.mule.components.server;

import com.webreach.mirth.server.mule.components.domain.MeetClinicDTO;
import java.util.List;
import java.util.Map;

public interface MeetclinicService {
    Map<String, Object> batchSend();

    Map<String, Object> sender(List<String> var1);

    List<Map<String, String>> findTianJinOrgans();

    List<MeetClinicDTO> findByOrganIds(List<String> var1, int var2, int var3);
}
