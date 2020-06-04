package com.yc.shixun.nhres_2.bean;

import java.io.Serializable;

//序列化: 便于缓存   
public class Resfood implements Serializable {
	private Integer fid;
	private String fname;
	private Double normprice;
	private Double realprice;
	private String detail;
	private String fphoto;

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		System.out.println("*********由spring mvc完成参数的注入*****");
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Double getNormprice() {
		return normprice;
	}

	public void setNormprice(Double normprice) {
		this.normprice = normprice;
	}

	public Double getRealprice() {
		return realprice;
	}

	public void setRealprice(Double realprice) {
		this.realprice = realprice;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getFphoto() {
		return fphoto;
	}

	public void setFphoto(String fphoto) {
		this.fphoto = fphoto;
	}

}
