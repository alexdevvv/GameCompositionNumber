package com.example.gamecompositionnumber.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.gamecompositionnumber.databinding.FragmentFinishBinding
import com.example.gamecompositionnumber.domain.entities.GameResult

class FinishFragment : Fragment() {

    private lateinit var gameResult: GameResult

    private var _binding: FragmentFinishBinding? = null
    private val binding: FragmentFinishBinding
        get() = _binding ?: throw Exception("ViewBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFinishBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parseArguments()
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    retryGame()

                }

            })
    }

    private fun retryGame() {
        requireActivity().supportFragmentManager.popBackStack(GameFragment.FRAGMENT_NAME, 1)
    }

    private fun parseArguments() {
        requireArguments().getParcelable<GameResult>(GAME_RESULT)?.let {
            gameResult = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val GAME_RESULT = "game_result"

        fun newInstance(gameResult: GameResult): FinishFragment {
            return FinishFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(GAME_RESULT, gameResult)
                }
            }
        }
    }


}