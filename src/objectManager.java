import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class objectManager implements ActionListener {
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<>();
	ArrayList<Alien> aliens = new ArrayList<>();
	Random r = new Random();

	public objectManager(Rocketship rocket) {
		this.rocket = rocket;
	}

	public void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			for (int i1 = 0; i1 < projectiles.size(); i1++) {
				if (aliens.get(i).collisionBox.intersects(projectiles.get(i1).collisionBox)) {
					aliens.get(i).isActive = false;
					projectiles.get(i1).isActive = false;
				}
			}
		}
	}

	public void addProjectile(Projectile projectile) {
		this.projectiles.add(projectile);
	}

	public void addAlien() {
		aliens.add(new Alien(r.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	public void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if (aliens.get(i).y >= LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive = false;
			}
			for (int i1 = 0; i1 < projectiles.size(); i1++) {
				projectiles.get(i1).update();
				if (projectiles.get(i1).y <= 0) {
					projectiles.get(i1).isActive = false;
				}
			}
		}
		checkCollision();
		purgeObject();
	}

	public void draw(Graphics g) {
		rocket.draw(g);
		for (int i2 = 0; i2 < aliens.size(); i2++) {
			aliens.get(i2).draw(g);
		}
		for (int i3 = 0; i3 < projectiles.size(); i3++) {
			projectiles.get(i3).draw(g);
		}
	}

	public void purgeObject() {
		for (int i4 = 0; i4 < aliens.size(); i4++) {
			if (aliens.get(i4).isActive == false) {
				aliens.remove(i4);
			}
		}
		for (int i5 = 0; i5 < projectiles.size(); i5++) {
			if (projectiles.get(i5).isActive == false) {
				projectiles.remove(i5);
				
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
