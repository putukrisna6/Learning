package gameState;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import game.Commons;
import sprites.*;

@SuppressWarnings("serial")
public class Board extends JPanel {
	
	private Timer timer;
	private String message = "Game Over";
	
	// Sprite
	private Ball ball;
	private Paddle paddle;
	private Brick[] bricks;
	
	private boolean inGame = true;
	private int score = 0;
	
	private void initBoard() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				paddle.keyReleased(e);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				paddle.keyPressed(e);
			}
		});
		
		setFocusable(true);
		setPreferredSize(
					new Dimension(Commons.WIDTH, Commons.HEIGHT)
				);
		
		gameInit();
	}
	private void gameInit() {
		bricks = new Brick[Commons.N_OF_BRICKS];
		
		ball = new Ball();
		paddle = new Paddle();
		
		int k = 0;
		for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 6; j++) {
                bricks[k] = new Brick(
                				j * 40 + 30, i * 10 + 50
                			);
                k++;
            }
        }
		
		timer = new Timer(Commons.PERIOD, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doGameCycle();
			}
		});
		timer.start();
	}
	private void doGameCycle() {
		ball.move();
		paddle.move();
		checkCollision();
		repaint();
	}
	private void stopGame() {
		inGame = false;
		timer.stop();
	}
	private void checkCollision() {
		if (ball.getRect().getMaxY() > Commons.BOTTOM_EDGE) {
			stopGame();
		}
		
		for (int i = 0, j = 0; i < Commons.N_OF_BRICKS; i++) {
			if (bricks[i].getIsDestroyed()) {
				j++;
			}
			if (j == Commons.N_OF_BRICKS) {
				message = "Victory";
				stopGame();
			}
		}
		
		// ball collides with paddle
		if (ball.getRect().intersects(paddle.getRect())) {
			int paddleLPos = (int) paddle.getRect().getMinX();
			int ballLPos = (int) ball.getRect().getMinX();
			
			int first = paddleLPos + 8;
			int second = paddleLPos + 16;
            int third = paddleLPos + 24;
            int fourth = paddleLPos + 32;
            
            if (ballLPos < first) {
            	ball.setXDir(-1);
            	ball.setYDir(-1);
            }
            if (ballLPos >= first && ballLPos < second) {
                ball.setXDir(-1);
                ball.setYDir(-1 * ball.getYDir());
            }
            if (ballLPos >= second && ballLPos < third) {
                ball.setXDir(0);
                ball.setYDir(-1);
            }
            if (ballLPos >= third && ballLPos < fourth) {
                ball.setXDir(1);
                ball.setYDir(-1 * ball.getYDir());
            }
            if (ballLPos > fourth) {
                ball.setXDir(1);
                ball.setYDir(-1);
            }
		}
		
		// ball collides with bricks
		for (int i = 0; i < Commons.N_OF_BRICKS; i++) {
			if ((ball.getRect()).intersects(bricks[i].getRect())) {

                int ballLeft = (int) ball.getRect().getMinX();
                int ballHeight = (int) ball.getRect().getHeight();
                int ballWidth = (int) ball.getRect().getWidth();
                int ballTop = (int) ball.getRect().getMinY();

                Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
                Point pointLeft = new Point(ballLeft - 1, ballTop);
                Point pointTop = new Point(ballLeft, ballTop - 1);
                Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

                if (!bricks[i].getIsDestroyed()) {

                    if (bricks[i].getRect().contains(pointRight)) {

                        ball.setXDir(-1);
                    } else if (bricks[i].getRect().contains(pointLeft)) {

                        ball.setXDir(1);
                    }

                    if (bricks[i].getRect().contains(pointTop)) {

                        ball.setYDir(1);
                    } else if (bricks[i].getRect().contains(pointBottom)) {

                        ball.setYDir(-1);
                    }

                    bricks[i].setIsDestroyed(true);
                    score++;
                }
            }
		}
	}
	private void drawObjects(Graphics2D g2d) {
		g2d.drawImage(ball.getImage(), ball.getX(), ball.getY(),
                ball.getImageWidth(), ball.getImageHeight(), this);
        g2d.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(),
                paddle.getImageWidth(), paddle.getImageHeight(), this);

        for (int i = 0; i < Commons.N_OF_BRICKS; i++) {

            if (!bricks[i].getIsDestroyed()) {

                g2d.drawImage(bricks[i].getImage(), bricks[i].getX(),
                        bricks[i].getY(), bricks[i].getImageWidth(),
                        bricks[i].getImageHeight(), this);
            }
        }
        
        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(score), 10, 30);
	}
	private void gameFinished(Graphics2D g2d) {
		Font font = new Font("Verdana", Font.BOLD, 18);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString(message,
                (Commons.WIDTH - fontMetrics.stringWidth(message)) / 2,
                Commons.WIDTH / 2);
	}
	
	public Board() {
		initBoard();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
		
		if (inGame) {
			drawObjects(g2d);
		}
		else {
			gameFinished(g2d);
		}
		
		Toolkit.getDefaultToolkit().sync();
	}
}
