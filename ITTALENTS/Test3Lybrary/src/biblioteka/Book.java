package biblioteka;

import java.time.LocalDateTime;
import java.util.Comparator;

public class Book extends ReadingMaterial {

	private static final double PRICE = 2.0;
	private static final int READING_TIME = 3000;
	private String author;
	private LocalDateTime issueDate; 


	public Book(LocalDateTime issueDate,String author,String name, String publisher
			) {
		super(name, publisher);
		this.setAuthor(author);
		this.setIssueDate(issueDate);
	}

	@Override
	public double getPrice() {
		return PRICE;
	}

	@Override
	public int getTime() {
		return READING_TIME;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", issueDate=" + issueDate
				+ ", getName()=" + getName() + ", getPublisher()="
				+ getPublisher() + "]";
	}
	
	@Override
	public Comparator getComarator() {
		return new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				// TODO Auto-generated method stub
				return o2.getIssueDate().compareTo(o1.getIssueDate());
			}
			

		};
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}

}
