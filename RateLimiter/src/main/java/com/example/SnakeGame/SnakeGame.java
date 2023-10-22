package com.example.SnakeGame;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class SnakeGame {

    Map<Pair,Boolean> snakeMap;
    Deque<Pair> snake;
    int[][] food;
    int foodIndex;
    int width;
    int height;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.snakeMap = new HashMap<>();
        this.snakeMap.put(new Pair(0, 0), true);
        this.snake = new LinkedList<>();
        this.snake.offerLast(new Pair(0, 0));

    }

    public int move(String direction) {

        Pair snakeCell = this.snake.peekFirst();
        int newHeadRow = snakeCell.x;
        int newHeadColumn = snakeCell.y;

        switch (direction) {
            case "U":
                newHeadRow--;
                break;

            case "D":
                newHeadRow++;
                break;

            case "L":
                newHeadColumn--;
                break;

            case "R":
                newHeadColumn++;
                break;
        }

        Pair newHead = new Pair(newHeadRow, newHeadColumn);
        Pair currentTail = this.snake.peekLast();

        // Boundary condition
        boolean crossesBoundary1 = newHeadRow < 0 || newHeadRow >= this.height;
        boolean crossesBoundary2 = newHeadColumn < 0 || newHeadColumn >= this.width;

        // checking if the snake bites itself
        boolean bitesItself = this.snakeMap.containsKey(newHead) && !(newHead.x == currentTail.x && newHead.y == currentTail.y);

        if (crossesBoundary1 || crossesBoundary2 || bitesItself) {
            return -1;
        }

        // if there is available food item, and it is on the cell occupied by the snake after the move, eat it.
        if (this.foodIndex < this.food.length && (this.food[this.foodIndex][0] == newHeadRow)
            && (this.food[this.foodIndex][1] == newHeadColumn)) {
            this.foodIndex++;
        } else {
            this.snake.pollLast();
            this.snakeMap.remove(currentTail);
        }

        // A new head is always getting added
        this.snake.addFirst(newHead);

        // Also, add the head to the hashMap
        this.snakeMap.put(newHead, true);

        return this.snake.size() - 1;

    }
}
