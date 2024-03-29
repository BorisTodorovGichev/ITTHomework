package Task_1;

public class Computer {
	private int flag = 0;
	private int year = 0;
	private double price = 0;
	private boolean isNoteBook = false;
	private int hardDiskMemory = 0;
	private int freeMemory = this.hardDiskMemory;
	private String operationSystem = "";

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year > 0 && year < 2016) {
			this.year = year;
			return;

		}
		this.year = 2015;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
			return;
		}
		this.price = 0;
	}

	public boolean isNoteBook() {
		return isNoteBook;
	}

	public void setNoteBook(boolean isNoteBook) {
		if (flag == 0) {
			this.isNoteBook = isNoteBook;
			flag++;
			return;
		}
		return;
	}

	public int getHardDiskMemory() {
		return hardDiskMemory;
	}

	public void setHardDiskMemory(int hardDiskMemory) {
		if (hardDiskMemory > 0) {
			this.hardDiskMemory = hardDiskMemory;
			return;
		}
		this.hardDiskMemory = 0;
	}

	public String getOperationSystem() {
		return operationSystem;
	}

	public void setOperationSystem(String operationSystem) {
		if (operationSystem != null && operationSystem.length() != 0) {
			this.operationSystem = operationSystem;
			return;
		}
		this.operationSystem = "Undefined";

	}

	public int getFreeMemory() {
		return freeMemory;
	}

	public void setFreeMemory(int freeMemory) {
		if (freeMemory <= this.hardDiskMemory) {
			this.freeMemory = freeMemory;
		} else {
			System.out.println("Free memory exceeds hardDiskMemory");
		}
	}

	void changeOperationSystem(String newSystem) {
		if (newSystem.equals("") || newSystem.equals(null)
				|| newSystem.length() == 0) {
			return;
		} else {
			this.operationSystem = newSystem;

		}
	}

	void useMemory(int memoryInUse) {
		if (memoryInUse > this.freeMemory) {
			System.out.println("Not enough memory");
			return;
		}
		if (memoryInUse <= 0) {
			System.out.println("Please enter a valid value for memory in use");
			return;
		}

		this.freeMemory -= memoryInUse;

	}

}
