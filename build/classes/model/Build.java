package model;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Build {

	private ObservableList<Part> parts;
        

	public ObservableList<Part> getParts() {
		return this.parts;
	}

	public Build() {

		parts = FXCollections.observableArrayList();
                parts.addListener(new ListChangeListener<Part>() {
			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends Part> c) {
				totalPrice();
			}

		});
	}

	public void addPart(Part part) {
		parts.add(part);
	}

	public boolean isValid() {
		return hasPartOfType("cpu") && hasPartOfType("motherboard") && hasPartOfType("memory") && hasPartOfType("case")
				&& hasPartOfType("storage");
	}

        public double totalPrice() {

		double sum = 0.0;

		for (Part p : parts){
			sum += p.getPrice();
                }
		return sum;
	}

	public boolean hasPartOfType(String type) {
		for (Part p : parts) {
			if (p.hasType(type))
				return true;
		}

		return false;
	}

	public void remove(Part p) {
		this.parts.remove(p);
                totalPrice();
	}

	public void remove(List<Part> selectedItems) {

		this.parts.removeAll(selectedItems);
                totalPrice();

	}

	public void addParts(List<Part> selectedItems) {

		this.parts.addAll(selectedItems);

	}
        

}
