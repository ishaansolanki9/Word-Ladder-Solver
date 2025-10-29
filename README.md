Name: Word Ladder Solver
Description:
  A Java console program that finds the shortest word transformation (word ladder) between two words, 
  changing one letter at a time. Uses Breadth-First Search (BFS) 
  with a customizable dictionary and demonstrates graph traversal, data structures,
  and clean OOP design.

Features:
  - Finds the shortest word ladder using Breadth-First Search (BFS)
  - Uses a customizable words.txt dictionary
  - Handles invalid or unreachable word pairs gracefully
  - Demonstrates graph traversal and object-oriented Java design

Files:
  - DictionaryLoader.java: Loads and manages dictionary words
  - WordLadder.java: Represents the ladder sequence
  - WordLadderSolver.java: Implements BFS solver logic
  - WordLadderTest.java: Contains test cases for validation
  - words.txt: Dictionary file used as input

Usage:
  Steps:
    - Clone the repository:
      - git clone https://github.com/yourusername/word-ladder-solver.git
      - cd word-ladder-solver
    - Compile all Java files:
      - javac *.java
    - Run the solver:
      - java WordLadderSolver
  Example:
    Input:
      - Enter start word: cold
      - Enter end word: warm
    Output:
      - Shortest ladder: cold → cord → card → ward → warm
      - No word ladder found between cold and xxxx. (if no valid path)

Testing:
  - To run tests:
    - java WordLadderTest

Concepts Used:
  - Graph representation and traversal
  - Breadth-First Search (BFS)
  - Java Collections: Queue, Set, Map
  - File I/O
  - Object-Oriented Programming (OOP)

License: MIT License © 2025 Ishaan Solanki
