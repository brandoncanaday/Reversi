
public abstract class ComputerPlayer extends Player {
	
	/**
	 * Pauses execution of the program for a specified amount of time
	 * @param milliseconds the number of milliseconds to pause execution
	 */
	public void createTimeDelay(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
}
