import java.util.ArrayList;
import java.util.Random;

public class objectManager {
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<>();
	ArrayList<Alien> aliens = new ArrayList<>();
	Random r = new Random();
	public objectManager(Rocketship rocket) {
		this.rocket = rocket;
	}
	public void addProjectile(Projectile projectile) {
		this.projectiles.add(projectile);
	}
	public void addAlien() {
		aliens.add(new Alien(r.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	public void update() {
		for(int i = 0; i < aliens.size(); i++) {
			aliens.get(i);
		}
	}
}
