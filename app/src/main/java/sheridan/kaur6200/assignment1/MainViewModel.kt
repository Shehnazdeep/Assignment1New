package sheridan.kaur6200.assignment1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sheridan.kaur6200.assignment1.model.BoxData
import sheridan.kaur6200.assignment1.model.Choice
import sheridan.kaur6200.assignment1.model.PrizeGame

class MainViewModel : ViewModel() {

    private val _gameData = MutableLiveData<BoxData>()
    val gameData: LiveData<BoxData> = _gameData

    fun setUserChoice(userChoice: Choice) {
        _gameData.value = PrizeGame.play(playerChoice = userChoice)
    }
}