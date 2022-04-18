package group;

import java.util.List;

import UI.UML_Canvas;
import object.Element;
import object.GroupElements;

public class Group {
	protected UML_Canvas canvas = UML_Canvas.getInstance(); 
	protected List<Element> elements=canvas.getElementList();
	
	public void group() {
		GroupElements group = new GroupElements();
		for (int i = 0; i < this.elements.size(); i++) {
			Element element = this.elements.get(i);
			if (element.isSelected()) {
				group.addElement(element);
				this.elements.remove(i);
				i--;
			}
		}
		group.setBounds();
		this.elements.add(group);

	}
	
	public void ungroup() {
		GroupElements group = (GroupElements) this.canvas.getSelectObj();
		List<Element> groupElements = group.getElementList();
		for(int i = 0; i < groupElements.size(); i++){
			Element element = groupElements.get(i);
			this.elements.add(element);
		}
		this.elements.remove(this.canvas.getSelectObj());
	}
}
