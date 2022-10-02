package sheridan.kaur6200.assignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sheridan.kaur6200.assignment1.databinding.FragmentResultBinding
import sheridan.kaur6200.assignment1.model.BoxData
import sheridan.kaur6200.assignment1.model.Choice
import sheridan.kaur6200.assignment1.model.Prize
import sheridan.kaur6200.assignment1.model.PrizeGame


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonTryAgain
            .setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    private fun updateOutputs(data: BoxData) {
        binding.box1Contain.text = choiceToString(data.box1)
        binding.box2Contain.text = choiceToString(data.box2)
        binding.box3Contain.text = choiceToString(data.box3)
    }

    private fun choiceToString(prize: Prize): String {
        return when (prize) {
            Prize.TV -> getString(R.string.TV)
            Prize.IPHONE -> getString(R.string.IPHONE)
            Prize.TABLET -> getString(R.string.TABLET)
            Prize.IPAD -> getString(R.string.IPAD)
            Prize.CHOCOLATES -> getString(R.string.CHOCOLATES)
            Prize.HEADSET -> getString(R.string.HEADSET)
            Prize.SOFA -> getString(R.string.SOFA)
            Prize.MICROWAVE -> getString(R.string.MICROWAVE)

        }

    }


    /*      private fun resultToString(result: BoxData,choice: Choice): String {
      return when (result) {
              Choice.BOX1 -> getString()
               -> getString(R.string.computer_wins)
              GameResult.PLAYER_TWO_WINS -> getString(R.string.you_win)
              GameResult.REPLAY -> getString(R.string.replay)
          }
      }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}