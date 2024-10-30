# Simon Game 🎮

A modern, interactive version of the classic Simon memory game, implemented in Java using Swing for the graphical interface. In this game, players test their memory skills by repeating a randomly generated sequence of colors that grows in length with each successful round. As the game progresses, the sequence becomes more challenging to remember, creating an engaging test of memory and focus.

## Features

- **Dynamic Sequence Generation**: Each round, the game generates a new random color, increasing the sequence length and difficulty as you progress.
- **Color Flashing with Timing Delays**: Uses `Timer` objects to create a smooth, timed flash for each color in the sequence, making gameplay intuitive and visually engaging.
- **Player Interaction and Feedback**: Players receive instant feedback if they make a mistake, and a pop-up displays their score at the end of each game.
- **Replay Functionality**: After a game over, players can restart with a new randomized sequence.

## How It Works

1. The game starts by flashing a randomly generated sequence of colors on a 2x2 grid of buttons.
2. Players must replicate the sequence by clicking the buttons in the correct order.
3. If the player correctly follows the sequence, a new color is added, and the sequence is shown again with the added difficulty.
4. The game ends if the player clicks the wrong button, displaying their score.

## Technologies Used

- **Java**: Core programming language for logic and control.
- **Swing**: Java's GUI toolkit used for creating the 2x2 button grid and game display.
- **Timer**: Used to manage the timed color flashes and delays between sequence steps.

## ScreenShot
![image](https://github.com/user-attachments/assets/2cd3fde7-a75f-4944-8f39-cedd835aae19)

This project is a fun and simple demonstration of Java's GUI capabilities and an introduction to using timers for event handling in game development. Happy playing!
