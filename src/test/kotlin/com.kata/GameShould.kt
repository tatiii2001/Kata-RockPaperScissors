package com.kata

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

/*
    *   Meet the game ranking:
    *       - Scissors beats paper
    *       - Paper beats rock
    *       - Rock beats scissors
    *   It's the same element, they tie
    *
    *
     */
class GameShould : DescribeSpec({

    describe("Player 1 win when"){
        it("scissors beats paper"){
            val game = Game("scissors", "paper")

            val result = game.whoWon()

            result.shouldBe("Player 1 win")
        }
        it("paper beats rock"){
            val game = Game("paper", "rock")

            val result = game.whoWon()

            result.shouldBe("Player 1 win")
        }
        it("rock beats scissors"){
            val game = Game("rock", "scissors")

            val result = game.whoWon()

            result.shouldBe("Player 1 win")
        }
        it("it's the same element"){
            val game = Game("rock", "rock")

            val result = game.whoWon()

            result.shouldBe("Draw!!")
        }
    }

    describe("Player 2 win when"){
        it("rock beats scissors"){
            val game = Game("scissors", "rock")

            val result = game.whoWon()

            result.shouldBe("Player 2 win")
        }
    }

})