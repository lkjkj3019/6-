package dto;

public class CourseDTO {
	private int pnumber;
	private String teacher;
	private String sub;
	private String time;
	private String classroom;
	private String pfile;
	
	
	public int getPnumber() {
		return pnumber;
	}
	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}
	public String getPfile() {
		return pfile;
	}
	public void setPfile(String pfile) {
		this.pfile = pfile;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	@Override
	public String toString() {
		return "CourseDTO [pnumber=" + pnumber + ", teacher=" + teacher + ", sub=" + sub + ", time=" + time
				+ ", classroom=" + classroom + ", pfile=" + pfile + "]";
	}
	
	
}
