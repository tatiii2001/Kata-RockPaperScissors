package com.kata

class Game(val player1: String, val player2 : String) {

    private val winnerLoserCombinations = listOf(
        Pair("scissors", "paper"),
        Pair("paper", "rock"),
        Pair("rock", "scissors")
    )
    fun whoWon(): String {
        winnerLoserCombinations.forEach {
            if (it.first == this.player1 && it.second == this.player2){
                return  "Player 1 win"
            }
            if (it.second == this.player1 && it.first == this.player2){
                return "Player 2 win"
            }
        }
        return "Draw!!"
    }

}
