import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends gameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 10;
	    if (needImage) {
	        loadImage ("rocket.png");
	    }
	}
	public void draw(Graphics g) {
        if (gotImage) {
        	g.drawImage(image, x, y, width, height, null);
        } else {
        	g.setColor(Color.BLUE);
        	g.fillRect(x, y, width, height);
        }
	}
    public void right() {
        x+=speed;
        super.update();
    }
    public void left() {
        x-=speed;
        super.update();
    }
    public void up() {
        y-=speed;
        super.update();
    }
    public void down() {
        y+=speed;
        super.update();
    }
	public Projectile getProjectile() {
		// TODO Auto-generated method stub
		Projectile prj = new Projectile(x + width/2 - 3, y, 10, 10);
		return prj;
	}
}
