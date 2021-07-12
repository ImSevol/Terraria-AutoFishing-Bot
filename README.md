# Terraria-AutoFishing-Bot
This is a bot that automates fishing in the Terraria game.
It is written in Java and works with a newer version of java installed.
Works on the principle:
 - take several screenshots around the cursor at 75x75px per second;
 - get the color of each pixel;
 - do nothing if you have the right color;
 - when the color disappears (the float is submerged under water), catch the fish;
Getting the color works very strangely, so I implemented the bot for only one rod (all different colors).
If you want you can take a screenshot of the float in a different state and select different color devices.
The code is mostly for learning and not for use, you can still download the release version.
