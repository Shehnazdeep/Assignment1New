package sheridan.kaur6200.assignment1.model
data class BoxData(
    val playerChoice: Choice,val box1: Prize,val box2: Prize,val box3: Prize,
    val result: Prize){

    constructor(playerChoice: Choice,box1: Prize,box2: Prize,box3: Prize) : this(
        playerChoice,box1,box2,box3, getGameResult(playerChoice,box1,box2,box3)
    )
    companion object{
        private fun getGameResult(playerChoice: Choice,box1: Prize,box2:Prize,box3: Prize): Prize {
            return when (playerChoice) {
                Choice.BOX1 -> box1
                Choice.BOX2 -> box2
                Choice.BOX3 -> box3


                // fun getRandomChoice(random: Random = Random.Default) = Prize.values().random(random)
            }




        }
    }
}