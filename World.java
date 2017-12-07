package gof;

import static gof.Constants.*;
import java.util.Random;

public class World {
	
	private Cell[][] cells;

	public World() {
		this.cells = new Cell[GRID_WIDTH][GRID_HEIGHT];
		this.populate();
	}

	private void populate() {
		Random rand = new Random();	
		for(int i=0; i<GRID_WIDTH; i++) {
			for(int j = 0; j<GRID_HEIGHT; j++) {					
				boolean status = false;
				double r = rand.nextDouble();
				if (r<=INITIAL_CHANGES) status = true;
				this.cells[i][j] = new Cell(status);
			}
		}
	}

	public Cell[][] getCells() {
		return this.cells;
	}
	
	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}

}
