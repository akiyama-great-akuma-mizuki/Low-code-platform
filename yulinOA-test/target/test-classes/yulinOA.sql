DROP TABLE IF EXISTS `sys_meeting`;
CREATE TABLE `sys_meeting` (
  `id` varchar(32) NOT NULL  COMMENT '会议ID',
  `apply_people` varchar(5) NOT NULL  COMMENT '申请人姓名',
  `enterprise_id` varchar(32) COMMENT '企业ID',
  `meeting_room_id` varchar(32) COMMENT '会议室ID',
  `meeting_title` varchar(20) NOT NULL  COMMENT '会议标题',
  `join_meeting_num` Integer(4) NOT NULL  COMMENT '参会人数',
  `meeting_time` timestamp(0) NOT NULL  COMMENT '会议时间',
  `meeting_address` varchar(50) NOT NULL  COMMENT '会议地址',
  `meeting_explain` varchar(100) NOT NULL  COMMENT '说明',
  `audi_state` Integer(1) NOT NULL  COMMENT '审批状态',
  `audi_remark` varchar(32) COMMENT '审批备注',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_meeting_room`;
CREATE TABLE `sys_meeting_room` (
  `id` varchar(32) NOT NULL  COMMENT '会议室ID',
  `room_name` varchar(32) NOT NULL  COMMENT '会议室名称',
  `room_facility` varchar(50) NOT NULL  COMMENT '设施信息',
  `room_state` Integer(1) NOT NULL  COMMENT '状态',
  `room_capacity` Integer(5) NOT NULL  COMMENT '容量',
  `room_floor` varchar(10) NOT NULL  COMMENT '楼层',
  `room_explain` varchar(30) NOT NULL  COMMENT '说明',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_official`;
CREATE TABLE `sys_official` (
  `id` varchar(32) NOT NULL  COMMENT '公文ID',
  `official_title` varchar(20) NOT NULL  COMMENT '标题',
  `send_time` timestamp(0) NOT NULL  COMMENT '发送时间',
  `sent_obj` varchar(32) NOT NULL  COMMENT '送达对象',
  `whether_red` varchar(32) NOT NULL  COMMENT '是否套红',
  `signature` varchar(200) NOT NULL  COMMENT '电子签章',
  `audit` varchar(32) NOT NULL  COMMENT '审核人',
  `content` varchar(1000) NOT NULL  COMMENT '详细内容',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_official_history`;
CREATE TABLE `sys_official_history` (
  `id` varchar(32) NOT NULL  COMMENT '公文历史记录ID',
  `operate_class` varchar(32) NOT NULL  COMMENT '操作类型',
  `operate_people` varchar(10) NOT NULL  COMMENT '操作人',
  `result` Integer(1) NOT NULL  COMMENT '执行结果',
  `remark` varchar(30) NOT NULL  COMMENT '备注',
  `official_id` varchar(32) COMMENT '公文ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_holiday`;
CREATE TABLE `sys_holiday` (
  `id` varchar(32) NOT NULL  COMMENT '请假ID',
  `holiday_class` varchar(5) NOT NULL  COMMENT '请假类型',
  `hiliday_start_time` timestamp(0) NOT NULL  COMMENT '开始时间',
  `holiday_end_time` timestamp(0) NOT NULL  COMMENT '结束时间',
  `holiday_reason` varchar(50) NOT NULL  COMMENT '请假事由',
  `user_id` varchar(32) NOT NULL  COMMENT '请假人ID',
  `status` varchar(32) NOT NULL  DEFAULT 0 COMMENT '状态',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_business_trip`;
CREATE TABLE `sys_business_trip` (
  `id` varchar(32) NOT NULL  COMMENT '出差ID',
  `trip_start_time` timestamp(0) NOT NULL  COMMENT '开始时间',
  `trip_end_time` timestamp(0) NOT NULL  COMMENT '结束时间',
  `trip_start_place` varchar(32) NOT NULL  COMMENT '出发地',
  `trip_end_place` varchar(50) NOT NULL  COMMENT '目的地',
  `traffic_tool` varchar(50) NOT NULL  COMMENT '交通工具',
  `trip_back` varchar(32) NOT NULL  COMMENT '单程/往返',
  `trip_remark` varchar(100) NOT NULL  COMMENT '备注',
  `user_id` varchar(32) NOT NULL  COMMENT '出差用户Id',
  `status` Integer(5) NOT NULL  DEFAULT 0 COMMENT '状态',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_in_job`;
CREATE TABLE `sys_in_job` (
  `id` varchar(32) NOT NULL  COMMENT '入职流程ID',
  `user_id` varchar(32) NOT NULL  COMMENT '发起人ID',
  `phone` varchar(11) COMMENT '手机号',
  `id_card` varchar(18) COMMENT '身份证号',
  `department` varchar(10) COMMENT '部门',
  `position` varchar(10) COMMENT '岗位',
  `email` varchar(32) COMMENT '企业邮箱',
  `in_job_remark` varchar(50) COMMENT '备注',
  `approver` varchar(10) NOT NULL  COMMENT '审批人',
  `status` Integer(5) NOT NULL  DEFAULT 0 COMMENT '状态',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_leave_job`;
CREATE TABLE `sys_leave_job` (
  `id` varchar(32) NOT NULL  COMMENT '离职流程ID',
  `user_id` varchar(32) NOT NULL  COMMENT '发起人ID',
  `position` varchar(10) COMMENT '岗位',
  `apply_leave_time` timestamp(0) NULL  COMMENT '申请离职时间',
  `leave_reason` varchar(50) COMMENT '离职原因',
  `leave_remark` varchar(50) COMMENT '备注',
  `status` Integer(5) NOT NULL  DEFAULT 0 COMMENT '状态',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_knowledge`;
CREATE TABLE `sys_knowledge` (
  `id` varchar(32) NOT NULL  COMMENT '知识ID',
  `knowledge_name` varchar(20) NOT NULL  COMMENT '文档名称',
  `upload` varchar(10) NOT NULL  COMMENT '上传人',
  `look_up` varchar(50) NOT NULL  COMMENT '查阅部门',
  `describe` varchar(50) NOT NULL  COMMENT '描述',
  `content_detail` varchar(500) COMMENT '详细内容',
  `browse` Integer(5) NOT NULL  COMMENT '浏览次数',
  `accessory` varchar(500) COMMENT '附件',
  `upload_time` timestamp(0) NOT NULL  COMMENT '上传时间',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_rules`;
CREATE TABLE `sys_rules` (
  `id` varchar(32) NOT NULL  COMMENT '制度ID',
  `rules_title` varchar(32) NOT NULL  COMMENT '制度标题',
  `release_time` timestamp(0) NOT NULL  COMMENT '发布时间',
  `execute_time` timestamp(0) NOT NULL  COMMENT '执行时间',
  `user_id` varchar(32) NOT NULL  COMMENT '发布人ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_news`;
CREATE TABLE `sys_news` (
  `id` varchar(32) NOT NULL  COMMENT '新闻ID',
  `news_title` varchar(20) NOT NULL  COMMENT '标题',
  `publisher` varchar(10) NOT NULL  COMMENT '发布人',
  `release_time` timestamp(0) NOT NULL  COMMENT '发布时间',
  `release_department` varchar(32) NOT NULL  COMMENT '发布部门',
  `file` varchar(500) NOT NULL  COMMENT '附件',
  `detail_content` varchar(500) COMMENT '详细内容',
  `news_img` varchar(128) COMMENT '图片',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_group`;
CREATE TABLE `sys_group` (
  `id` varchar(32) NOT NULL  COMMENT '群聊ID',
  `head_img` varchar(500) NOT NULL  COMMENT '群头像',
  `group_name` varchar(20) NOT NULL  COMMENT '群名称',
  `group_people` varchar(600) NOT NULL  COMMENT '群成员',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_meeting_participant`;
CREATE TABLE `sys_meeting_participant` (
  `id` varchar(32) NOT NULL  COMMENT '会议成员ID',
  `meeting_id` varchar(32) NOT NULL  COMMENT '会议ID',
  `user_id` varchar(32) NOT NULL  COMMENT '用户ID',
  `status` Integer(5) NOT NULL  DEFAULT 0 COMMENT '状态',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_holiday_check`;
CREATE TABLE `sys_holiday_check` (
  `id` varchar(32) NOT NULL  COMMENT '请假审批ID',
  `holiday_id` varchar(32) NOT NULL  COMMENT '请假ID',
  `approver_id` varchar(32) NOT NULL  COMMENT '审批人ID',
  `status` Integer(5) NOT NULL  DEFAULT 0 COMMENT '状态',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_business_trip_people`;
CREATE TABLE `sys_business_trip_people` (
  `id` varchar(32) NOT NULL  COMMENT '出差同行人ID',
  `business_trip_id` varchar(32) NOT NULL  COMMENT '出差ID',
  `user_id` varchar(32) NOT NULL  COMMENT '用户ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_business_trip_check`;
CREATE TABLE `sys_business_trip_check` (
  `id` varchar(32) NOT NULL  COMMENT '出差审批ID',
  `business_trip_id` varchar(32) NOT NULL  COMMENT '出差管理ID',
  `approver_id` varchar(32) NOT NULL  COMMENT '审批人ID',
  `status` Integer(5) NOT NULL  DEFAULT 0 COMMENT '状态',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_entrance_guard_user`;
CREATE TABLE `sys_entrance_guard_user` (
  `id` varchar(32) NOT NULL  COMMENT '用户门禁ID',
  `visitor_type` Integer(1) NOT NULL  DEFAULT 0 COMMENT '类型',
  `belong_company` varchar(32) NOT NULL  COMMENT '所属公司',
  `in_park_time` timestamp(0) NOT NULL  COMMENT '入园开始时间',
  `entrance_user_name` varchar(32) NOT NULL  COMMENT '门禁用户名称',
  `entrance_scope` varchar(32) NOT NULL  COMMENT '门禁范围',
  `out_park_time` timestamp(0) NOT NULL  COMMENT '入园结束时间',
  `entrance_management_id` varchar(32) COMMENT '门禁ID',
  `entrance_phone` varchar(11) NOT NULL  COMMENT '联系方式',
  `entrance_remark` varchar(32) COMMENT '备注',
  `entrance_record` varchar(32) COMMENT '门禁卡使用记录',
  `apply_state` Integer(1) NOT NULL  COMMENT '申请状态',
  `qr_code` varchar(128) COMMENT '二维码',
  `entrance_card_id` varchar(32) COMMENT '门禁卡号',
  `examine_remark` varchar(64) COMMENT '审批备注',
  `enterprise_id` varchar(32) COMMENT '企业ID',
  `user_id` varchar(32) NOT NULL  COMMENT '用户ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_schedule`;
CREATE TABLE `sys_schedule` (
  `id` varchar(32) NOT NULL  COMMENT '日程ID',
  `user_id` varchar(32) NOT NULL  COMMENT '发起人ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_schedule_item`;
CREATE TABLE `sys_schedule_item` (
  `id` varchar(32) NOT NULL  COMMENT '日程项ID',
  `schedule_id` varchar(32) NOT NULL  COMMENT '日程ID',
  `begin_date` timestamp(0) NOT NULL  COMMENT '开始时间',
  `end_date` timestamp(0) NOT NULL  COMMENT '结束时间',
  `status` Integer(5) NOT NULL  COMMENT '状态',
  `event_name` varchar(32) NOT NULL  COMMENT '事件名称',
  `event_type` Integer(5) NOT NULL  DEFAULT 0 COMMENT '事件类型',
  `event_id` varchar(32) COMMENT '事件ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_entrance_management`;
CREATE TABLE `sys_entrance_management` (
  `id` varchar(32) NOT NULL  COMMENT '门禁ID',
  `entrance_name` varchar(32) NOT NULL  COMMENT '门禁名称',
  `in_or_out` varchar(1) NOT NULL  COMMENT '进出类型',
  `address` varchar(128) NOT NULL  COMMENT '所在位置',
  `use_num` Integer(5) NOT NULL  COMMENT '使用人次',
  `belong_building` varchar(32) NOT NULL  COMMENT '所属楼栋',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_car`;
CREATE TABLE `sys_car` (
  `id` varchar(32) NOT NULL  COMMENT '车辆ID',
  `driver_name` varchar(10) NOT NULL  COMMENT '车主姓名',
  `driver_phone` varchar(11) NOT NULL  COMMENT '联系电话',
  `car_i_d` varchar(8) NOT NULL  COMMENT '车牌号',
  `park_type` varchar(2) NOT NULL  COMMENT '停车类型',
  `car_state` varchar(3) NOT NULL  COMMENT '车辆状态',
  `stop_time` timestamp(0) NULL  COMMENT '停车时长',
  `enterprise_id` varchar(32) NOT NULL  COMMENT '企业ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_park_park`;
CREATE TABLE `sys_park_park` (
  `id` varchar(32) NOT NULL  COMMENT '园区停车场ID',
  `park_name` varchar(10) NOT NULL  COMMENT '停车场名称',
  `all_stall` Integer(4) NOT NULL  COMMENT '总车位',
  `place` varchar(32) NOT NULL  COMMENT '位置',
  `residue_stall` Integer(4) NOT NULL  COMMENT '剩余停车位',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_blacklist`;
CREATE TABLE `sys_blacklist` (
  `id` varchar(32) NOT NULL  COMMENT '黑名单ID',
  `operator` varchar(32) NOT NULL  COMMENT '操作人',
  `operate_time` timestamp(0) NOT NULL  COMMENT '操作时间',
  `car_id` varchar(32) COMMENT '车辆ID',
  `reason` varchar(32) COMMENT '设置原因',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_property`;
CREATE TABLE `sys_property` (
  `id` varchar(32) NOT NULL  COMMENT '物业服务ID',
  `firm_name` varchar(32) NOT NULL  COMMENT '企业名称',
  `rent_place` varchar(100) NOT NULL  COMMENT '租用地址',
  `linkman` varchar(32) NOT NULL  COMMENT '联系人',
  `link_phone` varchar(11) NOT NULL  COMMENT '手机号',
  `enter_time` timestamp(0) NOT NULL  COMMENT '入驻时间',
  `cost_type` varchar(32) NOT NULL  COMMENT '费用类型',
  `cost_state` varchar(32) NOT NULL  COMMENT '费用状态',
  `wait_pay_num` Integer(5) NOT NULL  COMMENT '待缴金额',
  `enterprise_id` varchar(32) NOT NULL  COMMENT '企业ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_property_record`;
CREATE TABLE `sys_property_record` (
  `id` varchar(32) NOT NULL  COMMENT '物业缴费记录ID',
  `pay_people` varchar(32) NOT NULL  COMMENT '缴费人',
  `pay_phone` varchar(11) NOT NULL  COMMENT '手机号',
  `pay_num` Integer(5) COMMENT '缴费金额',
  `pay_time` varchar(32) NOT NULL  COMMENT '缴费时间',
  `pay_way` varchar(32) NOT NULL  COMMENT '缴费方式',
  `property_id` varchar(32) COMMENT '物业服务ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `id` varchar(32) NOT NULL  COMMENT '公告ID',
  `notice_title` varchar(32) NOT NULL  COMMENT '公告标题',
  `issuer` varchar(32) NOT NULL  COMMENT '发布人',
  `issue_time` timestamp(0) NOT NULL  COMMENT '发布时间',
  `accessory` varchar(32) NOT NULL  COMMENT '附件',
  `detail` varchar(1000) COMMENT '详细内容',
  `notice_img` varchar(32) COMMENT '图片',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_notice_enterprise`;
CREATE TABLE `sys_notice_enterprise` (
  `id` varchar(32) NOT NULL  COMMENT '公告查阅企业ID',
  `notice_id` varchar(32) NOT NULL  COMMENT '公告ID',
  `enterprise_id` varchar(32) NOT NULL  COMMENT '企业ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_car_park`;
CREATE TABLE `sys_car_park` (
  `id` varchar(32) NOT NULL  COMMENT '车辆停车ID',
  `status` Integer(5) NOT NULL  DEFAULT 0 COMMENT '停车状态',
  `time` varchar(32) COMMENT '停车时长',
  `car_id` varchar(32) NOT NULL  COMMENT '车辆ID',
  `park_place_id` varchar(32) COMMENT '停车位ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_park_place`;
CREATE TABLE `sys_park_place` (
  `id` varchar(32) NOT NULL  COMMENT '停车位ID',
  `park_park_id` varchar(32) NOT NULL  COMMENT '停车场ID',
  `name` varchar(32) NOT NULL  COMMENT '车位名',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_diy_flow`;
CREATE TABLE `sys_diy_flow` (
  `id` varchar(32) NOT NULL  COMMENT '自定义流程ID',
  `url` varchar(128) COMMENT '图标url',
  `name` varchar(32) NOT NULL  COMMENT '流程名称',
  `person` varchar(32) NOT NULL  COMMENT '申请人',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_diy_flow_text`;
CREATE TABLE `sys_diy_flow_text` (
  `id` varchar(32) NOT NULL  COMMENT '自定义流程字段ID',
  `title` varchar(32) NOT NULL  COMMENT '字段标题',
  `type` Integer(5) NOT NULL  DEFAULT 0 COMMENT '类型',
  `diy_flow_id` varchar(32) NOT NULL  COMMENT '自定义流程ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_diy_flow_node`;
CREATE TABLE `sys_diy_flow_node` (
  `id` varchar(32) NOT NULL  COMMENT '自定义流程节点ID',
  `type` Integer(5) NOT NULL  DEFAULT 0 COMMENT '节点类型',
  `title` varchar(32) NOT NULL  COMMENT '节点标题',
  `diy_flow_id` varchar(32) NOT NULL  COMMENT '自定义流程ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_diy_flow_finish`;
CREATE TABLE `sys_diy_flow_finish` (
  `id` varchar(32) NOT NULL  COMMENT '自定义流程完成ID',
  `diy_flow_id` varchar(32) NOT NULL  COMMENT '自定义流程ID',
  `status` Integer(5) NOT NULL  DEFAULT 0 COMMENT '状态',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_entrance_history`;
CREATE TABLE `sys_entrance_history` (
  `id` varchar(32) NOT NULL  COMMENT '门禁历史记录ID',
  `entrance_guard_id` varchar(32) NOT NULL  COMMENT '门禁ID',
  `staff_name` varchar(32) NOT NULL  COMMENT '员工姓名',
  `tell_phone` varchar(32) NOT NULL  COMMENT '联系方式',
  `use_date` timestamp(0) NOT NULL  COMMENT '使用日期',
  `in_or_out` Integer(1) NOT NULL  COMMENT '进出类型',
  `entrance_name` varchar(32) NOT NULL  COMMENT '门禁名称',
  `photo` varchar(128) COMMENT '拍照',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_event`;
CREATE TABLE `sys_event` (
  `id` varchar(32) NOT NULL  COMMENT '事件ID',
  `type` varchar(32) NOT NULL  COMMENT '类型',
  `status` varchar(32) NOT NULL  COMMENT '状态',
  `name` varchar(32) NOT NULL  COMMENT '名称',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_task`;
CREATE TABLE `sys_task` (
  `id` varchar(32) NOT NULL  COMMENT '任务ID',
  `type` varchar(32) COMMENT '类型',
  `name` varchar(32) NOT NULL  COMMENT '名称',
  `flow_id` varchar(32) NOT NULL  COMMENT '流程ID',
  `status` varchar(32) NOT NULL  COMMENT '状态',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_event_task`;
CREATE TABLE `sys_event_task` (
  `id` varchar(32) NOT NULL  COMMENT '事件任务ID',
  `event_id` varchar(32) NOT NULL  COMMENT '事件ID',
  `task_id` varchar(32) NOT NULL  COMMENT '任务ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_check`;
CREATE TABLE `sys_check` (
  `id` varchar(32) NOT NULL  COMMENT '审批ID',
  `event_id` varchar(32) NOT NULL  COMMENT '关联事件ID',
  `status` Integer(5) NOT NULL  DEFAULT 0 COMMENT '状态',
  `type` Integer(5) NOT NULL  COMMENT '事件类型',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_check_person`;
CREATE TABLE `sys_check_person` (
  `id` varchar(32) NOT NULL  COMMENT '审批人审批ID',
  `check_id` varchar(32) NOT NULL  COMMENT '审批ID',
  `status` Integer(5) NOT NULL  DEFAULT 0 COMMENT '状态',
  `user_id` varchar(32) NOT NULL  COMMENT '用户ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_archive_manage`;
CREATE TABLE `sys_archive_manage` (
  `id` varchar(32) NOT NULL  COMMENT '档案ID',
  `name` varchar(32) COMMENT '档案名称',
  `department` varchar(32) COMMENT '查阅组织',
  `description` varchar(128) COMMENT '内容描述',
  `browse_times` Integer(5) NOT NULL  DEFAULT 1 COMMENT '浏览次数',
  `content_url` varchar(128) COMMENT '内容富文本',
  `upload_user_id` varchar(32) NOT NULL  COMMENT '上传人id',
  `upload_time` timestamp(0) NOT NULL  COMMENT '上传时间',
  `archive_detail_id` varchar(32) COMMENT '档案详细ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_rules_execute`;
CREATE TABLE `sys_rules_execute` (
  `id` varchar(32) NOT NULL  COMMENT '制度执行ID',
  `rules_id` varchar(32) NOT NULL  COMMENT '制度ID',
  `department_id` varchar(32) NOT NULL  COMMENT '部门ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_custom_schedule`;
CREATE TABLE `sys_custom_schedule` (
  `id` varchar(32) NOT NULL  COMMENT '自定义日程ID',
  `title` varchar(32) NOT NULL  COMMENT '标题',
  `time` timestamp(0) NULL  COMMENT '时间',
  `address` varchar(32) COMMENT '地址',
  `remark` varchar(32) COMMENT '备注',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_seal_hold_manage`;
CREATE TABLE `sys_seal_hold_manage` (
  `id` varchar(32) NOT NULL  COMMENT '印章持有ID',
  `holder_id` varchar(32) NOT NULL  COMMENT '持有人ID',
  `archive_id` varchar(32) NOT NULL  COMMENT '印章Id',
  `limit_end_time` timestamp(0) NULL  COMMENT '截止日期',
  `hold_limit` Integer(5) NOT NULL  COMMENT '持有期限',
  `state` Integer(5) NOT NULL  COMMENT '状态',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_seal_manage`;
CREATE TABLE `sys_seal_manage` (
  `id` varchar(32) NOT NULL  COMMENT '印章ID',
  `name` varchar(128) NOT NULL  COMMENT '印章名称',
  `number` varchar(128) NOT NULL  COMMENT '印章编号',
  `picture_url` varchar(128) NOT NULL  COMMENT '印章图片',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_seal_apply_check_manage`;
CREATE TABLE `sys_seal_apply_check_manage` (
  `id` varchar(32) NOT NULL  COMMENT '印章申请审核ID',
  `seal_apply_id` varchar(32) NOT NULL  COMMENT '印章申请Id',
  `check_person_id` varchar(32) NOT NULL  COMMENT '审核人',
  `check_status` Integer(5) NOT NULL  COMMENT '审核状态',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_seal_apply_manage`;
CREATE TABLE `sys_seal_apply_manage` (
  `id` varchar(32) NOT NULL  COMMENT '印章申请ID',
  `apply_user_id` varchar(32) NOT NULL  COMMENT '申请人ID',
  `seal_id` varchar(32) NOT NULL  COMMENT '印章Id',
  `end_time` timestamp(0) NULL  COMMENT '到期时间',
  `apply_file_url` varchar(128) COMMENT '授权书',
  `limit` Integer(5) NOT NULL  COMMENT '申请期限',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_schedule_person`;
CREATE TABLE `sys_schedule_person` (
  `id` varchar(32) NOT NULL  COMMENT '日程参与人员ID',
  `schedule_id` varchar(32) NOT NULL  COMMENT '日程ID',
  `user_id` varchar(32) NOT NULL  COMMENT '参与人ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_organize_archive`;
CREATE TABLE `sys_organize_archive` (
  `id` varchar(32) NOT NULL  COMMENT '组织查阅档案ID',
  `archive_id` varchar(32) NOT NULL  COMMENT '档案ID',
  `organize_id` varchar(32) NOT NULL  COMMENT '组织ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_archive_detail`;
CREATE TABLE `sys_archive_detail` (
  `id` varchar(32) NOT NULL  COMMENT '档案详细ID',
  `attachment_url` varchar(128) COMMENT '附件文件',
  `attachment_name` varchar(128) COMMENT '附件名字',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `sys_rules_file`;
CREATE TABLE `sys_rules_file` (
  `id` varchar(32) NOT NULL  COMMENT '制度附件ID',
  `file_url` varchar(128) NOT NULL  COMMENT '附件url',
  `file_name` varchar(32) COMMENT '附件名称',
  `rules_id` varchar(32) NOT NULL  COMMENT '制度ID',
  `gmt_update` timestamp(0) NOT NULL  DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `gmt_create` timestamp(0) NOT NULL  DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
