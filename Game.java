package gof;

import static gof.Constants.*;

public class Game {
	private World world;
	private int cycles;
	private Cell[][] newCells;
	private int alives;
	
	public Game(World world) {
		this.world = world;
		this.cycles = 0;
	}
	
	public void cycle() {
		this.cycles++;
		this.alives = 0;
		Cell[][] cells = this.world.getCells();
		this.newCells = new Cell[GRID_WIDTH][GRID_HEIGHT];
		for(int i = 0; i<GRID_WIDTH; i++) {
			for(int j = 0; j<GRID_HEIGHT; j++) {
				int n = this.countNeighbours(cells, i, j);
				if(cells[i][j].isAlive()) {
					if(n<UNDERPOPULAION || n>OVERPOPULAION) {
						this.newCells[i][j] = new Cell(false); //under and overpopulation
					} else {
						this.newCells[i][j] = new Cell(true);  //survives
						this.alives++;
					}
				} else {
					if(n==3) {
						this.newCells[i][j] = new Cell(true);  //reproduction 
						this.alives++;
					} else {
						this.newCells[i][j] = new Cell(false); //remains dead
					}
				}
			}
		}
		this.world.setCells(this.newCells);	
	}
	
	public int getCycles() {
		return cycles;
	}

	public int getAlives() {
		return alives;
	}

	private int countNeighbours(Cell[][] cells, int x, int y) {
		int acc = 0;
		for(int i = x-1; i<=x+1; i++) {
			for(int j = y-1; j<=y+1; j++) {
				if(this.isNeighbourValid(x, y, i, j) && cells[i][j].isAlive()) acc++;
			}
		}
		return acc;
	}
	
	private boolean isNeighbourValid(int x, int y, int i, int j) {
		if(i<0 || i>=GRID_WIDTH) return false;
		if(j<0 || j>=GRID_HEIGHT) return false;
		if(i==x && j==y) return false;
		return true;
	}

}
