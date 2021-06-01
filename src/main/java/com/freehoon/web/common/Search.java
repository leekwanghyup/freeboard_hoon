package com.freehoon.web.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Search extends Pagination{

	private String searchType; 
	private String keyword; 
}
