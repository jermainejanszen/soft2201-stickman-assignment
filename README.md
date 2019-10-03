# soft2201-stickman-assignment
Stickman Assignment for SOFT2201

Coding style: Oracle
    https://www.oracle.com/technetwork/java/codeconventions-150003.pdf

Starting the game:
    To start the game simply run using 'gradle run'.

Adding levels:
    To add your own levels put your JSON level configuration files in the levels folder.
    Ensure that the correct file path is listed in the GameEngine constructor in the App.java file to initialise the first level.
    To progress through multiple levels ensure that the correct file path is listed as the next level in the current level's configuration file.

Playing the game:
    The aim of the game is to reach the finishline flag without running out of lives. The hero starts with 3 lives and loses lives every time they run into a slime. They can win lives back occasionally by killing slimes which is done by landing on them from above.
    To traverse around the world use the arrow keys.

    Different coloured slimes have different behaviours so beware when approaching them.

Image Sources:
    Finishline flag: https://svgsilh.com/image/307612.html
