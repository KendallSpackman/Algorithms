This implements three algorithms to determine if you can guarantee a win in a game of Nim. This implementation allows for three heaps of stones, and a player must take one or more stones from exactly one pile. A win is defined as taking the last stone(s) such that none remain. (See also https://en.wikipedia.org/wiki/Nim)

This package is meant to demonstrate application of algorithm design using recursive, memoizing, and dynamic programming strategies. The NimSolver class contains the three algorithms, as well as an attempt at a simple optimization of the memoizing and dynamic programming algorithms. ProblemGenerator generates sample games and runs all of the algorithms, comparing the results. ProblemTimer runs the algorithms, timing execution time and outputting times and problem sizes to txt files.

DISCLAIMERS:
The algorithms only determine if a win is possible. They do not (yet) provide a traceback.

Please note that this project is to demonstrate algorithm design and nothing else. There may be other development principles employed, but this is not meant to demonstrate them. The code is not meant to be the most elegant, production-ready code you've ever seen. This is also not meant to be the most efficient implementation.