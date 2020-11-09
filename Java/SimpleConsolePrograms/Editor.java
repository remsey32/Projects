import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import acm.program.Program;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: Editor
 * 
 * A Swing program that allows you to read and write files.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Sven Remy
 */

public class Editor extends Program {
	public static void main(String[] args) {
		new Editor().start(args);
	}

	private JTextArea display;
	private JTextField tfFileName;
	private JButton btnOpen;
	private JButton btnSave;

	public void init() {
		setSize(300, 300);
		tfFileName = new JTextField(10);
		tfFileName.setFont(new Font("Courier", Font.BOLD, 18));
		add(tfFileName, SOUTH);

		btnOpen = new JButton("Open");
		add(btnOpen, SOUTH);

		btnSave = new JButton("Save");
		add(btnSave, SOUTH);

		display = new JTextArea();
		display.setFont(new Font("Courier", Font.BOLD, 18));
		add(display, CENTER);

		addActionListeners();
	}

	public void actionPerformed(ActionEvent e) {
		// your code goes here...
		if (e.getSource() == btnOpen) {
			// openFile();
		}
		
		if (e.getSource() == btnSave) {
			// saveFile();
		}
	}

	private void saveFile(String fileName) {
		try {
			// open file
			FileWriter fw = new FileWriter(tfFileName.getText(), false);

			// write to file
			String text = display.getText();
			StringTokenizer st = new StringTokenizer(text, "\n");
			while (st.hasMoreTokens()) {
				fw.write(st.nextToken() + "\n");
			}

			// close file
			fw.close();

		} catch (Exception e) {
			println("An error occurred!");
		}
	}

	private void openFile(String fileName) {
		try {
			// open file
			FileReader fr = new FileReader(tfFileName.getText());
			BufferedReader rd = new BufferedReader(fr);

			// read from file, line by line
			String text = "";
			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				text += line + "\n";
			}

			// close file
			rd.close();
			fr.close();

			// show file content
			display.setText(text);

		} catch (Exception e) {
			println("File does not exist!");
		}
	}
}
