package _03_IntroToStacks;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	JFrame window = new JFrame("Text Editor");
	JLabel label = new JLabel("");
	String s;
	Stack<Character> c = new Stack<Character>();
	Stack<Character> d = new Stack<Character>();
	
	public static void main(String[] args) {
		new _02_TextUndoRedo().run();
	}
	void run(){
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setMinimumSize(new Dimension(300,400));
		window.setMaximumSize(new Dimension(300,400));
		window.setLocation(1000, 600);
		window.add(label);
		window.addKeyListener(this);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE && c.size() > 0) {
			char x = c.pop();
			d.push(x);
			s = "";
			for(int i = 0; i < c.size(); i++) {
				s += c.get(i);
			}
			label.setText(s);
			window.pack();
		}
		if(e.getKeyCode() == KeyEvent.VK_Z && e.isControlDown() && d.size() > 0) {
			char x = d.pop();
			c.push(x);
			s = "";
			for(int i = 0; i < c.size(); i++) {
				s += c.get(i);
			}
			label.setText(s);
			window.pack();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE && !e.isControlDown()) {
			Character a = e.getKeyChar();
			s = "";
			c.push(a);
			for(int i = 0; i < c.size(); i++) {
				s += c.get(i);
			}
			label.setText(s);
			window.pack();
		}
	}
}
