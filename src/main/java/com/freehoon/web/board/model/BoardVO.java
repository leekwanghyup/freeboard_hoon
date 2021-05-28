package com.freehoon.web.board.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardVO {

	private int bid; 
	private String cate_cd;
	private String title; 
	private String content; 
	private String tag; 
	private String view_cnt;
	private String reg_id; 
	private String reg_dt; 
	private String edit_dt;
}
