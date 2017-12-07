package gof;

import static gof.Constants.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel {
	
	static final private long serialVersionUID = 0L;
	final private JFrame jframe;
	private int width;
	private int height;
	private World world;
	
	public GUI(World world) {
		this.width = GRID_WIDTH*CELL_DIM;
		this.height = GRID_HEIGHT*CELL_DIM;
		this.world = world;
		
		jframe = new JFrame("Game Of Life");		
		jframe.add(this);
		jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(this.width, this.height));
		jframe.pack();
		jframe.setVisible(true);
		
		//repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.fillRect(0, 0, this.width, this.height); //set background
		g.setColor(Color.white);
		Cell[][] cells = this.world.getCells();
		for(int i = 0; i<GRID_WIDTH; i++) {
			for(int j = 0; j<GRID_HEIGHT; j++) {
				drawCell(g, i*CELL_DIM, j*CELL_DIM, cells[i][j]);
			}
		}
		
	}

	private void drawCell(Graphics g, int i, int j, Cell cell) {
		if (cell.isAlive()) g.fillRect(i+1, j+1, 19, 19);
	}
	
	public JFrame getJframe() {
		return jframe;
	}
	
	public void close() {
		jframe.dispose();
	}

	

}
