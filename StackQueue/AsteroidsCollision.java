// We are given an array asteroids of integers representing asteroids in a row. The indices of the asteroid in the array represent their relative position in space.
// For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
// Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

import java.util.*;

class AsteroidsCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        int[] stack = new int[n];
        int top = -1;

        for (int a : asteroids) {
            boolean alive = true;

            while (alive && top >= 0 && stack[top] > 0 && a < 0) {
                if (stack[top] < -a) {
                    top--; // pop
                } else if (stack[top] == -a) {
                    top--; 
                    alive = false;
                } else {
                    alive = false;
                }
            }

            if (alive) {
                stack[++top] = a;
            }
        }

        return Arrays.copyOf(stack, top + 1);
    }
}