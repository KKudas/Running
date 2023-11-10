package main;

public class Main {
    public static void main(String[] args) {
        new Game();
    }
}

/*
* Game Windows = uses JFrame, sets the window
* Game Panel = uses JPanel, sets specs inside the window/program
* paintComponent = called when the program is started
*
* addKeyListener = Listens for user inputs. Requires KeyListener as a parameter
* addMouseListener = Listens for mouse clicks [Pressed, Released, Clicked, Entered]. Requires MountListener as a parameter
* addMouseMotionListener = Listens for mouse movement [Drag, Movement]. Requires MouseMotionListener
* NOTE: For KeyListener, we pass the class since we implemented KeyListener to the KeyboardInput class
*       For MouseMotion and MouseListener, we create an instance/object of MouseInput since we utilize two interfaces. Passing only the class without object would overwrite one another thus an instance/object is required
*           DO NOT FORGOT TO CREATE INSTANCE OF MOUSE INPUT OR ANY NAME OF YOUR INPUT!!!
*
* gamePanel.setFocusable(True); = THis is required. I do not know why. Research more
* gamePanel.requestFocus(); = Asks for inputs??
*
* changeXDelta(VALUE) = changes X values. It adds/subtract with the current position of X axis of the rectangle
* changeYDelta(VALUE) = changes Y Values. It adds/subtract with the current position of Y axis of the rectangle
*       WHY DO WE ADD/SUBTRACT?
*           - Because in order to move, we subtract the value and return the updated position
*
* followMousePointer(X, Y) = follows the current mouse pointer location
*       WHY ASSIGN AND NOT ADD/SUBTRACT
*           - We need to get the latest position of the mouse pointer, not constantly changing the position by adding/subtracting
*
* updateRect() = Moves the rectangle position. If it exceeds the current size of window or is smaller than 0, we multiply it by -1
*       Default xDir and yDir is 1
*       Increment X and Y position with X and Y Dir
*       If WindowSize > 400 or WindowSize < 0, Multiply by negative 1
*
* INSERT THREAD AND RUN
*   - Why? Since current the Game loop is bad practice ang causes lag. It overlaps with various process. It must be streamlined
*
*
* */

