class IsRobotBounded {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int i = 0;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}};
        for (int j = 0; j < instructions.length(); ++j)
            if (instructions.charAt(j) == 'R')
                i = (i + 1) % 4;
            else if (instructions.charAt(j) == 'L')
                i = (i + 3) % 4;
            else {
                x += dir[i][0]; 
                y += dir[i][1];
            }
        
        return x == 0 && y == 0 || i > 0;
    }
}
        
        
        /*
        //StringBuilder sb = new StringBuilder();
        int counter = 0;
        int index = 0;
        /*
        for (int i = 0; i < 4; i++) {
            sb.append(instructions);
        }
        
        instructions = sb.toString();
        *=
        int[] vector = new int[2];
        while(index < instructions.length()) {
            System.out.println(Arrays.toString(vector));
            System.out.println(counter);
            if (instructions.charAt(index) == 'L') {
                counter--;
            }
            
            else if (instructions.charAt(index) == 'R') {
                counter++;
            }
            
            else if (instructions.charAt(index) == 'G') {
                int direction = Math.abs(counter % 4);
                if (direction == 0) {
                    vector[1]++;
                }
                else if (direction == 1) {
                    vector[0]++;
                }
                else if (direction == 2) {
                    vector[1]--;
                }
                else if (direction == 3) {
                    vector[0]--;
                }
// 0,0 --> 0,1 --> 0, 2 --> 0, 1 --> 0,0                
            }
            
            if (vector[0] == 0 && vector[1] == 0) return true;
            index++;
        }
        
        return false;
    }
}


/*
G --> up 1 unit
L --> Left
R --> Right

recursively, if it ever ends up at its start position (minus the first time, we can return true)




0,0 --> 

LEFT
RIGHT
STRAIGHT

start with 0,0

I need variable to determine which direciton I'm going

Nope
I just need int direction

0 --> up
1 --> right
2 --> down
3 --> left

int direction = 0; // First I face north


Everytime I see a G, I add to my (x,y) according to my direction var

So if direction = 0; Add 1 to y-coord
Else if direction = 1; Add 1 to x-coord
Else if direction = 2; Add -1 to y-coord
else ; add -1 to x - coord

So if I see left, I subtract 1 from direction
If I see right, I add 1 to direction;

How do i make sure they are within the bounds? Modulo


if it's just Right, right right,right,right,right
--> 6

Mod by 4



if I go left, it's (1,0);
if I g






first idea: We can start at 0, and then add +1 or -1 to the number given the number of Go's and Left/right pairs.


The number of Gos must be even

It's repeated so we can copy the string 4 times or if we reach 0,0 again? What if there are trailing instructions after 0,0? 
So for example

GLGLGLGL
LGLR

This is true. So, if we ever reach 0,0, then we can return true; We can first multiply this string out 4 times and then we can play with that one. Because if 


Question: Does circle mean even if the robot takes a T shape path? The robot can take any path so it is possible for it to 

First we multiply by 4
recursion --> DP

*/
