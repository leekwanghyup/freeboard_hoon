package com.freehoon.web.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReplyVO {
	
	private Long rid; 
	private Long bid; 
	private String content; 
	private String reg_id; 
	private String reg_dt; 
	private String edit_dt;
}
