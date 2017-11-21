import os.path
import os

def mutator(string):
    ## changes the letter. 
    if string == 'D':
        return 'R'
    elif string == 'R':  ## changes character to another character
        return 'E'
    elif string == 'E':
        return 'D'
    
def cubePositionChanger(index, aList):
    ## changes the characters of the surrounding jewels. 
        if index == 0:  ## checks to see if the index is equal to the position needed to be changed
            aList[0] = mutator(aList[0])  
            aList[1] = mutator(aList[1])  ## will change the position for the spot in the list
            aList[3] = mutator(aList[3])
        elif index == 1:
            aList[0] = mutator(aList[0])
            aList[1] = mutator(aList[1])
            aList[2] = mutator(aList[2])
            aList[4] = mutator(aList[4])
        elif index == 2:
            aList[1] = mutator(aList[1])
            aList[2] = mutator(aList[2])
            aList[5] = mutator(aList[5])
        elif index == 3:
            aList[0] = mutator(aList[0])
            aList[3] = mutator(aList[3])
            aList[4] = mutator(aList[4])
            aList[6] = mutator(aList[6])
        elif index == 4:
            aList[1] = mutator(aList[1])
            aList[3] = mutator(aList[3])
            aList[5] = mutator(aList[5])
            aList[4] = mutator(aList[4])
            aList[6] = mutator(aList[6])
        elif index == 5:
            aList[2] = mutator(aList[2])
            aList[4] = mutator(aList[4])
            aList[5] = mutator(aList[5])
            aList[8] = mutator(aList[8])
        elif index == 6:
            aList[3] = mutator(aList[3])
            aList[6] = mutator(aList[6])
            aList[7] = mutator(aList[7])
        elif index == 7:
            aList[6] = mutator(aList[6])
            aList[4] = mutator(aList[4])
            aList[7] = mutator(aList[7])
            aList[8] = mutator(aList[8])
        elif index == 8:
            aList[5] = mutator(aList[5])
            aList[7] = mutator(aList[7])
            aList[8] = mutator(aList[8])
            
def goal(myList):
    ## checks to see if the solution for the game was found
    if myList == ['D','D','D','D','D','D','D','D','D']:
        return True
    if myList == ['E','E','E','E','E','E','E','E','E']:
        return True
    if myList == ['R','R','R','R','R','R','R','R','R']:
        return True
    return False

## was wondering about extra credit for having this implemented for some time before I swithched to Breadth First Search. 

##def DLS(myList, depth):
##    index = 0
##    if depth >= 0:
##        if goal(myList) == True:
##            ##return gemNumber
##            return
##        if depth == 0:
##            return 
##
##    for index in range(9):
##        if goal(myList) == True:
##            return print(myList)
##        else:
##            print(myList)
##            cubePositionChanger(index, myList)

def BFS(frindge):
    ##creates fringe puts aList into it, takes the top off sends that through the for loop. 
    ##current = []
    ##frindge = list() ## fringe keeping track of lists
    ##frindge.append(aList)  ## puts the list inside fringe 
    ##first = frindge[0]   ## sets fringe as a variable
    aList = frindge.pop(0) ## takes the top list of strings off the stack.
    ##print(aList)
    if goal(aList) == True:  ## checks to see if goal state was produced.
        print("Done", aList)
        return aList
    ##print(aList)
    for index in range(9):
        ##current.append(aList)   ## uses current to keep track of the list we're using
        ##print(aList)
        newList = aList[:]
        cubePositionChanger(index, newList)  ## changes the letters in the string
        frindge.append(newList)
    ## BFS(frindge)  ## supposed to recursively call the Breadth first search 
    
def main():
    ## initiates the mainString, checks for goal before solution. 
    index = 0
    mainString = ""  ## takes in a variable as a string
    frindge = list()
    myList = list()   ## keeps track of the characters etered into mainString
    mainString = input("Put some input of  E, R and D.")  ## takes the user input. 
    for character in mainString:
        myList.append(character) ## puts all characters entered into the list
        #print(myList)
    frindge.append(myList)
    while (goal(myList) == False):  ## goes throught the List checks it, as long as it's false loop through BFS
        myList = BFS(frindge)

main()   ## calls my main function
