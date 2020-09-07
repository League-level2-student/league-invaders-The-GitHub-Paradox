import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    Timer frameDraw;
    int currentState = MENU;
    Rocketship rs;
    Font titleFont = new Font("Arial", Font.PLAIN, 36);
    public GamePanel() {
        frameDraw = new Timer(1000/60,this);
        frameDraw.start();
    }
    public void updateMenuState() {
    	
    }
    public void updateGameState() {
    	
    }
    public void updateEndState() {
    	
    }
    public void drawMenuState(Graphics g) {  
    	g.setColor(Color.BLUE);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	g.setFont(titleFont);
    	g.setColor(Color.YELLOW);
    	g.drawString("League Invaders", 100, 100);
    	g.setFont(titleFont);
    	g.setColor(Color.YELLOW);
    	g.drawString("Press Enter to Start", 75, 400);
    	g.setFont(titleFont);
    	g.setColor(Color.YELLOW);
    	g.drawString("Press Space for Instructions", 15, 600);
    }
    public void drawGameState(Graphics g) {
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	
    }
    public void drawEndState(Graphics g)  {
    	g.setColor(Color.RED);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	g.setFont(titleFont);
    	g.setColor(Color.YELLOW);
    	g.drawString("GAME OVER", 120, 100);
    	g.setFont(titleFont);
    	g.setColor(Color.YELLOW);
    	g.drawString("You killed  enemies", 75, 400);
    	g.setFont(titleFont);
    	g.setColor(Color.YELLOW);
    	g.drawString("Press Enter to restart", 60, 600);
    }
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		System.out.println("action");
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
