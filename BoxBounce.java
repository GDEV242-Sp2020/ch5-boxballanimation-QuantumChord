import java.awt.*;
import java.awt.geom.*;

/**
 * Class BoxBounce - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Michael Kölling (mik)
 * @author David J. Barnes
 * @author Bruce Quig
 *
 * @version 2011.07.31
 */

public class BoxBounce
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    //private final int groundPosition;      // y position of ground
    private int leftWall = 0;
    private int topWall = 0;
    private int rightWall = 0;
    private int bottomWall = 0;
    private Canvas canvas;
    private int ySpeed = 5;                // initial downward speed
    private int xSpeed = 4; 
    /**
     * Constructor for objects of class BoxBounce
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBounce(int xPos, int yPos, int ballDiameter, Color ballColor,
                        Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        canvas = drawingCanvas;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        //ySpeed += GRAVITY;
        yPosition = yPosition + ySpeed;
        xPosition = xPosition + xSpeed;

        // // check if it has hit the ground
        // if(yPosition >= (groundPosition - diameter) && ySpeed > 0) {
            // yPosition = (int)(groundPosition - diameter);
            // ySpeed = -ySpeed + ballDegradation; 
        // }
        
        if (xPosition > rightWall) {
            xPosition = rightWall;
            xSpeed = -xSpeed;
        }
        if (yPosition > bottomWall) {
            xPosition = bottomWall;
            ySpeed = -ySpeed;
        }
        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
