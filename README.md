Asteroids (Part 1)
==================
In this assignment we will start to replicate the old video game Asteroids. You will write a program that has a space ship that can be controlled with the keyboard. You will need to write a `SpaceShip` class. Your `SpaceShip` class will extend the `Floater` class, an abstract class that represents all things that float in space. 

An abstract class is an "incomplete" class. It has abstract methods--methods that have no body. When your class extends an abstract class, you must write the methods that are needed to "complete" the class. _Note: To complete this assignment you will be writing two classes `SpaceShip` and `Star`. Do not modify the `Floater` class._

Suggested steps to complete this assignment
-------------------------------------------

1. Fork and clone down the AsteroidsGame repository.    (done)
2. Uncomment the `extends floater` on Line 10           (done) 
3. Complete the 10 abstract `set` and `get` functions    (done?)
4. Write the `Spaceship` constructor. Make sure you initialize all 9 of the inherited `protected` member variables. You may find the [Asteroids PowerPoint](https://drive.google.com/file/d/0Bz2ZkT6qWPYTYjU0NDE5ZDYtYzEwOS00MGNlLTk0OGMtODBhODI3N2JiYzRi/view?usp=sharing) slides to be helpful. You may also find [this sample SpaceShip program](https://56d4b6566b56a59e1f634ea30f548666c459899d.googledrive.com/host/0Bz2ZkT6qWPYTallTVFJBOWdNcDQ/) to be helpful in understanding how the variables affect the SpaceShip's movement.
5. At the top of your program, declare a variable of type `SpaceShip`(done?)

6. Initialize the `SpaceShip` as a new instance of the class (done?)
7. In `draw()` call the SpaceShip's `show()` function
8. When you are happy with appearance of the SpaceShip, add a `public void keyPressed()` function to your program
9. Write code in `keyPressed` that allows you to control the space ship with the keyboard. You must include the ability to rotate left, rotate right, accelerate, and enter "hyperspace." (There is no requirement for any fancy visual effects, hyperspace just needs to stop the ship, and give it a new random position and direction.)
10. Add code to `draw()` to `move()` the Spaceship
11. Finally, add a `Star` class that creates a random number of stars in random positions
12. If you have extra time and are looking for a challenge, you might try to add an animation of "rockets" that appear from the back of the ship when you accelerate

These steps are only a suggestion. Your Asteroids game doesn't have to work or act like any other. Have fun and be creative.







convert myPointDirection to radians with the following code: double dRadians =myPointDirection*(Math.PI/180);
Override the show method of the Floater class so that you can use circular bullets
Now, add just one bullet to your program. First, just draw it to the screen. Make sure you can see it before continuing to the next step.
Now, move the bullet.
Now create an ArrayList of Bullets. The list should be empty to start with. Everytime you press the key to "shoot", add a new Bullet to the ArrayList. Modify the program with loops that draw and move all the bullets in the ArrayList
One way to check for collisions between the bullets and the Asteroids is to write a loop within a loop (see below for another way). Everytime you move one asteroid you will need:
a loop that goes through all the bullets to see if there is a collision between that bullet and the asteroid
if there is a collision remove both the asteroid and the bullet from their ArrayLists
Alternatively, you might be able to use processing's get() to check for collisions.
(Note: I'm not sure if this is still true in the current version of Processing)If your finished program is running slowly, try changing size() to use P2D. For example, size(600,600,P2D); creates an applet 600 x 600 that uses processing's fast 2D renderer (which is not as accurate as the default renderer).