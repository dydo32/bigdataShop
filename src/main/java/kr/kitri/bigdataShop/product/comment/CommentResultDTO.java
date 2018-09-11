package kr.kitri.bigdataShop.product.comment;


public class CommentResultDTO {
	private String content;
	private int count;
	
	public CommentResultDTO() {}
	public CommentResultDTO(String content, int count) {
		super();
		this.content = content;
		this.count = count;
	}
	
	
	
	@Override
	public String toString() {
		return "ProductCommentWordDTO [content=" + content + ", count=" + count + "]";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
}
