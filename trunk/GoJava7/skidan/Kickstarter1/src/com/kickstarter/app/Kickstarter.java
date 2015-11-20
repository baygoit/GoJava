package com.kickstarter.app;

import com.kickstarter.filerun.components.KRunFromFile;
import com.kickstarter.manager.ProjectManager;
import com.kickstarter.mangment.interfaces.FileManagerImplementation;
import com.kickstarter.mangment.interfaces.MemoryManagerImplementation;

public class Kickstarter {

	public static void main(String[] args) {
		KRun kr = new KRun();
		kr.categorySelector();

	}
}