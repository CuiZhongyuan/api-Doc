package com.taltools.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Data
public class WorkOrderEntity implements Serializable {
    private String id;
    private String number;
    private String stu_id;
    private String stu_name;
    private String stu_school;
    private String stu_grade;
    private int is_old_stu;
    private int channel;
    private int process_result;
    private int process_progress;
    private String one_classify;
    private String two_classify;
    private String three_classify;
    private String out_phone;
    private String in_phone;
    private int out_phone_time;
    private String customer;
    private String subject;
    private String instancy;
    private int is_nick_name;
    private String call_remind;
    private String complaint_department;
    private String creator;
    private String creator_name;
    private int create_time;
    private int modify_time;
    private String modifier;
    //工单类型：1普通工单，2预升级工单，3升级工单，4投诉工单
    private int type;
    /***工单状态（完成（status：4）|待回访（status：5）|完成未评价（status：6）
     *   |待处理（status：1）|无法解决（status：9）处理中（status：2））
     */
    private int status;
    private String progressor;
    private String progressor_name;
    private String call_center_station;
    private String production_type;
    private String complaint_id;
    private int reopen_count;
    private String current_node;
    private String school_call_remind;
    private int version;
    private int long_term_order;

}
