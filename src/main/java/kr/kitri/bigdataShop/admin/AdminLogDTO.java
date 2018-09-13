package kr.kitri.bigdataShop.admin;

public class AdminLogDTO {
	String content;
	String count;
	public AdminLogDTO() {
	}
	public AdminLogDTO(String content, String count) {
		super();
		this.content = content;
		this.count = count;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "AdminLogDTO [content=" + content + ", count=" + count + "]";
	}
	
}
