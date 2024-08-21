package com.aqua.order;

import lombok.Data;

@Data
public class OrderVO {
	private String oid;
	private String pid;
	private String pname;
	private int pprice;
	private String pimg;
	private int amount;
	private String username;
	
}