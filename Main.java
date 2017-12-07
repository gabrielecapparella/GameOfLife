package gof;

import static java.awt.event.KeyEvent.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main{
	
	public static void main(String[] args) {
		World world = new World();
		Game game = new Game(world);
		GUI gui = new GUI(world);
		
		gui.getJframe().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {

				case VK_SPACE:
					game.cycle();
					System.out.println(game.getCycles()+") "+game.getAlives()+" alives.");
					gui.repaint();
					break;

				case VK_ESCAPE:
					gui.close();
					break;
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
	}

}
