****************
* CircuitTracer
* CS 221
* 12/04/2024
* Kyle Truschel
**************** 

# Analysis
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

 Concisely explain what the program does. If this exceeds a couple
 of sentences, you're going too far. The details go in other
 sections.


# INCLUDED FILES:

 List the files required for the project with a brief
 explanation of why each is included.

 e.g.
 * Class1.java - source file
 * Class2.java - source file
 * README - this file


# COMPILING AND RUNNING:

 Give the command for compiling the program, the command
 for running the program, and any usage instructions the
 user needs.
 
 These are command-line instructions for a system like onyx.
 They have nothing to do with Eclipse or any other IDE. They
 must be specific - assume the user has Java installed, but
 has no idea how to compile or run a Java program from the
 command-line.
 
 e.g.
 From the directory containing all source files, compile the
 driver class (and all dependencies) with the command:
 $ javac Class1.java

 Run the compiled class file with the command:
 $ java Class1

 Console output will give the results after the program finishes.


# PROGRAM DESIGN AND IMPORTANT CONCEPTS:

 This is the sort of information someone who really wants to
 understand your program - possibly to make future enhancements -
 would want to know.

 Explain the main concepts and organization of your program so that
 the reader can understand how your program works. This is not a repeat
 of javadoc comments or an exhaustive listing of all methods, but an
 explanation of the critical algorithms and object interactions that make
 up the program.

 Explain the main responsibilities of the classes and interfaces that make
 up the program. Explain how the classes work together to achieve the program
 goals. If there are critical algorithms that a user should understand, 
 explain them as well.
 
 If you were responsible for designing the program's classes and choosing
 how they work together, why did you design the program this way? What, if 
 anything, could be improved?

# TESTING:

 How did you test your program to be sure it works and meets all of the
 requirements? What was the testing strategy? What kinds of tests were run?
 Can your program handle bad input? Is your program  idiot-proof? How do you 
 know? What are the known issues / bugs remaining in your program?


# DISCUSSION:
 Discuss the issues you encountered during programming (development)
 and testing. What problems did you have? What did you have to research
 and learn on your own? What kinds of errors did you get? How did you 
 fix them?
 
 What parts of the project did you find challenging? Is there anything
 that finally "clicked" for you in the process of working on this project?