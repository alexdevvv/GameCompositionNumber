package com.example.gamecompositionnumber.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.gamecompositionnumber.R
import com.example.gamecompositionnumber.databinding.FragmentFinishBinding
import com.example.gamecompositionnumber.domain.entities.GameResult

class FinishFragment : Fragment() {

    private var _binding: FragmentFinishBinding? = null
    private val binding: FragmentFinishBinding
        get() = _binding ?: throw Exception("ViewBinding = null")

    private lateinit var gameResult: GameResult
    private val percentOfRightAnswers by lazy {
        (((gameResult.countOfRightAnswer / gameResult.countOfQuestion.toDouble()) * 100).toInt())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParams()
    }

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
        Log.e(GAME_RESULT, gameResult.toString())
        initTextsViewGameInformation()
        setupClickListeners()

    }

    private fun setupClickListeners() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                retryGame()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
    }

    private fun retryGame() {
        requireActivity().supportFragmentManager.popBackStack(
            GameFragment.NAME,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
    }

    private fun parseParams() {
        gameResult = arguments?.getParcelable<GameResult>(GAME_RESULT) as GameResult

    }

    private fun initTextsViewGameInformation() {
        with(binding) {
            tvRequiredAnswers.text = String.format(
                resources.getString(R.string.required_score),
                gameResult.gameSettings.minCountOfRightAnswers
            )

            tvScoreAnswers.text = String.format(
                resources.getString(R.string.score_answers),
                gameResult.countOfRightAnswer
            )

            tvRequiredPercentage.text = String.format(
                resources.getString(R.string.required_percentage),
                gameResult.gameSettings.minPercentOfRightAnswers
            )

            tvScorePercentage.text = String.format(
                resources.getString(R.string.score_percentage),
                percentOfRightAnswers
            )
        }


        checksIsWinner()

    }

    private fun checksIsWinner() {

        if (gameResult.winner &&
            (gameResult.countOfQuestion >= gameResult.gameSettings.minCountOfRightAnswers) &&
            percentOfRightAnswers >= gameResult.gameSettings.minPercentOfRightAnswers
        ) {
            binding.emojiResult.setImageResource(R.drawable.ic_smile)
        } else {
            binding.emojiResult.setImageResource(R.drawable.ic_sad)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(gameResult: GameResult): FinishFragment {
            return FinishFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(GAME_RESULT, gameResult)
                }
            }
        }

        const val GAME_RESULT = "game_result"
    }

}