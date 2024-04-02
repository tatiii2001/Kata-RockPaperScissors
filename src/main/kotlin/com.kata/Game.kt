package com.kata

interface Choice {
    val whoBeats: List<Choice>
    fun beats(choice: Choice): Boolean = whoBeats.any { it == choice }

    companion object {
        fun of(name: String): Choice = when(name.uppercase()) {
            "SCISSORS" -> Scissors
            "PAPER" -> Paper
            "ROCK" -> Rock
            "SPOCK" -> Spock
            "Lizard" ->Lizard
            else -> throw IllegalArgumentException("Incorrect choice, '$name'")
        }
    }

    object Scissors: Choice {
        override val whoBeats: List<Choice>
            get() = listOf(Paper, Lizard)

    }

    object Paper: Choice {
        override val whoBeats: List<Choice>
            get() = listOf(Rock, Spock)

    }

    object Rock: Choice {
        override val whoBeats: List<Choice>
            get() = listOf(Scissors, Lizard)

    }

    object Spock: Choice {
        override val whoBeats: List<Choice>
            get() = listOf(Scissors, Rock)

    }

    object Lizard: Choice {
        override val whoBeats: List<Choice>
            get() = listOf(Spock, Paper)

    }
}

class Game(firstPlayerChoice: String, secondPlayerChoice: String) {
    private val firstPlayerChoice: Choice = Choice.of(firstPlayerChoice)
    private val secondPlayerChoice: Choice = Choice.of(secondPlayerChoice)

    fun whoWins(): String {
        if (firstPlayerChoice == secondPlayerChoice) {
            return "Draw!!"
        }
        if (firstPlayerChoice.beats(secondPlayerChoice)) {
            return "Player 1 win"
        }
        return "Player 2 win"
    }
}
