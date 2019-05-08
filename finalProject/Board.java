package finalProject;
//scrrt in that foreign
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;


import java.awt.image.BufferedImage;


import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
//zoomin on that swing
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.net.URI;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.ArrayList;
import java.util.Scanner;
public class Board extends JPanel implements ActionListener{
	private final int BOARDY = 800;
	private final int BOARDX = 800;
	private final int TDOTS = 400;
	private final int SDOTS = 40;
	private final int RPOS = 19;
	private int delay = 0;
	private int highScore;
	//position arays
	private final int x[] = new int[TDOTS];
	private final int y[] = new int[TDOTS];
	//apple x/y and dot variable
	private int dots;
	private int gamesPlayed = 0;
	private int applex;
	private int appley;
    //buttons
	private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;
    private boolean highS;
	//images and timers
	private Timer timer;
	private Timer t2;
	private Image ball;
	private Image apple;
	private Image head;
	private Image rage;
	
	ArrayList <Integer> score = new ArrayList<Integer>();
	private BufferedImage img , img2 , img3 , img4;
	private JButton b1 , b2 , b3;

	private void errorMessage(){
		inGame = false;
		System.exit(0);
	}
	private void intro(){
		JOptionPane.showMessageDialog(null 
				, "Welcome to my final project for term 1! \nHow bout a game of Squidward to celebrate?" 
				, "Squidward"
				, JOptionPane.PLAIN_MESSAGE);
		int reply = JOptionPane.showConfirmDialog(null , "Do you know how to play Squidward?" , "" , JOptionPane.YES_NO_OPTION);
		if (reply != JOptionPane.YES_OPTION){
			JOptionPane.showMessageDialog(null, "\n1. Never let Squidward's head touch his body."
					+ "\n2. Never touch the boundaries of the screen."
					+ "\n3. The goal is to get to the Bold and Brash which, in turn, makes him longer." , "Rules" , JOptionPane.PLAIN_MESSAGE);
			setDiff();
		}else {
			setDiff();
		}
	}
	private void setDiff(){
		
		try{
			String fNum = 
					JOptionPane.showInputDialog("Enter your difficulty (1 - Recruit, 2 - Hardened, 3 - Veteran):");
			int x = Integer.parseInt(fNum);
				if (x == 1){
					delay = 100;
				}
				else if (x == 2){
					delay = 90;
				}
				else if (x == 3){
					delay = 80;
				}
			}catch(Exception exception){
				errorMessage();
			}
	}

	public Board(){
		inGame = true;
		intro();
		addKeyListener(new TAdapter());
	        setBackground(Color.black);
	        setFocusable(true);
	        setPreferredSize(new Dimension(BOARDX, BOARDY));
	        setBlocks();
	        //ready();
	        startGame();
	        checkCollision();
	       
	        if (!inGame){
	        	restart();
	        	squidwardsWrath();
	        }
	        
	}
	
