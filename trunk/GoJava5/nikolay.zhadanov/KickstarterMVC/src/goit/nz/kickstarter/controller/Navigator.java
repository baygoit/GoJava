package goit.nz.kickstarter.controller;

import java.util.ArrayList;

public class Navigator {
	private ArrayList<String> layers;
	private int currentLayer;
	private int[] selectionHistory;

	public Navigator() {
		layers = new ArrayList<String>();
		layers.add("QUOTE");
		layers.add("CATEGORIES");
		layers.add("PROJECTS");
		layers.add("PROJECT");
		currentLayer = 0;
		selectionHistory = new int[layers.size()];
	}

	public String getLayer() {
		return layers.get(currentLayer);
	}

	public void update(int choice) {
		if (choice > 0) {
			forward();
		} else {
			backward();
		}
		selectionHistory[currentLayer] = choice;
	}

	public int getSelection() {
		return selectionHistory[currentLayer];
	}

	public boolean isExit() {
		return currentLayer == 0;
	}
	
	public void skip() {
		currentLayer++;
	}

	private void forward() {
		currentLayer = currentLayer + 1 > layers.size() ? currentLayer
				: currentLayer + 1;
	}

	private void backward() {
		currentLayer = currentLayer - 1 < 0 ? currentLayer : currentLayer - 1;
	}
}
