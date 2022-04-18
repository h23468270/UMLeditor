package object;

import java.awt.Color;
import javax.swing.JButton;
import mode.Mode;



public class ToolButton extends JButton{
	public Mode modetype = null;
	public String name = new String();
	
	public ToolButton(String name,Mode mode) {
		this.modetype=mode;
		this.setBackground(Color.white);
		this.setSize(100,100);
		this.setText(name);
		this.name=name;
	}
	public String getBtnName(){
		return this.name;
	}
	public Mode getMode(){
		return this.modetype;
	}
	public void OnClick() {
		this.setBackground(Color.gray);
	}
	public void DisOnClick() {
		this.setBackground(Color.white);
	}
	
	
	
}
