## Introduction

This is a project to optimize the Tooz Smart Glasses into a product usable as a Terminal display for running different Command Line Programs.

### Background

The tooz Smart Glasses are a pair of smart glasses made by tooz technologies, which is a joint venture by Deutsche Telekom and ZEISS developing smart optics.  More information about them can be found at https://tooz.com/.

![alt text](https://tooz.com/wp-content/uploads/2021/12/DSC_4655-No-Reflection-1.png)

The tooz glasses offer many advantages, not least of which is their form factor.  They are relatively lightweight and slim, and therefore can actually be comfortably worn for daily use.  However, the main drawback of the glasses is the display is very slow.  Tooz provides a way to send 400x640 frames to the glasses through their API, but they recommend not sending more than 1 frame per second, or the glasses will fail to display the frames correctly.  This is obviously a massive drawback, as it means the glasses can't really be used as a display for real work, such as typing in a text editor, if it takes one second to update the display each time.  Thus, this project began in order to find a way to speed up the glasses' display.  

### Current Progress

Have reverse engineered the Bluetooth sequences needed to start sending my own frames without going through the Tooz API.  Time to implement this in practical applications, like a text display!

### About Me
I'm a student at the Georgia Institute of Technology working under the direction of Dr. Thad Starner at the Contextual Computing Group(CCG)!

### Contact
Contact me at pfeng32@gatech.edu if you want to talk about the project!
