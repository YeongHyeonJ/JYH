package day10;


class Board{
	private String title, contents, date ,writer ;
	private int num, views; 

	public Board(String title, String contents, String date, String writer, int num) {
		
		this.title = title;
		this.contents = contents;
		this.date = date;
		this.writer = writer;
		this.num = num;
	}
	public void modify(String title, String contents) {
		this.title = title; this.contents = contents ;
	}
	public void print() {
		System.out.println("게시글 번호 : " + num);
		System.out.println("게시글 제목 : " + title);
		System.out.println("게시글 내용 : " + contents);
		System.out.println("게시글 작성자 : " + writer);
		System.out.println("게시글 작성일 : " + date);
		System.out.println("조회수 : " + views);
	}
	
	//조회수 1 증가하는 기능
	public void updateViews() {
		views++;
	}
}