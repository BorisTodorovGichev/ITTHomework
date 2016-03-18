package biblioteka;

import java.util.Comparator;

public class TextBook extends ReadingMaterial{
	private String author;
	

	@Override
	public String toString() {
		return "TextBook [author=" + author + ", getName()=" + getName()
				+ ", getPublisher()=" + getPublisher() + "]";
	}

	public TextBook(String author,String name, String publisher ) {
		super(name, publisher);
		this.setAuthor(author);
	}

	@Override
	public int getTime() {
		return 1500;
	}

	@Override
	public double getPrice() {
		return 3.0d;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	

	@Override
	public Comparator getComarator() {
		
		return new Comparator<TextBook>() {

			@Override
			public int compare(TextBook o1, TextBook o2) {
				
				return o1.getName().compareTo(o2.getName());
			}
		};
	}

}