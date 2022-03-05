# Minotaur

Labrynth Problem: 

    To Compile: javac birthdayParty.java

    To Run: java birthdayParty 

    Then, when prompted, enter the number of guests you would like to attend the party. 
    
Crystal Vase Problem:

    To Compile: javac crystalVase.java

    To Run: java crystalVase

    Then, when prompted, enter the number of guests you would like to attend the party. 

Labrynth Problem Description:
    Guests are challenged with informing the Minotaur when each guest has entered his labrynth at least once. They have no way of telling each other verbally if they have entered or not. The guests are sent in randomly and can be aent in multiple times. The first guest to complete the Minotaur's maze is met with a cupcake which they can choose whether or not to eat. If they choose to eat it, they are then given the choice to replace it for the next guest. Each guest is met with either an empty plate or a cupcake at the end of the maze, depending on what the previous guest chooses to do. 

Labrynth Solution Justification: 
    The guests come up with a plan. They assign a leader guest who will be the only one who replaces the empty plate with a cupcake and keeps count of the total number of empty plates they've replaced. Each guest is instructed to only eat one cupcake regardless of how many times they are sent in. They are also informed to never replace the cupcake they had eaten. If a non-leader guest is met with an empty plate at the end of the maze, they simply do nothing and return to waiting to be chosen again. When the leader guest is randomly chosen to re-enter, and they are met with an empty plate, they increase their counter and replace the cupcake. When they count the same number of empty plates as there are guests, including themselves, the leader informs the minotaur that every guest has entered the labrynth at least once. 

Labrynth Code Justification:
    My code uses two classes, birthdayParty which creates, starts, and end the threads and nThreads which holds each thread along with the maze. This garuntees the threads will not have any communtication with eachother. The user is prompted to enter the number of threads at the party and then that number of threads are created and put into a thread array. Once a thread is started, the above procedure is ran in a mutex lock-ed block and another thread isnt touched until the last is released from the lock. 

Crystal Vase Problem Description: 
    The Minotaur wants to individually show the guests his crystal vases. The Minotaur needs thr guests to choose a strategy to signal to each other that the viewing room for the crystal vase is open.

Crystal Vase Solution Justification:
    The guests choose option 3. Which allows the guests to line up in a queue to view the vase. After the vase is viewed by a guest, the guest exits the room and they have the option to re-enter the queue for the room or go to visit the party. The next guest in the line goes into the room and the process restarts. The guests chose this strategy because it was the only strategy that garuntees each guest to see the vase at least once in a fair timely manner. 

Crystal Vase Code Justification:
    The implementation of this stratedgy only uses one class to put guests in line and send them into the room when time. The 'door' of the room uses an Alock to represent it. My example for the implementation does not account for guests choosing to re-enter thr room randomly, instead it just shows that each guest enters the room once before given the option to re-enter. If a end condition was given, it could eaasily be changed to allow guests to re-enter randomly until each guest is satid=sfied with their number of viewings. 

