package dto;

import java.sql.*;

public class StudentDTO {
	private String id;
	private String pw;
	private String name;
	private String birth;
	private String gender;
	private String rank;
	private String ph;
	private String ad;
	
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", birth=" + birth + ", rank=" + rank
				+ ", gender=" + gender + ", ph=" + ph + ", ad=" + ad + "]";
	}
	
	
}
