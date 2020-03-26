package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	HashMap<Integer, String> h = new HashMap<Integer, String>();
	JFrame window = new JFrame("Log Search");
	JPanel panel = new JPanel();
	JButton add = new JButton("Add Entry");
	JButton search = new JButton("Search by ID");
	JButton view = new JButton("View List");
	JButton remove = new JButton("Remove Entry");
	
	public static void main(String[] args) {
		new _02_LogSearch().run();
	}
	
	void run() {
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(add);
		panel.add(search);
		panel.add(view);
		panel.add(remove);
		window.add(panel);
		window.pack();
		add.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource();
		if(b.equals(add)) {
			int a = Integer.parseInt(JOptionPane.showInputDialog("Please enter an ID number"));
			String s = JOptionPane.showInputDialog("Please enter a name");
			h.put(a, s);
		}
		if(b.equals(search)) {
			int a = Integer.parseInt(JOptionPane.showInputDialog("Please enter an ID number"));
			if(!h.containsKey(a)) {
				JOptionPane.showMessageDialog(null, "That ID does not exist");
			}
			else{
				for(int i : h.keySet()) {
					if(a == i) {
						JOptionPane.showMessageDialog(null, h.get(i));
						break;
					}
				}
			}
		}
		if(b.equals(view)) {
			String s = "";
			for(int i = 0; i < h.size(); i++) {
				s += "ID: " + h.keySet().toArray()[i] + "  Name: " + h.values().toArray()[i] + "\n";
			}
			JOptionPane.showMessageDialog(null, s);
		}
		if(b.equals(remove)) {
			int a = Integer.parseInt(JOptionPane.showInputDialog("Please enter an ID number"));
			if(!h.containsKey(a)) {
				JOptionPane.showMessageDialog(null, "That ID does not exist");
			}
			else {
				h.remove(a);
			}
		}
	}
}
