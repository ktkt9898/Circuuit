# Analysis
# I
A stack gathers the collected path values in an upwards organization whereas a queue gathers the collected path values in a downwards organization. This is how I visualized the pattern from each of the configuration.

In a stack configuration, a new best found path can be "grown" from the most recently explored path.

In a queue configuration, the new paths are added at the end of the organization, or to the rear.

# I scribbled some of my thought process with the attached thoughtProcess.png

# II
The total number of search states, which are the discovered valid paths, can be affected by the organization. A queue may continuously add newly found paths whereas I can imagine a stack would add the best found path to the stack and remove the previously longer stack quicker.

# III
I do not believe using either a stack or queue organization will find a path quicker, since this determines on the logic used the in the search algorithm.

The stack or queue is a method to gather found search states, or paths.

# IV
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

# V
I do think using a stack or queue organization has an effect on memory use, however.
Since a queue operates as first in first out, it could lead to storing all possible paths instead of a stack, where the most recent stack can be replaced, using last in first out, with the fastest found so far path.

# VI
Using the layout:
1 O O O O
O O O O 2

The runtime order would be O(n), since it is still a relatively easy to traverse path, by either going right all the way and down or down and all the way to right, but it still must compare using a loop check. It does not have to retrace so it avoid using multiple loops.

This order reflects the initial loop which would utilize a while loop (since the size would not be known if gathering row and columns from a file initially) and have to conditionally check for an open spot (O) or invalid spot (X). Using a loop requires an unknown "n" size growth factor.