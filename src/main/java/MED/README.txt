The minimal edit distance is "the minimum number of operations required to transform one string into the other."
(https://en.wikipedia.org/wiki/Edit_distance)

This package is a simple application of algorithm design using recursive and dynamic programming strategies.
The MED class contains the two algorithms. Main reads in sample data from input.txt, runs it through the DP algorithm,
and outputs results to output.csv as well as the console. WordPairCollection is a simple List adapter.

DISCLAIMERS
The algorithms only determine the edit distance. They do not (yet) provide the traceback.

Please note that this project is to demonstrate algorithm design and nothing else. There may be other development
principles employed, but this is not meant to demonstrate them. The code is not meant to be the most elegant,
production-ready code you've ever seen. (For example, I know that I could be more generic in many places in Main. I
chose not to in order to avoid a lot of casting.) This is also not meant to be the most efficient implementation.

NOTE: The input list is from https://en.wikipedia.org/wiki/Wikipedia%3aLists_of_common_misspellings/For_machines