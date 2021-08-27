package com.taltools.service.impl;

import com.jayway.jsonpath.JsonPath;
import com.taltools.dao.AppraiseResultDao;
import com.taltools.service.AppraiseResultService;
import com.taltools.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class AppraiseResultServiceImpl implements AppraiseResultService {
    //备注信息，未使用
    /**当前工单节点：
     * expertMasterNode：大区主管节点
     * complaintNode：投诉专员节点
     * complaintExpertNode：投诉专家节点
     * complaintMasterNode：投诉负责人节点
     * expertNode：服务专家节点
     * areaNode：外部分校节点
     * areaMasterNode：分校负责人节点
     */
    private  String current_node;
    /**评价状态: （评价已解决（result：1）|评价未解决（result：2）|未评价（result：3）
     * |邀评未评价（result：4）|邀评中（result：5）|邀评终止（result：6））
     */
    private Integer result ;
    /**
     * 工单类型：1普通工单，2预升级工单，3升级工单，4投诉工单
     * */
    private Integer type ;
    /***
     * 工单状态（完成（status：4）|待回访（status：5）|完成未评价（status：6）
     *  |待处理（status：1）|无法解决（status：9）处理中（status：2））
     */
    private Integer status ;

    @Autowired
    private  AppraiseResultDao appraiseResultDao;

    /**
     * @param wo_number 工单号
     * */
    @Override
    public String getAll(String wo_number) {
        Map respMap = new HashMap();
        respMap.put("message","操作成功！");
        respMap.put("code","000000");
        respMap.put("wo_number",wo_number);
        respMap.put("data",appraiseResultDao.getAll(wo_number));
        return JsonUtils.mapToJson(respMap);
    }

    /**
     * @param reqJson 入参参数体
     * */
    @Override
    public String appraiseLog(String reqJson) {
        List<String> stu_codes = JsonPath.parse(reqJson).read("$.stu_codes");
        Map respMap = new HashMap();
        for (String stu_code : stu_codes){
            if (stu_code.length() !=0){
                respMap.put("message","操作成功！");
                respMap.put("code","000000");
//                respMap.put("data",appraiseResultDao.getStuCode(stu_code));
                appraiseResultDao.deleteStuCode(stu_code);
                System.out.println("执行成功");
            }else {
                return "学员编号不能为空";
            }
        }
        return JsonUtils.mapToJson(respMap);
    }
}
