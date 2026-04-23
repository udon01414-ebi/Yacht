package yacht;

import javax.swing.JButton;

public class ButtonInitialize extends JButton {

	public ButtonInitialize(int i) {
		JButton btn = new JButton(String.valueOf(i));
		btn.addActionListener(e -> {
			setEnabled(false);
		});
	}

}
