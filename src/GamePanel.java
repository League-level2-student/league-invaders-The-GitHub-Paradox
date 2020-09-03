import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    Timer frameDraw;
    int currentState = MENU;
    Font titleFont = new Font("Arial", Font.PLAIN, 36);
    public void GamePanel() {
        frameDraw = new Timer(1000/60,this);
        frameDraw.start();
    }
    public void updateMenuState() {
    	
    }
    public void updateGameState() {
    	
    }
    public void updateEndState()  {
    	
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

}
