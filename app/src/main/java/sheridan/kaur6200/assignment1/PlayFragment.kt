package sheridan.kaur6200.assignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import sheridan.kaur6200.assignment1.databinding.FragmentPlayBinding
import sheridan.kaur6200.assignment1.model.Choice

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PlayFragment : Fragment() {

    private var _binding: FragmentPlayBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPlayBinding.inflate(inflater, container, false)

        binding.playButton.setOnClickListener {
            val userChoice = getUserChoice()
            if(userChoice != null){
                mainViewModel.setUserChoice(userChoice)
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            } else {
                remindToSelect()
            }
        }
        return binding.root

    }

    private fun getUserChoice(): Choice? {
        return when(binding.userChoiceBox.checkedRadioButtonId){
            R.id.choice_box1 -> Choice.BOX1
            R.id.choice_box2 -> Choice.BOX2
            R.id.choice_box3 -> Choice.BOX3
            else -> null
        }
    }

    private fun remindToSelect() {
        Snackbar.make(binding.root, getString(R.string.make_your_choice), Snackbar.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.playButton
            .setOnClickListener {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}