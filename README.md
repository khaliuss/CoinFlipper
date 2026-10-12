# 🪙 Coin Flipper (Heads & Tails)

A console-based multiplayer **Heads or Tails** game written in Java. Players choose their bets, the coin is flipped, and the application evaluates and displays the winners and losers.

---

## 📌 Features

- **Multiplayer Support**: Supports 1 to 10 players per game session.
- **Interactive Console UI**: User-friendly input dialogs with validation for selecting options.
- **Fair Coin Toss Logic**: Randomized coin side generation (`HEADS` or `TAILS`).
- **Bet Pool Management**: Safely stores and maps each player's chosen side.
- **Game Analysis**: Automatically evaluates game results to determine winners and losers.

---

## 🏗 Project Architecture

```
org.khaliuss.coinflipper
 ├── dialog/                     # Input dialog abstraction and validation
 │    ├── Dialog.java            # Generic input dialog interface
 │    ├── IntegerMinMaxDialog.java# Validates integer input within a range [min, max]
 │    └── IntegerSelectDialog.java# Validates integer input against allowed choices
 ├── models/                     # Core domain entities
 │    ├── BetPool.java           # Maps players to their coin side bets
 │    ├── Coin.java              # Coin entity with toss logic (HEADS/TAILS)
 │    ├── GameResultAnalyze.java # Business logic to calculate winners & losers
 │    └── Player.java            # Player model
 ├── Game.java                   # Main game execution loop and results printing
 └── GameRunner.java             # Entry point initializing player setup and running the game
```

---

## 🚀 Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Version 17 or higher recommended.

### How to Run

1. Clone or download the source code into your workspace.
2. Compile the Java files:
   ```bash
   javac -d bin src/org/khaliuss/coinflipper/**/*.java
   ```
3. Run the main method in `GameRunner`:
   ```bash
   java -cp bin org.khaliuss.coinflipper.GameRunner
   ```

---

## 🕹 Gameplay Overview

1. Launch the application to see the stylized **Heads & Tails** welcome banner.
2. Enter the number of players participating (between **1** and **10**).
3. Each player takes turns selecting their toss:
   - `0` for **Head**
   - `1` for **Tail**
4. The virtual coin flips!
5. The game prints the outcome and displays the list of **Winners** and **Losers**.

### Sample Output

```text
*******************
*     Heads       *
*       &         *
*     Tails       *
*******************

Input quantity of players min[1] max[10]: 2
Player 0, please input your toss Head[0] or Tail[1]: 0
Player 1, please input your toss Head[0] or Tail[1]: 1

Toss a coin...
It landed on: Head

Winners: Player 0
Losers: Player 1
```

---

## 🛠 Tech Stack

- **Language**: Java
- **Design Concepts**: Object-Oriented Programming (OOP), Interfaces, Generic Dialog Handling, Java Enums, Java Standard Collections (`HashMap`, `ArrayList`).