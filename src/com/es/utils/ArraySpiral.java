package com.es.utils;


public class ArraySpiral {


    public static void main(String[] arsg) {

        try {
            int[][] input1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
            int[][] input2 = {{ 1,  2,  3,  4,  5,  6},
                              { 7,  8,  9, 10, 11, 12},
                              {13, 14, 15, 16, 17, 18}
            };
            new ArraySpiral().printSpiralRecurse(input1);
            System.out.println("");
            new ArraySpiral().printSpiralRecurse(input2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Setup up the inputs for recursive visit().
     * @param input the input int[][]
     */
    public void printSpiralRecurse(int[][] input) {
        boolean[][] visited = new boolean[input.length][input[0].length];
        this.visit(input, 0, 0, Direction.EAST, visited);
    }


    /**
     * Runs a recursive visit spiral algorithm by tracking visited nodes
     * in a boolean[][]
     *
     * @param input input to traverse int[][]
     * @param r current row to visit
     * @param c current col to visit
     * @param d current traversal direction
     * @param visited track visited nodes as boolean[][]
     * @return true|false based on last traversed element.
     */
    public boolean visit(int[][] input, int r, int c, Direction d, boolean[][] visited) {

        if (r  >= input.length || r < 0 ||
                c  >= input[0].length || c < 0) {
            return false;  //outOfBound
        }

        if (visited[r][c]) {
            return false; //alreadyVisisted
        }

        //visit & mark visited
        System.out.print(input[r][c] + ", ");
        visited[r][c]= true;

        return  visit(input,r+d.getRowIncr(),c+d.getColIncr(), d, visited) ||
                    visit(input, r + d.getRowIncr(), c + d.getColIncr(), d.changeDirection(), visited);

    }

}


/**
 * Create enum for directions so we can use it to
 * move indices for traversal plus save logic to
 * get the next direction
 *
 */
enum Direction {

    EAST(0,1),  SOUTH(1,0), WEST(0,-1), NORTH(-1,0);

    private int r=0;

    private int c=0;

     Direction(int r,int c) {
        this.r=r;
        this.c=c;
    }

    public int getRowIncr() { return this.r; }
    public int getColIncr() { return this.c; }

    public Direction changeDirection() {
        switch (this.ordinal()) {
            case 0:
                return Direction.SOUTH;
            case 1:
                return Direction.WEST;
            case 2:
                return Direction.NORTH;
            case 3:
                return Direction.EAST;
        }
        return Direction.EAST;
    }

}
