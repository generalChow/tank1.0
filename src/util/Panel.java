package util;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import tank.Enemy;
import tank.Hero;
import tank.Tank;
import tank.weapon.Bullet;

public class Panel extends JPanel implements Runnable {

	private Hero h1;
	private List<Bullet> hb;// Ӣ�۵��ӵ�
	private List<Enemy> enemyList;// �о�̹��
	private List<Bullet> eb;// �о����ӵ�

	public List<Bullet> getEb() {
		return eb;
	}

	public void setEb(List<Bullet> eb) {
		this.eb = eb;
	}

	public List<Enemy> getEnemyList() {
		return enemyList;
	}

	public void setEnemyList(List<Enemy> enemyList) {
		this.enemyList = enemyList;
	}

	public List<Bullet> getHb() {
		return hb;
	}

	public void setHb(List<Bullet> hb) {
		this.hb = hb;
	}

	public Hero getH1() {
		return h1;
	}

	public void setH1(Hero h1) {
		this.h1 = h1;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		setNextSatusXy();
		drawHero(g, h1);
		drawMyBullet(g);
		drawEBs(g);
		drawEnemies(g);

	}

	public void drawHero(Graphics g, Tank h) {

		g.setColor(h.getColor());
		switch (h.getDir()) {
		case 38:// ��������
			g.fill3DRect(h.getX(), h.getY(), 5, 30, false);
			g.fill3DRect(h.getX() + 15, h.getY(), 5, 30, false);
			g.fill3DRect(h.getX() + 5, h.getY() + 5, 10, 20, false);
			g.fillOval(h.getX() + 6, h.getY() + 11, 8, 8);
			g.drawLine(h.getX() + 10, h.getY() + 15, h.getX() + 10, h.getY());
			break;
		case 39:// right
			g.fill3DRect(h.getX(), h.getY(), 30, 5, false);
			g.fill3DRect(h.getX(), h.getY() + 15, 30, 5, false);
			g.fill3DRect(h.getX() + 5, h.getY() + 5, 20, 10, false);
			g.fillOval(h.getX() + 11, h.getY() + 6, 8, 8);
			g.drawLine(h.getX() + 15, h.getY() + 10, h.getX() + 30,
					h.getY() + 10);
			break;
		case 40:// down
			g.fill3DRect(h.getX(), h.getY(), 5, 30, false);
			g.fill3DRect(h.getX() + 15, h.getY(), 5, 30, false);
			g.fill3DRect(h.getX() + 5, h.getY() + 5, 10, 20, false);
			g.fillOval(h.getX() + 6, h.getY() + 11, 8, 8);
			g.drawLine(h.getX() + 10, h.getY() + 15, h.getX() + 10,
					h.getY() + 30);
			break;
		case 37:// left
			g.fill3DRect(h.getX(), h.getY(), 30, 5, false);
			g.fill3DRect(h.getX(), h.getY() + 15, 30, 5, false);
			g.fill3DRect(h.getX() + 5, h.getY() + 5, 20, 10, false);
			g.fillOval(h.getX() + 11, h.getY() + 6, 8, 8);
			g.drawLine(h.getX() + 15, h.getY() + 10, h.getX(), h.getY() + 10);
			break;
		default:
			break;
		}
	}

	public void drawMyBullet(Graphics g) {
		//setMyNextBulletXy();
		if (this.hb.size() > 0) {
			Bullet b;
			for (int i = 0; i < this.hb.size(); i++) {
				b = this.hb.get(i);
				g.setColor(Color.BLUE);
				g.fill3DRect(b.getX(), b.getY(), b.getR(), b.getR(), false);
			}
		}
	}

	public void drawEnemies(Graphics g) {
		//setEnemiesStatus();// ������һ�� �о�̹��xy
		Enemy e;
		for (int i = 0; i < this.enemyList.size(); i++) {
			e = this.enemyList.get(i);
			if (e.getLife() > 0) {
				drawHero(g, e);
			} else {
				this.enemyList.remove(i);
			}
		}
	}

	/**
	 * �����о����ӵ�
	 * 
	 * @param g
	 */
	public void drawEBs(Graphics g) {
		//setEnemiesBulletXy();
		Bullet b;
		for (int i = 0; i < this.eb.size(); i++) {
			b = this.eb.get(i);
			if (b.isUse()) {
				g.fill3DRect(b.getX(), b.getY(), b.getR(), b.getR(), false);
				g.setColor(this.eb.get(i).getColor());
			} else {
				// this.eb.remove(b);
			}
		}
	}

	public void setNextBulletXy() {

	}

	public void setMyNextBulletXy() {

		for (int i = 0; i < hb.size(); i++) {
			if (hb.get(i).Cross()||!hb.get(i).isUse()) {
				hb.remove(hb.get(i));
				System.out.println("ɾ��һ���ӵ�");
				// System.out.println("��ʣ��"+hb.size());
			} else {	
				
				for(int j =0;j<this.enemyList.size();j++){
					hb.get(i).hitTank(this.enemyList.get(j));
				}
				hb.get(i).move();	
				}

			}
		}
	

	public void setEnemiesBulletXy() {
		for (int i = 0; i < this.eb.size(); i++) {
			if (this.eb.get(i).Cross()) {
				this.eb.remove(this.eb.get(i));
				// System.out.println("�о�ɾ��һ���ӵ�");
				// System.out.println("��ʣ��"+hb.size());
			} else {
				this.eb.get(i).move();
			}
		}
	}

	public Panel(int enemyNum) {
		// TODO Auto-generated constructor stub
		this.h1 = new Hero(0, 0, 38, 3, Color.CYAN, 30);
		this.setSize(Constant.getPwithd(), Constant.getPhieght());
		this.setBackground(Color.black);
		System.out.println(this.getHeight());
		this.hb = new ArrayList<Bullet>();
		this.enemyList = new ArrayList<Enemy>();
		this.eb = new ArrayList<Bullet>();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {
			try {
				Thread.sleep(50);

				repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * ����run��ʱ��ĵо�̹�˵���һ��״̬
	 */
	public void setEnemiesStatus() {
		// TODO Auto-generated method stub
		Enemy e;
		for (int i = 0; i < this.enemyList.size(); i++) {

			e = this.enemyList.get(i);
			e.move();
			if (e.isFire()) {
				Bullet bullet = new Bullet();
				this.eb.add(e.shootOne(bullet, Color.green, 5, 5, 6));
			}
		}

	}
	
	public void setNextSatusXy(){
		setEnemiesBulletXy();
		setMyNextBulletXy();
		setEnemiesStatus();
	}

}
