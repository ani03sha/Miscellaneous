package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves,
 * judge if this robot ends up at (0, 0) after it completes its moves.
 * <p>
 * The move sequence is represented by a string, and the character moves[i] represents its ith move.
 * Valid moves are R (right), L (left), U (up), and D (down).
 * If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.
 * <p>
 * Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to the right once,
 * "L" will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for
 * each move.
 */
public class Problem657_RobotReturnToOrigin {

    private static boolean judgeCircle(String moves) {
        int[] position = new int[2];
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'R' -> position[0]++;
                case 'L' -> position[0]--;
                case 'U' -> position[1]++;
                case 'D' -> position[1]--;
            }
        }
        return position[0] == 0 && position[1] == 0;
    }

    public static void main(String[] args) {
        String moves = "LR";
        System.out.println("Will robot return to origin: " + judgeCircle(moves));
        moves = "RRDD";
        System.out.println("Will robot return to origin: " + judgeCircle(moves));
        moves = "UD";
        System.out.println("Will robot return to origin: " + judgeCircle(moves));
    }
}
