package com.example.gamecompositionnumber.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gamecompositionnumber.R
import com.example.gamecompositionnumber.databinding.FragmentGameBinding
import com.example.gamecompositionnumber.domain.entities.GameResult
import com.example.gamecompositionnumber.domain.entities.GameSetting
import com.example.gamecompositionnumber.domain.entities.Level

class GameFragment : Fragment() {

    private lateinit var level: Level

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw Exception("ViewBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parseParamsLevel()
        stepTOFinishFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun stepTOFinishFragment() {
        binding.tvLeftNumber.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(
                    R.id.general_fragment_container, FinishFragment.newInstance(
                        GameResult(
                            true, 20, 25,
                            GameSetting(10, 5, 60, 60)
                        )
                    )
                )
                .addToBackStack(null)
                .commit()
        }
    }

    private fun parseParamsLevel() {
        requireArguments().getParcelable<Level>(KEY_LEVEL)?.let {
            level = it
        }
    }

    companion object {

        private const val KEY_LEVEL = "level"
        const val FRAGMENT_NAME = "game_fragment"

        fun newInstance(level: Level): GameFragment {
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_LEVEL, level)
                }
            }
        }
    }


}