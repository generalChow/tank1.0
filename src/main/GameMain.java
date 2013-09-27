package main;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import tank.Hero;
import tank.weapon.Bullet;
import util.Constant;
import util.Panel;

public class GameMain extends KeyAdapter {

	private Panel p;
	private JFrame jf;
	private long  mills=0;

	public JFrame getJf() {
		return jf;
	}

	public void setJf(JFrame jf) {
		this.jf = jf;
	}

	public Panel getP() {
		return p;
	}

	public void setP(Panel p) {
		this.p = p;
	}

	public static void main(String a[]) {
		GameMain g = new GameMain();
		g.jf.addKeyListener(g);

	}

	@Override
	public void keyPressed(KeyEvent key) {// 由于panel的线程是睡眠50毫秒再重画，所以只要不断改变xy，感觉就会动起来
		// TODO Auto-generated method stub
		// super.keyPressed(key);
		// left 37,up 38,right 39,down 40,空格键 32
		
		long timeTemp = System.currentTimeMillis();
		
		Hero h1;
		Bullet b;
		if (key.getKeyCode() >= KeyEvent.VK_LEFT
				&& key.getKeyCode() <= KeyEvent.VK_DOWN) {
			this.getP().getH1().setDir(key.getKeyCode());
			this.getP().getH1().move();

		} else if (key.getKeyCode() == 32) {
			if (this.getP().getH1().getBullets().size() > 0&&((timeTemp-this.mills>500||this.mills==0))) {
				b = this.getP().getH1().getBullets().get(0);
				h1 = this.getP().getH1();
				b.setPower(10);
				b.setX(h1.getX());
				b.setY(h1.getY());
				b.setR(5);
				b.setDir(h1.getDir());
				b.setSpeed(2);
				this.getP().getHb().add(b);
				this.p.getH1().getBullets().remove(0);
				this.mills=timeTemp;
			} else if(this.getP().getH1().getBullets().size()==0) {
				
				System.out.println("弹夹没有子弹了");
			}
		}else if(key.getKeyChar()=='u'||key.getKeyChar()=='U'){
			this.p.getH1().reloadBullet();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyReleased(e);
	}

	public GameMain() {
		// TODO Auto-generated constructor stub
		this.p = new Panel(Constant.getEnemyNum());
		this.jf = new JFrame();
		this.jf.setLayout(null);
		this.jf.add(this.p);
		this.jf.setVisible(true);
		this.jf.setSize(500, 500);
		this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.jf.setBackground(Color.black);
		// this.jf.setResizable(false);
		new Thread(p).start();

	}

}