	private void setBlocks(){

       try{ 
		
    	img = ImageIO.read(new File("/Users/espeland19289/Documents/workspace/APCompSci/src/res/squidb.png"));
        ball = img.getScaledInstance(SDOTS, SDOTS, Image.SCALE_DEFAULT);
        
        img2 = ImageIO.read(new File("/Users/espeland19289/Documents/workspace/APCompSci/src/res/bandb.png"));
        apple = img2.getScaledInstance(SDOTS, SDOTS, Image.SCALE_DEFAULT);
        
        img3 = ImageIO.read(new File("/Users/espeland19289/Documents/workspace/APCompSci/src/res/squid.jpg"));
        head = img3.getScaledInstance(SDOTS, SDOTS, Image.SCALE_DEFAULT);

       }catch (Exception exception){

       }
	}
	private void restart(){
		highScore();
		if (!inGame){
			if (!highS){
				int reply = JOptionPane.showConfirmDialog(null , "	Score: " + (dots - 3) + "\n	High Score: " + highScore + "\n	Restart?" , "You Died" , JOptionPane.YES_NO_OPTION);
				
					if(reply == JOptionPane.YES_OPTION){
						startGame();
					}else {
					System.exit(0);
					}
				
				}else{
					int reply = JOptionPane.showConfirmDialog(null , "	Score: " + (dots - 3) + "\n	High Score: " + highScore + "\n	Restart?" , "New High Score!" , JOptionPane.YES_NO_OPTION);
					
					if(reply == JOptionPane.YES_OPTION){
						startGame();
					}else {
						System.exit(0);
						}
				}
		}
		gamesPlayed++;
		
	}
	private void startGame(){
		inGame = true;
		dots = 3;
		for (int z = 0; z < dots; z ++){
			x[z] = BOARDX / 2;
			y[z] = BOARDY / 2;
		}
		
		getAppleLocation();
		
		timer = new Timer(delay, this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g){
		if (inGame) {
			super.paintComponent(g);
			
			doDrawing(g);
		}
	}
		private void doDrawing(Graphics g){
			if (inGame){
				g.drawImage(apple, applex , appley , this);
				//making sure every dot isnt the head
				for (int z = 0; z < dots; z++){
					if (z == 0) {
	                    g.drawImage(head, x[z], y[z], this);
	                } else {
	                    g.drawImage(ball, x[z], y[z], this);
	                }
				}
				
				Toolkit.getDefaultToolkit().sync();
			
			} else {
				
				gameOverMsg(g);
			}
		}
		//drawing the game over message
		private void gameOverMsg(Graphics g){

			String msg = "Game Over";
	        Font small = new Font("Helvetica", Font.BOLD, 28);
	        FontMetrics metr = getFontMetrics(small);

	        g.setColor(Color.white);
	        g.setFont(small);
	        g.drawString(msg, (BOARDX - metr.stringWidth(msg)) / 2, BOARDY / 2);
			
		}
		private void highScore(){
			highScore = 0;
			//if (!inGame){
				score.add((dots - 3));
				for (int i = 0; i < score.size(); i++){
					if (score.get(i) > highScore){
						highScore = score.get(i);
						highS = true;
					}else{
						highS = false;
					}
				}
			//}
		}
	    
	    private void squidwardsWrath(){
	    	try{
	    		Desktop desktop = java.awt.Desktop.getDesktop();
	    		URI oURL = new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
	    	}catch(Exception e){
	    		
	    	}
	    		
	    	
	    }
	    
		private void checkEaten(){
			if ((x[0] == applex) && (y[0] == appley)){

				dots++;
				getAppleLocation();
			}
		}
		
		/*private void ready(){
			int reply = JOptionPane.showConfirmDialog(null , "ready?" , "" , JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION){
				startGame();
			}else{
				errorMessage();
			}
		
		}*/
		private void move() {

			for (int z = dots; z > 0; z--) {
	            x[z] = x[(z - 1)];
	            y[z] = y[(z - 1)];
	        }

	        if (leftDirection) {
	            x[0] -= SDOTS;
	        }

	        if (rightDirection) {
	            x[0] += SDOTS;
	        }

	        if (upDirection) {
	            y[0] -= SDOTS;
	        }

	        if (downDirection) {
	            y[0] += SDOTS;
	        }
	        }
	    

	    private void checkCollision() {

	        for (int z = dots; z > 0; z--) {

	            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
	                inGame = false;
	            }
	        }

	        if (y[0] >= BOARDY) {
	            inGame = false;
	        }

	        if (y[0] < 0) {
	            inGame = false;
	        }

	        if (x[0] >= BOARDX) {
	            inGame = false;
	        }

	        if (x[0] < 0) {
	            inGame = false;
	        }
	        
	        if(!inGame) {
	            timer.stop();
	            restart();
	        }
	    }

	    private void getAppleLocation() {

	        int r = (int) (Math.random() * RPOS);
	        applex = ((r * SDOTS));

	        r = (int) (Math.random() * RPOS);
	        appley = ((r * SDOTS));
	        
	    }
	    //@Override
	    public void actionPerformed(ActionEvent e) {

	        if (inGame) {

	            checkEaten();
	            checkCollision();
	            move();
	        }

	        repaint();
	    }

	    private class TAdapter extends KeyAdapter {

	        @Override
	        public void keyPressed(KeyEvent e) {

	            int key = e.getKeyCode();
	            	//if left and not right
	            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
	                leftDirection = true;
	                upDirection = false;
	                downDirection = false;

	            }
	            	//if right and not left
	            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
	                rightDirection = true;
	                upDirection = false;
	                downDirection = false;

	            }
	            	//if up and not down
	            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
	                upDirection = true;
	                rightDirection = false;
	                leftDirection = false;
	                downDirection = false;

	            }
	            	//if down and not up
	            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
	                downDirection = true;
	                rightDirection = false;
	                leftDirection = false;
	                upDirection = false;
	            }
	        }
	    }
	}
