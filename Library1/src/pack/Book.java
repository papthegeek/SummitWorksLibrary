package pack;

import java.util.Date;

public class Book extends References{
	private int nbPages;
	 String publisher;
	 private int nbExample;
	 private int nbAvailable;


	 public int getNbPages() {
		return nbPages;
	}
	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String editor) {
		this.publisher = editor;
	}
	public int getNbExample() {
		return nbExample;
	}
	public void setNbExample(int nbExample) {
		this.nbExample = nbExample;
	}
	public int getNbAvailable() {
		return nbAvailable;
	}
	public void setNbAvailable(int nbAvailable) {
		this.nbAvailable = nbAvailable;
	}

}
