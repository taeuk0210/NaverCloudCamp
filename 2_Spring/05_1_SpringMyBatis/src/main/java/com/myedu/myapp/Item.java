package com.myedu.myapp;

import lombok.Data;

@Data
public class Item {
	private int afos_fid;
	private String afos_id;
	private String bjd_cd;
	private String spot_cd;
	private String sido_sgg_nm;
	private String spot_nm;
	private int occrrnc_cnt;
	private int caslt_cnt;
	private int dth_dnv_cnt;
	private int se_dnv_cnt;
	private int sl_dnv_cnt;
	private int wnd_dnv_cnt;
	private String geom_json;
	private String lo_crd;
	private String la_crd;
}
