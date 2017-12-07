package gof;

public class Cell {
	private boolean status;
	
	public Cell(boolean status) {
		this.status = status;
	}

	public boolean isAlive() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
