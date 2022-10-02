package sheridan.kaur6200.assignment1.model

import kotlin.random.Random

class PrizeGame {

    companion object {
        fun play(playerChoice: Choice,box1: Prize,box2: Prize,box3: Prize) =
            BoxData(playerChoice,box1,box2,box3)

        fun play( playerChoice: Choice,random1: Random = Random.Default,random2: Random = Random.Default,random3: Random = Random.Default) =
            play(playerChoice,box1 = getRandomChoice(random1),box2 = getRandomChoice(random2),box3 = getRandomChoice(random3))

        fun getRandomChoice(random: Random = Random.Default) = Prize.values().random(random)
    }
}