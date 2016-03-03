package tests;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import game.*;
import gamepieces.*;
import userDialog.*;
import javax.swing.*;

public class BoardTest {
	
	public static void main(String[] args) {
		
		Chessboard chessboard = new Chessboard();

//		player1Notice();
//		chessboard.moveGamepiece(findGamepiece(askForCurrentXCoordinate(), askForCurrentYCoordinate), askForNewXCoordinate(), askForNewYCoordinate());
		
		chessboard.startNewGame();
		
		
//		saveGame(gamepieces);
//		loadGame(gamepieces);
	}
	
	public static void player1Notice() {
		JOptionPane.showMessageDialog(null, "Player 1 it is your turn");
	}
	
	public static void player2Notice() {
		JOptionPane.showMessageDialog(null, "Player 2 it is your turn");
	}


	public static int askForCurrentXCoordinate() {
		String textX = JOptionPane.showInputDialog("Give the x value of the gamepiece you want to move");
		int x = Integer.parseInt(textX);
		return x;
	}
	
	public static int askForCurrentYCoordinate() {
		String textY = JOptionPane.showInputDialog("Give the y value of the gamepiece you want to move");
		int y = Integer.parseInt(textY);
		return y;
	}
	
	public static int askForNewXCoordinate() {
		String textX = JOptionPane.showInputDialog("Assign a new x value for the given gamepiece");
		int newX = Integer.parseInt(textX);
		return newX;
	}
	
	public static int askForNewYCoordinate() {
		String textY = JOptionPane.showInputDialog("Assign a new y value fot the given gamepiece");
		int newY = Integer.parseInt(textY);
		return newY;
	}
	
	
	public static void saveGame(Serializable object){
		
		try{
			FileOutputStream fos = new FileOutputStream("Test.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(object);
			oos.flush();
			oos.close();
			fos.close();
			System.out.println("Chessboard is saved in TestOutput.sav");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void loadGame(Serializable object){
		
		try{
			FileInputStream fis = new FileInputStream("Test.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			object = (Gamepiece) ois.readObject();
			ois.close();
			fis.close();
		}
		catch(IOException i){
			i.printStackTrace();
			return;
		}
		catch(ClassNotFoundException c){
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}
		
	}
	
}
