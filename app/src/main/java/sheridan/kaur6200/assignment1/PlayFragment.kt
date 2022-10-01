package sheridan.kaur6200.assignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sheridan.kaur6200.assignment1.databinding.FragmentPlayBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PlayFragment : Fragment() {

    private var _binding: FragmentPlayBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPlayBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.playButton
            .setOnClickListener {
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}