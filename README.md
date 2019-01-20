# MKS21X-FinalProject
Instructions:

Map: https://docs.google.com/drawings/d/18IcRpKoM4aBrPLCVbqySDgCrwhyq8Nm6cNnM3kSQbWQ/edit?usp=sharing

Change Log:

1/3/19: Made the repository

1/4/19: Worked on map, figured out nuances of github

1/7/19: Started Player.java and played around with terminal commands, nearly completed map, committed Room.java

1/8/19: Set up basics for Room.java, set up a new branch, touched up on map, worked on movement and crouch, fixed compile on Windows

1/9/19: Fixed issues with the README, Finished map/concept

1/10/19: Fiddled around with unbuntu vm due to numerous Windows problem

1/12/19: Finished and tested movement, wrote a shoot method but untested, attempted a fall method when there isn't a ground but not much luck

1/13/19: Continued working on shoot and grapple. Was able to move character up vertically but need to get rid of the trailing projection and add an animation of some sort. Looks more like a teleport

1/14/19: Decided grapple getting a class of its own might be easier to work with. Started Grapple.java and made constructor but gonna add to it. Grapple should be the similar to Bullet.java except in the up direction and aiming to add a trailing line.

1/15/19: Changed the main character to 4 high by 2 wide instead of 2 by 1. Adjusted movement accordingly and starting to fix the start position of the bullet when shooting.

1/16/19: Finished up crouch and prevent shooting when crouched. Started to implement a health system and a stationary enemy that could shoot eventually.

1/17/19: Was able to get a the VerticalShootingEnemy to shoot down but need to implement edge detection so it can stop and reshoot

1/19/19: Worked on grapple. Was able to get it to shoot up with button x but needs ceiling detection. Worked on HorizontalShootingEnemy but still needs edge detection like Vertical.
