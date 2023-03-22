package UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.EventListener;

//import javax.swing.JLabel;
import javax.swing.JPanel;

import mode.Mode;
import object.Element;
import object.Line;


public class UML_Canvas extends JPanel{
	
	private static UML_Canvas instance = null;
	private Mode modetype;
	private EventListener listener;
	//private String modename;
	private ArrayList<Element> elements = new ArrayList<Element>();
	private Element selectObj = null;
	private Rectangle zone = new Rectangle();
	private Line line = null;
	//public JLabel testlabel=new JLabel("start");
	
	public UML_Canvas() {
	}
	
	public static UML_Canvas getInstance() {
		if (instance == null) {
			instance = new UML_Canvas();
		}
		return instance;
	}
	
	public void setModetype(Mode mode) {
		this.modetype=mode;
	}
	
//	public void setModeName(String name) {
//		this.modename=name;
//	}
	
	public void setSelectObj(Element e) {
		this.selectObj = e;
	}
	
	public void setZoneBounds(int x, int y, int width, int height) {
		this.zone.setBounds(x, y, width , height);
	}
	
	public void setZoneSize(int width, int height) {
		this.zone.setSize(width , height);
	}
	
	public void setLine(Line line) {
		this.line=line;
	}
	
	
	public void reloadMode() {
		//System.out.println("setMode "+this.modename);
		this.removeMouseListener((MouseListener) this.listener);
		this.removeMouseMotionListener((MouseMotionListener) this.listener);
		this.listener = this.modetype;
		this.addMouseListener((MouseListener) this.listener);
		this.addMouseMotionListener((MouseMotionListener) this.listener);
	}
	
	public void checkselectObj() {
		int check=0;
		Element tmp=null;
		
		for (int i = this.elements.size() - 1; i >= 0; i--) {
			Element element = this.elements.get(i);
			if(element.isSelected()){
				check++;
				if(check == 1){
					tmp = element;
				}
				else{
					tmp = null;
				}
			}
		}
		
		this.selectObj=tmp;
	}
	
	
	public void reset() {
		if (this.selectObj != null) {
			this.selectObj = null;
		}
		this.zone.setBounds(0, 0, 0, 0); // reset canvas
	}
	
	public void resetElementListInSelect() {
		for (int i = this.elements.size() - 1; i >= 0; i--) {
			Element element = this.elements.get(i);
			if (!this.zone.isEmpty()) {
				if (!checkZone(element)) {
					element.setUnselected();
				}
			}
		}
	}
	
	public void resetElementList() {
		for (int i = this.elements.size() - 1; i >= 0; i--) {
			Element element = this.elements.get(i);
			element.setUnselected();
		}
	}
	
	public void resetSelectObj() {
		this.selectObj = null;
	}

	public void changeObjName(String name) {
		if(this.selectObj != null){
			this.selectObj.changeName(name);
			this.repaint();
		}
	}

	public boolean checkZone(Element element) {
		Point P1 = new Point(element.getP1());
		Point P2 = new Point(element.getP2());
		if (this.zone.contains(P1) && this.zone.contains(P2)) {
			return true;
		}
		return false;
	}
	
	public void addElement(Element element) {
		this.elements.add(element);
	}
	
	public ArrayList<Element> getElementList(){
		return this.elements;
	}
	
	public Element getSelectObj() {
		return this.selectObj;
	}
	
	public Rectangle getZone() {
		return this.zone;
	}
	
	public int getSelectNum() {
		int num = 0;
		for (int i = this.elements.size() - 1; i >= 0; i--) {
			Element element = this.elements.get(i);
			if(element.isSelected()){
				num++;
			}
		}
		return num;
	}
	
	public void paint(Graphics g) {		
		Dimension dim = this.getSize();
		g.setColor(Color.white);
		g.fillRect(0, 0, dim.width, dim.height);
		g.setColor(Color.black);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		
		// paint all elements
		for (int i = 0 ; i < this.elements.size(); i++) {
			Element element = this.elements.get(i);
			element.draw(g);
			if (!this.zone.isEmpty()) {
				if (checkZone(element)) {
					element.setSelected();
				}
			}
			if(element.isSelected()){
				element.show(g);
			}
		}
		
		// paint line
		if (this.line != null) {
			this.line.draw(g);
		}
		
		// paint area of group selection
		if (!this.zone.isEmpty()) {
			int alpha = 50;
			g.setColor(new Color(0, 0, 255, alpha));
			g.fillRect(this.zone.x, this.zone.y, this.zone.width, this.zone.height);
			g.setColor(new Color(0, 0, 255));
			g.drawRect(this.zone.x, this.zone.y, this.zone.width, this.zone.height);
		}
	
	}

	
}
