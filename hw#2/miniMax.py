import os.path
import os

def main():
        
        player = 1              ##starts player off as max == 1
        mainString = ""         ## variable for a string
        total = 0                ## variable for total coins on board.
        mainString = input("Enter some input for the current board(Ex: 5,0,0,0): ")   ## prompts for user input to start game.
        boardState = list()
        boardState = mainString.split(",")      ##takes the commas out of the string
        for index in range(len(boardState)):            ## loops through changing string integers to ints.
                boardState[index] = int(boardState[index])
        for index in range(len(boardState)):     # loops returning all objects on board
                total += boardState[index]
        miniMax(boardState, player, total)
        ## possible stuff to be done. 
                
def miniMax(board, player, total):
        bestFringeMax = []
        bestFringeMin = []
        ## recursively calls itself asking the best move for minn and maxx
        if checkGoal(board, total) == True:      ## checks for goal state.
                return fitnessFunction(board, player)    ## returns which player has won
        if player == 1:     ## checks which player were looping as.
                ##bestScore = 0   
                for validMove in possibleMoves(board, total, player):   ## for every move we could make in our list of possible moves, return best possible move depth first search
                        tempScore = miniMax(validMove, 0, total)   ##sets temp as a move for mininMax and recursively calls miniMax, changes the players turn.
                        bestScore = maxx(bestScore, tempScore)  ##calls maxx
       ##                 bestFringeMax.append(bestScore)
       ##         print(bestFringeMax)
                return bestScore    ## returns solution for maxx(high or 1)
        
        else:     ## for minns turn.
                ##bestScore = 1
                for validMove in possibleMoves(board, total, player):
                        tempScore = miniMax(validMove, 1, total)
                        bestScore = minn(bestScore, tempScore)
       ##                 bestFringeMin.append(bestScore)
       ##         print(bestFringeMin)
                return bestScore                ## returns solution for min(low)
        
def minn(bestScore, tempScore):
        ## returns the best score for minn
        if bestScore < tempScore:    ## while bestScore is less than because we want the least score.
                return bestScore
        else:
                return tempScore          ## if not less than tempScore return tempScore.

def maxx(bestScore, tempScore):
        ##returns best score for maxx 
        if bestScore > tempScore:   ## wants the better score so we will return the best(highest) score 
                return bestScore     ## while highest score return it. 
        else:
                return tempScore
        
def possibleMoves(boardState, total, player):
        ## returns all possible moves for a boardState.
        frindge =[]    ## creates a list for all possible moves
        ## possible stuff going wrong.
        print(player)
        for indexMoveFrom in range(len(boardState)-1):    ##searches each spot for teh board
                for numToMove in range(1, boardState[indexMoveFrom]+1):     ## gets the two spots we can move objects from
                        newBoard = boardState[:]  ## takes a slice out of the board
                        newBoard[indexMoveFrom] -= numToMove   ## subtracts the amount of objects moving
                        newBoard[indexMoveFrom+1] += numToMove  ## adds objects moving to next spot on the board
                  ##    if checkGoal(newBoard, total):   ## checks the board for a goal state
##                return newBoard   ## returns board if we have goal.
                        frindge.append(newBoard)
                        print(newBoard)
##        return newBoard
##                        frindge.append(newBoard)  ## takes a board and appends it to the moves we could make.
        return frindge

def checkGoal(board, total):
        ## want at spot -1(last spot) is equal tot the
        ##total amount in the board then return true
        if int(board[-1]) == total:   ##checks if all coins are in the last spot on the board
                print("goal found")
                print(board)
                return True
        else:
                return False

def fitnessFunction(board, player):
        ## want to return the player on the last move of the game.
        ##1 for player 1 won, 0 for player 2 won.
        if player == 1:
                ##would we return opposite.
                return 1 
                ## would we return opposite.
        elif player == 0:
                return 0
        
main()



        
