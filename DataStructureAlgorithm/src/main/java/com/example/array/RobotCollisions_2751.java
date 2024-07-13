package com.example.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RobotCollisions_2751 {
    public static void main(String[] args) {
        RobotCollisions_2751 r = new RobotCollisions_2751();

        List<Integer> result = r.survivedRobotsHealths(new int[]{1, 2, 3}, new int[]{1, 1, 3}, "RRL");
        System.out.println(result);
    }

    private ArrayList<Robot> init(int[] positions, int[] healths, String directions) {
        int survivors = positions.length;
        ArrayList<Robot> line = new ArrayList<>();
        for (int i = 0; i < survivors; i++) {
            line.add(new Robot(i, positions[i], healths[i], directions.charAt(i)));
        }
        line.sort((o1, o2) -> o1.pos - o2.pos);
        return line;
    }


    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        // O(n)
        ArrayList<Robot> line = init(positions, healths, directions);
        int curIdx = 0;
        Robot prevRobot = null;
        while (line.size() > 1 && curIdx < line.size()) {
            Robot curRobot = line.get(curIdx);

            if (prevRobot != null && (curRobot.direction == 'L' && prevRobot.direction == 'R')) {
                if (curRobot.health == prevRobot.health) {
                    line.remove(curIdx);
                    curIdx--;
                    line.remove(curIdx);
                } else if (curRobot.health > prevRobot.health) {
                    line.remove(curIdx - 1);
                    curRobot.collision();
                    curIdx--;
                } else {
                    line.remove(curIdx);
                    prevRobot.collision();
                }

                if (curIdx >= 1) {
                    prevRobot = line.get(curIdx - 1);
                } else {
                    prevRobot = null;
                }
            } else {
                curIdx++;
                prevRobot = curRobot;
            }
        }

        List<Robot> lineList = new ArrayList<>(line.stream().toList());
        lineList.sort((o1, o2) -> o1.index - o2.index);
        return lineList.stream().map(robot -> robot.health).collect(Collectors.toList());

    }

    class Robot {
        private final int index;
        private int pos;
        private int health;
        private final char direction;

        public Robot(int index, int pos, int health, char direction) {
            this.index = index;
            this.pos = pos;
            this.health = health;
            this.direction = direction;
        }

        public void move() {
            if (this.direction == 'L') {
                this.pos -= 1;
            } else {
                this.pos += 1;
            }
        }

        public void collision() {
            this.health -= 1;
        }
    }
}
