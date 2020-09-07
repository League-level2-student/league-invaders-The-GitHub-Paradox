import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame f;
	GamePanel gp;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
		public static void main(String[] args) {
			new LeagueInvaders().setup();
	}
	LeagueInvaders(){
		f = new JFrame(); 
		gp = new GamePanel();
		f.add(gp);
		f.addKeyListener(gp);
	}
	public void setup() {
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
