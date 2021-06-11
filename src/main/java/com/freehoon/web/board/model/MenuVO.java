package com.freehoon.web.board.model;

import lombok.Data;

@Data
public class MenuVO {
	private int mid;
	private String code; 
	private String codename; 
	private int sort_num; 
	private String comment; 
	private String reg_id; 
	private String reg_dt;
}
