import java.awt.Point;
import java.util.ArrayList;

/**
 * Search for shortest paths between start and end points on a circuit board
 * as read from an input file using either a stack or queue as the underlying
 * search state storage structure and displaying output to the console or to
 * a GUI according to options specified via command-line arguments.
 * 
 * @author mvail
 */
public class CircuitTracer {

	/** Launch the program. 
	 * 
	 * @param args three required arguments:
	 *  first arg: -s for stack or -q for queue
	 *  second arg: -c for console output or -g for GUI output
	 *  third arg: input file name 
	 */
	public static void main(String[] args) {
		new CircuitTracer(args); //create this with args
	}

	/** Print instructions for running CircuitTracer from the command line. */
	private void printUsage() {
		//TODO: print out clear usage instructions when there are problems with
		// any command line args
	}
	
	/** 
	 * Set up the CircuitBoard and all other components based on command
	 * line arguments.
	 * 
	 * @param args command line arguments passed through from main()
	 */
	public CircuitTracer(String[] args) {
		//TODO: parse and validate command line args - first validation provided
		if (args.length != 3) {
			printUsage();
			return; //exit the constructor immediately
		}
		if (!args[0].equals("-s") || !args[0].equals("-q")) {
			printUsage();
			return;
		}

		if (!args[1].equals("-s") || !args[1].equals("-q")) {
			printUsage();
			return;
		}

		//TODO: initialize the Storage to use either a stack or queue
		Storage<TraceState> stateStore = null;
		switch (args[0]) {
			case "-s":
				stateStore = Storage.getStackInstance();
				break;
			case "-q":
				stateStore = Storage.getQueueInstance();
				break;
			default:
				printUsage();
				return;
		}

		//TODO: read in the CircuitBoard from the given file
		try {
			CircuitBoard board = new CircuitBoard(args[2]);
		} catch (FileNotFoundException e) {
			System.out.println("Circuit Board file was not found");
		}
		catch (InvalidFileFormatException e) {
			System.out.println("Invalid file format. Please re-check the file extension.");
		}

		//TODO: run the search for best paths
		ArrayList<TraceState> paths = new ArrayList<TraceState>();

		while(!stateStore.isEmpty()) {
			TraceState currentState = stateStore.next();

			
		}

		//TODO: output results to console or GUI, according to specified choice
		switch (args[1]) {
			case "-c":
				System.out.println("TODO print to console");
			case "-g":
				System.out.println("TODO print to GUI");
			default:
				printUsage();
				return;
		}
	}
	
} // class CircuitTracer
