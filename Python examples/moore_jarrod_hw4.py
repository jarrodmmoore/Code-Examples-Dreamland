#Jarrod Moore
#Partner: none
#Section B
#Project: Pick Up Sticks
#Description: A simple game where players take turns picking sticks, player who takes the final stick loses. Support 2 players, or 1 player vs an AI.



import time
import random

#variables
total = 20
sticks = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
player_count = 0
#start with a random player
turn = random.choice([1, 2])
win = False
player_1_name = "Player 1"
player_2_name = "Player 2"
take_out = 0
rightmost = 19
ai_difficulty = 0

#how to play
print("=== STICKS ===")
print("Two players take turns picking sticks.")
print("The player who takes the last stick loses!\n")

#ask for player count
while not (player_count == 1 or player_count == 2):
    player_count = int(input("How many players? Game supports 1 or 2. "))
if (player_count == 1):
    player_2_name = "AI"
    while not (ai_difficulty >= 1 and ai_difficulty <= 4):
        ai_difficulty = int(input("Set AI difficulty. (1=Easy, 2=Normal, 3=Hard, 4=Harder) "))

#main game loop
while not win:
    print("\n")
    print("============================")
    if (turn == 1):
        print("{}'s turn.".format(player_1_name))
    else:
        print("{}'s turn.".format(player_2_name))
    print("============================")
    
    #print the sticks
    for i in range(0,5):
        for k in range(0,20):
            if (sticks[k] == 1 and (i < 4)):
                print("|   ", end = '')
            if (sticks[k] == 1 and (i == 4)):
                print(k + 1, end = '  ')
                if (k <= 8):
                    print(" ", end = '')
        print(" ")
    print(" ")
    
    #prepare for incoming inputs from player or AI
    take_out = 0
    
    #take sticks? (humans only)
    if (turn == 1 or (player_2_name != "AI")):
        while not (take_out >= 1 and take_out <= 3):
            take_out = int(input("How many sticks will you take out? (1 to 3): "))
    
    #AI takes sticks
    else:
        #take a random number of sticks (default behavior)
        take_out = random.choice([1, 2, 3])
        #AI will avoid killing itself if possible (all difficulties)
        if ((total - take_out) <= 0):
            take_out = 1
        #AI will force a win if it immediately can (difficulty 2 or higher)
        if ((total >= 2) and (total <= 4) and (ai_difficulty >= 2)):
            take_out = (total - 1)
		#be a massive knob when on high difficulty (3+)
		#fun fact: if the AI with difficulty lv 4 gets the starting turn it is impossible to beat it
        if ((total >= 5) and (ai_difficulty >= 3)):
            if ((total - 2) % 4 == 0):
                take_out = 1
            if ((total - 3) % 4 == 0):
                take_out = 2
            if ((total - 4) % 4 == 0):
                take_out = 3
            if ((ai_difficulty <= 3) and (random.choice([1, 2, 3, 4, 5]) >= 4)):
                #difficulty 3, AI has a chance of messing up
                take_out = random.choice([1, 2, 3])
            time.sleep(2)
        print("AI chooses to remove {} stick(s).".format(take_out))
    
    #immediately end the game here if someone decided to meme and take the last stick on purpose
    if((total - take_out) <= 0):
        win = True
        break
    
    #remove the sticks
    total -= take_out
    for e in range (0, take_out):
        sticks[rightmost] = 0
        rightmost -= 1
    print("Removed {} stick(s).".format(take_out))
    
	#next player's turn!
    turn += 1
    if(turn > 2):
        turn = 1
    
    #if the other player was left with only 1, the game ends right away.
    if (total <= 1):
        win = True
    
	#some added delay because it feels better
    time.sleep(1)

print("\n")
print("GAME ENDED!")
if (turn == 1):
    print("{} is the winner!".format(player_2_name))
else:
    print("{} is the winner!".format(player_1_name))

#get out!
input("Press ENTER to exit the program.")