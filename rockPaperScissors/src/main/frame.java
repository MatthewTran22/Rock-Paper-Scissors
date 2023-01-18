package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class frame extends JFrame {

	private JPanel contentPane;
	private JPanel game;
	private JPanel gameOver;
	private CardLayout c;
	private JButton Rock;
	private	JButton Paper;
	private JButton Scissors;
	private JLabel result;
	private JLabel round;
	private JLabel playerPoints;
	private JLabel pcPoints;
	private JLabel titleEnd;
	private JLabel playerChoice;
	private JLabel pcChoice;
	private ImageIcon RockPNG;
	private ImageIcon PaperPNG;
	private ImageIcon ScissorsPNG;
	private int roundNum;
	private int playerPoint;
	private int pcPoint;
	private JButton retry;
	private JButton btnNewButton_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame frame = new frame();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		c = (CardLayout)(contentPane.getLayout());
		
		JPanel menu = new JPanel();
		contentPane.add(menu, "menu");
		menu.setLayout(null);
		
		game = new JPanel();
		contentPane.add(game, "game");
		game.setLayout(null);
		
		gameOver = new JPanel();
		contentPane.add(gameOver, "Game Over");
		gameOver.setLayout(null);
		
		
		//Game button setup
		RockPNG = new ImageIcon("/Users/matthew/eclipse-workspace/rockPaperScissors/Rock.png");
		Resize r = new Resize(RockPNG, 100, 100);
		RockPNG = r.modified();
		Rock = new JButton(RockPNG);
		Rock.setBounds(170, 427, 100, 100);
		game.add(Rock);
		
		PaperPNG = new ImageIcon("/Users/matthew/eclipse-workspace/rockPaperScissors/Paper.png");
		Resize p = new Resize(PaperPNG, 100, 100);
		PaperPNG = p.modified();
		Paper = new JButton(PaperPNG);
		Paper.setBounds(340, 427, 100, 100);
		game.add(Paper);
		
		ScissorsPNG = new ImageIcon("/Users/matthew/eclipse-workspace/rockPaperScissors/Scissors.png");
		Resize s = new Resize(ScissorsPNG, 100, 100);
		ScissorsPNG = s.modified();
		Scissors = new JButton(ScissorsPNG);
		Scissors.setBounds(510, 427, 100, 100);
		game.add(Scissors);
		
		//Image choice labels
		playerChoice = new JLabel();
		playerChoice.setBounds(170, 119, 100, 100);
		game.add(playerChoice);
		playerChoice.setVisible(false);
		pcChoice = new JLabel();
		pcChoice.setBounds(510, 119, 100, 100);
		game.add(pcChoice);
		pcChoice.setVisible(false);
		
		//Rounds and points
		result = new JLabel();
		result.setBounds(310, 119, 250, 16);
		game.add(result);
		round = new JLabel();
		round.setBounds(0, 0, 120, 16);
		game.add(round);
		playerPoints = new JLabel();
		playerPoints.setBounds(6, 50, 159, 16);
		pcPoints = new JLabel();
		pcPoints.setBounds(700, 50, 80, 16);
		menu.setLayout(null);
		runGame();
		
		//Game over screen setup
		retry = new JButton("Play Again");
		retry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerPoint = 0;
				pcPoint = 0;
				roundNum = 1;
				game.add(pcPoints);
				game.add(round);
				game.add(playerPoints);
				playerPoints.setText("Player Wins: " + playerPoint);
				pcPoints.setText("PC Wins: " + pcPoint);
				round.setText("Round " + roundNum);
				result.setText("");
				
				c.show(contentPane, "game");
			}
		});
		retry.setBounds(330, 210, 117, 29);
		gameOver.add(retry);
		
		btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(330, 250, 117, 29);
		gameOver.add(btnNewButton_3);
		titleEnd = new JLabel();
		titleEnd.setBounds(315, 184, 170, 16);
		gameOver.add(titleEnd);
		
		
		//Menu setup
		JLabel title = new JLabel("Rock Paper Scissors");
		title.setBounds(300, 24, 151, 16);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(title);
	
		
		JButton play = new JButton("Play");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerPoint = 0;
				pcPoint = 0;
				roundNum = 1;
				game.add(pcPoints);
				game.add(playerPoints);
				playerPoints.setText("Player Wins: " + playerPoint);
				pcPoints.setText("PC Wins: " + pcPoint);
				round.setText("Round " + roundNum);
				result.setText("");
				c.show(contentPane, "game");
			}
		});
		play.setBounds(315, 137, 117, 29);
		play.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(play);
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setBounds(315, 178, 117, 29);
		menu.add(exit);
		
		
	}
