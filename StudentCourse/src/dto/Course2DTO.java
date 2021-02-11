package dto;

public class Course2DTO {
	private int pnumber2;
	private String teacher2;
	private String sub2;
	private String time2;
	private String classroom2;
	private String pfile2;
	
	public int getPnumber2() {
		return pnumber2;
	}
	public void setPnumber2(int pnumber2) {
		this.pnumber2 = pnumber2;
	}
	public String getTeacher2() {
		return teacher2;
	}
	public void setTeacher2(String teacher2) {
		this.teacher2 = teacher2;
	}
	public String getSub2() {
		return sub2;
	}
	public void setSub2(String sub2) {
		this.sub2 = sub2;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public String getClassroom2() {
		return classroom2;
	}
	public void setClassroom2(String classroom2) {
		this.classroom2 = classroom2;
	}
	public String getPfile2() {
		return pfile2;
	}
	public void setPfile2(String pfile2) {
		this.pfile2 = pfile2;
	}
	@Override
	public String toString() {
		return "Course2DTO [pnumber2=" + pnumber2 + ", teacher2=" + teacher2 + ", sub2=" + sub2 + ", time2=" + time2
				+ ", classroom2=" + classroom2 + ", pfile2=" + pfile2 + "]";
	}
	
	
}