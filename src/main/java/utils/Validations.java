package main.java.utils;

public class Validations {

	public static void trueBooleanCondition(boolean condition, String successMessage, String errorMessage, String currentEvent) {
		if (condition) {
			Utils.outputInfo(successMessage);
		}
		else {
			Utils.eventFailed(currentEvent, errorMessage + ": " + condition);
		}
	}
}
