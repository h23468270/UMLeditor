package menufunc;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UI.UML_Canvas;

public class ChangeNameListener implements ActionListener {
	private UML_Canvas canvas=new UML_Canvas();
	public void actionPerformed(ActionEvent e) {
		this.canvas=UML_Canvas.getInstance();
		if(this.canvas.getSelectObj() != null ) {
			
			final JFrame inputTextFrame = new JFrame("Change Object Name");
			inputTextFrame.setSize(300, 80);
			inputTextFrame.getContentPane().setLayout(new GridLayout(1, 1));
			
			JPanel panel = null;
			panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			
			final JTextField NameText =  new JTextField(canvas.getSelectObj().getObjectName());
			
			panel.add(NameText);
			inputTextFrame.getContentPane().add(panel);
			
			JButton OK = new JButton("OK");
			panel.add(OK);
			
			JButton cancel = new JButton("Cancel");
			panel.add(cancel);

			inputTextFrame.getContentPane().add(panel);
			
			inputTextFrame.setLocationRelativeTo(null);
			inputTextFrame.setVisible(true);
			
			OK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					canvas.changeObjName(NameText.getText());
					inputTextFrame.dispose();
				}
			});
			
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inputTextFrame.dispose();
				}
			});	

		}
		else
		{
			JOptionPane.showMessageDialog(null,"Please select one and only one object.","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}