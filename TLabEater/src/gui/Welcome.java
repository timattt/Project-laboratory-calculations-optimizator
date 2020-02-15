/**
 * 
 */
package gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * @author timat
 *
 */
public class Welcome extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JButton new_file = new JButton("Create new source file");
	private JButton open_file = new JButton("Open existing source file");
	
	private JTextPane welcome_text = new JTextPane();
	private JTextPane author = new JTextPane();
	
	/**
	 * 
	 */
	public Welcome() {
		setLayout(new GridBagLayout());
		
		welcome_text.setBackground(null);
		welcome_text.setFont(new Font("Times new Roman", Font.BOLD, 20));
		welcome_text.setText("Laboratory calculations optimizator\nVersion alpha 1.1");
		welcome_text.setEditable(false);
		welcome_text.setFocusable(false);
		
		author.setBackground(null);
		//author.setFont(new Font("Times new Roman", Font.BOLD, 30));
		author.setText("Author timattt");
		author.setEditable(false);
		author.setFocusable(false);
		
		GridBagConstraints con = new GridBagConstraints();
		con.fill = GridBagConstraints.BOTH;
		con.gridx = 0;
		con.gridy = 1;
		con.weightx = 0.1;
		con.weighty = 0.1;
		con.insets.bottom = con.insets.top = con.insets.left = con.insets.right = 30;
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		
		buttons.add(new_file);
		buttons.add(open_file);
		
		add(buttons, con);
		
		con.gridy = 0;
		con.fill = GridBagConstraints.VERTICAL;
		add(welcome_text, con);
		
		con.gridy = 2;
		con.anchor = GridBagConstraints.PAGE_END;
		con.fill = GridBagConstraints.VERTICAL;
		add(author, con);

		new_file.addActionListener(this);
		open_file.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == new_file) {
			GUI.createSourceFile();
		}
		if (e.getSource() == open_file) {
			GUI.openSourceFile();
		}
	}

}