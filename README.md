****************
* CircuitTracer
* CS 221
* 12/05/2024
* Kyle Truschel
**************** 

# Analysis:
 I
 A stack gathers the collected path values in an upwards organization whereas a queue gathers the collected path values in a downwards organization. This is how I visualized the pattern from each of the configuration.

 In a stack configuration, a new best found path can be "grown" from the most recently explored path.

 In a queue configuration, the new paths are added at the end of the organization, or to the rear.

 I scribbled some of my thought process with the attached thoughtProcess.png

 II
 The total number of search states, which are the discovered valid paths, can be affected by the organization. A queue may continuously add newly found paths whereas I can imagine a stack would add the best found path to the stack and remove the previously longer stack quicker.

 III
 I do not believe using either a stack or queue organization will find a path quicker, since this determines on the logic used the in the search algorithm.

 The stack or queue is a method to gather found search states, or paths.

 IV
 The scenario where the best case solution is where the branching nodes is all to the right or all down such as:
 1 O O O O 2

 or

 1
 O
 O
 O
 O
 2

 Where no "retrace" is needed when an X is reached/invalid spot is reached.

 Similar to question 3, I do not think the stack or queue organization will have an affect on solving, since they simply store the results of the search states.

 V
 I do think using a stack or queue organization has an effect on memory use, however.
 Since a queue operates as first in first out, it could lead to storing all possible paths instead of a stack, where the most recent stack can be replaced, using last in first out, with the fastest found so far path.

 VI
 Using the layout:
 1 O O O O
 O O O O 2

 The runtime order would be O(n), since it is still a relatively easy to traverse path, by either going right all the way and down or down and all the way to right, but it still must compare using a loop check. It does not have to retrace so it avoid using multiple loops.

 This order reflects the initial loop which would utilize a while loop (since the size would not be known if gathering row and columns from a file initially) and have to conditionally check for an open spot (O) or invalid spot (X). Using a loop requires an unknown "n" size growth factor.

# OVERVIEW:
 This program takes in a grid and examines if it is valid, meaning it has one start and one end, and only O's and X's. If validated, it will trace the most optimal path or paths from start to end and output it to the console.

# INCLUDED FILES:
 e.g.
 * CircuitTracer.java - Driver class and source file
 * CircuitBoard.java - source file
 * Storage.java - source file
 * TraceState.java - source file
 * InvalidFileFormatException.java - Exception class and source file
 * OccupiedPositionException.java - Exception class and source file
 * README - this file and instruction file
 * thoughtProcess.png - Supplemental instruction file that documented my thoughts

# COMPILING AND RUNNING:
 1. From the directory containing all source files, compile the
 driver class, the CircuitTracer.java file, (and all dependencies) with the command:
 $ javac CircuitTracer.java

 - May also be efficiently executed with:
 $ javac *.java

 2. Run the compiled class file with the command:
 $ java CircuitTracer -s|-q -c|-g filename

 Where -s OR -q represent the choice of using a *stack* or a *queue* path organization
 Where -c OR -g represent the choice of a *console* or *GUI* output
 * Note that GUI implementation will not be provided on this version.

 And where filename is the exact valid file's name and extension.
 * A valid file is where the first line contains exactly two integers, 
 and the remaining lines have exactly one "1" character, exactly one "2"
 character, and only "O" and "X" on the remaining lines.

 3. Console output will give the results after the program finishes.
 * As stated, GUI functionality does not work in this version.

# PROGRAM DESIGN AND IMPORTANT CONCEPTS:
 1. This first main concept to understand is the CircuitBoard class.
 This ensures validation that a file is indeed valid, as in it has:
 - Exactly two integers on the first line, which represent the row and columns in existence
 The remaining lines follow these conditions:
 - Exactly one start point, which is represented as "1" in the file
 - Exactly one end point, which is represented as "2" in the file
 - Only "O", "X", and eventually when traced, "T" allowed characters in the file

 If any of these conditions are invalid, an appropriate exception message will prompt the user,
 such as more columns existing that are retrieved from the first line.

 However, if the file is validated, as in no exceptions are thrown, a starting point and end point will be identified
 and the CircuitTracer will take in the now validated CircuitBoard object to be traced.

 2. The CircuitTracer class traces the most optimal circuit for a validated file.
 - The circuit will first start wherever the "1" is located, the starting point and check valid open moves, 
 represented by "O", in the left, right, up, and down directions (no diagonal).
 - An "X" in a circuit represents an invalid move, meaning if a movement attempts to 
 A circut path is considered optimal when the next adjacent move is the "2", which represents the end point.
 - The most optimal paths will then be output to the console or GUI, along with its path traced with "T" characters.
 * Note that this version does not have GUI functionality.

 3. The CircuitTracer optimal paths can be organized as a stack or a queue.
 - If the user chose "-s" from the usage message, the optimal paths will be stacked upon each other and then
 retrieved as a LIFO structure to the or GUI.
 This means the last found optimal path will be the first printed to the console or GUI.
 - If the user chose "-q" from the usage message, the optimal paths will be inserted in a line organization, and then retrieved
 as a FIFO structure to the console or GUI.
 This means that the first found optimal found path will be the first printed to the console or GUI.
 * Note that this version does not have GUI functionality.

 4. The last main concept to be aware is the recursion process involved in the CircuitTracer class.
 The base case is a situation where the best found path for a search has been found, where a method isSolution is checked and if a point's
 adjacent position is 2, the end point, then a solution has been found and is added to the list of possible solutions.
 - This best solution gathering will be overridden if the length is less than the previous found, since it would be a more efficient circuit.
 Otherwise, recursion is called to seek up, down, left, and right until an endpoint is reached, where the base case is validated again.
 - The recursion in this case checks an isOpen method, as in no adjacent spot is occupied with "X" and is indeed within the bounds of the validated file.

 5. Improvements
 The improvement for user experience would be to implement a GUI, to lower the risk of any user input errors.

# TESTING:
 I utilized the tester class provided to us, despite its confusing and poorly communicated instructions. Myself and some teaching assistants found it difficult to pinpoint
 error causes, such as the instance where the files input specifically by command lines did not offer much explanation for its error propagation. (explained in detail
 in the discussion).

 I first ensured the CircuitBoard could retrieve a file, check for inconsistencies and errors, and successfully be loaded into the program.
 Then, I worked on the CircuitTracer, using our pseudocode instruction, to ensure the process of recursion would actually trace a path.

 Like with all testing and programming, I utilize comments to retain and walk myself through what is actually going on in the entire process. I made sure to comment
 diligently around my method signatures and inside where any loops took place.

# DISCUSSION:
 The most plaguing problem of this project was the poorly explained tester class given to us, since I had multiple teaching assistants unable for several hours to understand where the location of errors were propagating.

 For instance, we were stuck on the testing section "CircuitTracer Invalid Input File Tests" for several hours without much explanation for its purpose since, it only checked one file, valid1.dat, whereas the remaining valid files given to us were outputting completely normally. We compiled the driver class and suddenly it started completing the test scenario.
 This could have entirely been avoided by just having a brief instruction of what the tester class is checking for in each scenario. It's what we pay the instructor for after all.

# CREDIT
 Teaching assistants Chase and Gabby for debugging and methodical explanation of concepts during the project's process.