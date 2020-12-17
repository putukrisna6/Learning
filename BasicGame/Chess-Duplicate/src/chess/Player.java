package chess;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Player implements Serializable{

	private static final long serialVersionUID = 1L;
	private final String name;
	private int gamesPlayed;
	private int gamesWon;
	
	public Player(String name) {
		this.name = name.trim();
		this.gamesPlayed = 0;
		this.gamesWon = 0;
	}
	
	// getters
	public String getName() {
		return name;
	}
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	public int getGamesWon() {
		return gamesWon;
	}
	
	public int winPercentage() {
		return (gamesWon * 100) / gamesPlayed;
	}
	public void updateGamesPlayed() {
		gamesPlayed++;
	}
	public void updateGamesWon() {
		gamesWon++;
	}
	
	// method to get list of players
	public static ArrayList<Player> fetchPlayers() {
		Player tempPlayer;
		ObjectInputStream input = null;
		ArrayList<Player> players = new ArrayList<Player>();
		
		try {
			File infile = new File(System.getProperty("user.dir")
							+ File.separator + "chessgamedata.dat");
			input = new ObjectInputStream(
						new FileInputStream(infile)
					);
			try {
				while (true) {
					tempPlayer = (Player) input.readObject();
					players.add(tempPlayer);
				}
			}
			catch (EOFException e) {
				input.close();
			}
		}
		catch (FileNotFoundException e){
			players.clear();
			return players;
		}
		catch (IOException e) {
			e.printStackTrace();
			try {
				input.close();
			}
			catch (IOException e1) {}
			JOptionPane.showMessageDialog(
					null, "Unable to read gamedata");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(
					null, "gamedata corrupted, click ok to build new file");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return players;
	}
	
	public void updatePlayers() {
		ObjectInputStream input = null;
		ObjectOutputStream output = null;
		Player tempPlayer;
		File inputFile = null;
		File outputFile = null;
		
		try {
			inputFile = new File(
						System.getProperty("user.dir") +
						File.separator + "chessgamedata.dat"
					);
			outputFile = new File(
						System.getProperty("user.dir") +
						File.separator + "tempfile.dat"
					);
		}
		catch (SecurityException e) {
			JOptionPane.showMessageDialog(
					null, "Permission to Read-Write Denied");
			System.exit(0);
		}
		
		boolean playerDoNotExist;
		try {
			if (!outputFile.exists()) {
				outputFile.createNewFile();
			}
			if (!inputFile.exists()) {
				output = new ObjectOutputStream(
						new FileOutputStream(outputFile, true)
						);
				output.writeObject(this);
			}
			else {
				input = new ObjectInputStream(
							new FileInputStream(inputFile)
						);
				output = new ObjectOutputStream(
							new FileOutputStream(outputFile)
						);
				
				playerDoNotExist = true;
				
				try {
					while (true) {
						tempPlayer = (Player) input.readObject();
						if (tempPlayer.getName().equals(getName())) {
							output.writeObject(this);
							playerDoNotExist = false;
						}
						else {
							output.writeObject(tempPlayer);
						}
					}
				}
				catch (EOFException e) {
					input.close();
				}
				if (playerDoNotExist) {
					output.writeObject(this);
				}
			}
			inputFile.delete();
			output.close();
			
			File newf = new File(
						System.getProperty("user.dir") +
						File.separator + "chessgamedata.dat"
					);
			if (outputFile.renameTo(newf) == false) {
				System.out.println("Can't rename file");
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(
					null, "unable to read game data");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(
					null, "game data corrupt");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