public void runGame() 
{		
	
	Rock.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Rock.setVisible(false);
			Paper.setVisible(false);
			Scissors.setVisible(false);
			playerChoice.setVisible(true);
			playerChoice.setIcon(RockPNG);
			PlayerPick rock = new PlayerPick("rock");
			String winner = rock.winner();
			pcChoice.setVisible(true);
			pcChoice.setIcon(rock.imageChoice(RockPNG, PaperPNG, ScissorsPNG));
			result.setText(winner);
			roundNum ++;
			pcPoint = rock.getPCPoint(winner, pcPoint);
			playerPoint = rock.getPlayerPoint(winner, playerPoint);
			round.setText("Round " + roundNum);
			playerPoints.setText("Player Wins: " + playerPoint);
			pcPoints.setText("PC Wins: " + pcPoint);
			
			ActionListener listener = new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					result.setText("");
					Rock.setVisible(true);
					Paper.setVisible(true);
					Scissors.setVisible(true);
					playerChoice.setVisible(false);
					pcChoice.setVisible(false);
					if (playerPoint >= 3 || pcPoint >= 3)
					{
						gameOver.add(playerPoints);
						gameOver.add(pcPoints);
						if (playerPoint >= 3)
						{
							titleEnd.setText("Game Over: YOU WIN!");
						}
						else 
						{
							titleEnd.setText("Game Over: YOU LOSE!");
						}
						c.show(contentPane, "Game Over");	
					}
					
				}
			};
			Timer timer = new Timer(2000, listener);
			timer.setRepeats(false);
			timer.start();
			
		}
	});
	
	
	
	Paper.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Rock.setVisible(false);
			Paper.setVisible(false);
			Scissors.setVisible(false);
			playerChoice.setVisible(true);
			playerChoice.setIcon(PaperPNG);
			PlayerPick paper = new PlayerPick("paper");
			String winner = paper.winner();
			pcChoice.setVisible(true);
			pcChoice.setIcon(paper.imageChoice(RockPNG, PaperPNG, ScissorsPNG));
			result.setText(winner);
			roundNum ++;
			round.setText("Round " + roundNum);
			pcPoint = paper.getPCPoint(winner, pcPoint);
			playerPoint = paper.getPlayerPoint(winner, playerPoint);
			round.setText("Round " + roundNum);
			playerPoints.setText("Player Wins: " + playerPoint);
			pcPoints.setText("PC Wins: " + pcPoint);
			
			ActionListener listener = new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					result.setText("");
					Rock.setVisible(true);
					Paper.setVisible(true);
					Scissors.setVisible(true);
					playerChoice.setVisible(false);
					pcChoice.setVisible(false);
					if (playerPoint >= 3 || pcPoint >= 3)
					{
						gameOver.add(playerPoints);
						gameOver.add(pcPoints);
						if (playerPoint >= 3)
						{
							titleEnd.setText("Game Over: YOU WIN!");
						}
						else 
						{
							titleEnd.setText("Game Over: YOU LOSE!");
						}
						c.show(contentPane, "Game Over");
					}

					
				}
			};
			Timer timer = new Timer(2000, listener);
			timer.setRepeats(false);
			timer.start();
			
		}
	});
	
	
	
	Scissors.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Rock.setVisible(false);
			Paper.setVisible(false);
			Scissors.setVisible(false);
			playerChoice.setVisible(true);
			playerChoice.setIcon(ScissorsPNG);
			PlayerPick scissors = new PlayerPick("scissors");
			String winner = scissors.winner();
			pcChoice.setVisible(true);
			pcChoice.setIcon(scissors.imageChoice(RockPNG, PaperPNG, ScissorsPNG));
			result.setText(winner);
			roundNum ++;
			round.setText("Round " + roundNum);
			pcPoint = scissors.getPCPoint(winner, pcPoint);
			playerPoint = scissors.getPlayerPoint(winner, playerPoint);
			round.setText("Round " + roundNum);
			playerPoints.setText("Player Wins: " + playerPoint);
			pcPoints.setText("PC Wins: " + pcPoint);
				
				ActionListener listener = new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						result.setText("");
						Rock.setVisible(true);
						Paper.setVisible(true);
						Scissors.setVisible(true);
						playerChoice.setVisible(false);
						pcChoice.setVisible(false);
						if (playerPoint >= 3 || pcPoint >= 3)
						{
							gameOver.add(playerPoints);
							gameOver.add(pcPoints);
							if (playerPoint >= 3)
							{
								titleEnd.setText("Game Over: YOU WIN!");
							}
							else 
							{
								titleEnd.setText("Game Over: YOU LOSE!");
							}
							c.show(contentPane, "Game Over");
						}

					}
				};
				Timer timer = new Timer(2000, listener);
				timer.setRepeats(false);
				timer.start();
				
		}
	});
}
}
