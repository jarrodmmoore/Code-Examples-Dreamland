#Jarrod Moore
#Partner: none
#Section B
#Project: Vending Machine
#Description: This program simulates the operation of a vending machine through use of different states and is controlled by user inputs.



#using this for a delay after the program has finished
import time

#variables
state = "A"
total_inserted = 0
drink_1 = 2
drink_2 = 4
drink_3 = 1
raw_input = "placeholder"
command = "placeholder"
argument = 0
selection = 0

#fiddling around with functions here
def display_inventory():
    print("1 -- Coca Cola (qty:{})".format(drink_1))
    print("2 -- Pepsi: (qty:{})".format(drink_2))
    print("3 -- Bottled Water: (qty:{})".format(drink_3))

while True:
    #state A = idle / default
    if(state == "A"):
        #clean up some values whenever we return to this state
        total_inserted = 0
        selection = 0
        
        print("Welcome!")
        display_inventory();
        while True:
            raw_input = input("Please enter a command: ")
            
            #OFF command
            command = raw_input[:3]
            if (command == "off" or command == "OFF"):
                state = "G"
                break
            
            #STOCK command
            command = raw_input[:5]
            if (command == "stock" or command == "STOCK"):
                state = "F"
                break
            
            #INSERT command
            command = raw_input[:6]
            if (command == "insert" or command == "INSERT"):
                state = "B"
                break
            
            #try again!
            print("Valid commands include: 'insert', 'stock' and 'off'.")
                
    #state B = inserting coins
    elif(state == "B"):
        while True:
            print("Coin(s) needed: {}".format(5 - total_inserted))
            raw_input = input("Please insert number of coins or request a refund. ")
            
            #refund
            command = raw_input[:6]
            if (command == "refund" or command == "REFUND"):
                state = "E"
                break
            
            #insert an integer amount of coins
            if (raw_input.isdigit()):
                argument = int(raw_input)
                if (argument > 0):
                    print("Inserted {} coin(s).".format(argument))
                    total_inserted += argument
                    if (total_inserted >= 5):
                        state = "C"
                        break
                    else:
                        print("\n")
                
    #state C = select item
    elif(state == "C"):
        display_inventory()
        while True:
            raw_input = input("Please choose an option (1-3) or request a refund. ")
            
            #refund
            command = raw_input[:6]
            if (command == "refund" or command == "REFUND"):
                state = "E"
                break
            
            #select an item
            if (raw_input.isdigit()):
                argument = int(raw_input)
                if (argument == 1):
                    if (drink_1 > 0):
                        selection = 1
                        state = "D"
                        print("Selected Coca Cola.")
                        break
                    else:
                        print("Sorry, that item is out of stock!\n")
                if (argument == 2):
                    if (drink_2 > 0):
                        selection = 2
                        state = "D"
                        print("Selected Pepsi.")
                        break
                    else:
                        print("Sorry, that item is out of stock!\n")
                if (argument == 3):
                    if (drink_3 > 0):
                        selection = 3
                        state = "D"
                        print("Selected Bottled Water.")
                        break
                    else:
                        print("Sorry, that item is out of stock!\n")
                
    #state D = dispense items and ask if the user wants their change
    elif(state == "D"):
        if (selection == 1):
            print("Dispensed Coca Cola.")
            drink_1 -= 1
        elif (selection == 2):
            print("Dispensed Pepsi.")
            drink_2 -= 1
        elif (selection == 3):
            print("Dispensed Bottled Water.")
            drink_3 -= 1
        
        print("\n{} coin(s) left over.".format(total_inserted - 5))
        #only ask for change return if amt inserted exceeded the minimum
        if (total_inserted > 5):
            while True:
                raw_input = input("Would you like your change? (y/n) ")
                command = raw_input[:1]
            
                #yes
                if (command == "y" or command == "Y"):
                    total_inserted -= 5
                    state = "E"
                    break
            
                #no
                if (command == "n" or command == "N"):
                    state = "A"
                    break
                    
        else:
            state = "A"
    
    #state E = refund all inserted coins
    elif(state == "E"):
        print("Refunded {} coin(s).".format(total_inserted))
        state = "A"
        
    #state F = restock all items in the machine to their initial value
    elif(state == "F"):
        print("Re-stocked all items in the machine.")
        drink_1 = 2
        drink_2 = 4
        drink_3 = 1
        state = "A"

    #state G = turn off the machine (exit state)
    elif(state == "G"):
        print("The machine has been turned off.")
        break
    
    #error message for troubleshooting
    else:
        print("This is an error message! State value \"{}\" is invalid.".format(state))
        break
    
    #make an extra line after each loop
    print("\n")
    
#end of loop
time.sleep(3)