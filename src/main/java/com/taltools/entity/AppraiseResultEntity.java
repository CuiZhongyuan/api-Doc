package com.taltools.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Data
public class AppraiseResultEntity implements Serializable {

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
    /**评价状态:
     * 评价已解决（result：1）
     * 评价未解决（result：2）
     * 未评价（result：3）
     * 邀评未评价（result：4）
     * 邀评中（result：5）
     * 邀评终止（result：6））
     */
    private int result;
    /** 工单类型：
     * 1普通工单
     * 2预升级工单
     * 3升级工单
     * 4投诉工单
     */
    private int type;
    /***
     * 工单状态
     * 完成（status：4）
     * 待回访（status：5）
     * 完成未评价（status：6）
     * 待处理（status：1）
     * 无法解决（status：9）
     * 处理中（status：2））
     */
    private int status;
    //学员编号
//    private String stu_id;
    //推送次数
//    private int num;
    //最大推送次数
//    private int max_num;
    //创建时间
//    private String create_time;
//    private String  modify_time;

}
