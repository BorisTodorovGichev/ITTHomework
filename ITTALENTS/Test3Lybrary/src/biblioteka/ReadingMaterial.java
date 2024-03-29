package biblioteka;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class ReadingMaterial {
	private String name;
	private String publisher;
	private List<History> history;
	private boolean isTaken=false;

	public ReadingMaterial(String name, String publisher) {
		this.setName(name);
		this.setPublisher(publisher);
		this.history=new ArrayList<History>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.trim().length() == 0) {
			try {
				throw new RMException("Invalid name");
			} catch (RMException e) {		
				e.printStackTrace();
			}
		} else
			this.name=name;
			
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		if (publisher == null || publisher.trim().length() == 0) {
			try {
				throw new RMException("Invalid name");
			} catch (RMException e) {
				e.printStackTrace();
			}
		} else{
			this.publisher=publisher;
		}
			
	}


	public abstract int getTime();

	public abstract double getPrice();

	public abstract  Comparator getComarator();
	
	public boolean canBetaken(){
		return true;
	}
	
	public LocalDateTime getLastTakenTime(){
		return history.get(history.size()-1).getTakingTime();
	}
	
	
	public void takeIt(boolean taken){
		this.isTaken=taken;
		if (taken) {
		history.add(new History(LocalDateTime.now()));
			
			
		}
		else{
			history.get(history.size()-1).setReturningTime(LocalDateTime.now());
		}
		
		
	}

	public boolean isTaken() {
		return isTaken;
	}

	
	
}
