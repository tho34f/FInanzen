package service;

import layout.LayoutElements;

public class ButtonService {
	
	private static final DierkesLooger LOGGER = new DierkesLooger();
	
	private ButtonService() {
		throw new IllegalStateException("Utility class");
	}
	
	public static void onClose(LayoutElements elements) {
		elements.getCloseApplication().setOnAction(e -> {
			LOGGER.writeInfoLog("Start Close Request", ButtonService.class.getName());
			System.exit(0);
		});
	}

}
