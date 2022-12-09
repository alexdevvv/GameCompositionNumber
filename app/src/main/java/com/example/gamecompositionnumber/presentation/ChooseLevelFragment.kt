package com.example.gamecompositionnumber.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gamecompositionnumber.R
import com.example.gamecompositionnumber.databinding.FragmentChooseLevelBinding
import com.example.gamecompositionnumber.domain.entities.Level

class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw Exception("ViewBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startGameButtons()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun startGameButtons() {
        binding.buttonLevelTest.setOnClickListener {
            chooseLevel(Level.TEST)
        }

        binding.buttonLevelEasy.setOnClickListener {
            chooseLevel(Level.EASY)
        }

        binding.buttonLevelNormal.setOnClickListener {
            chooseLevel(Level.NORMAL)
        }

        binding.buttonLevelHard.setOnClickListener {
            chooseLevel(Level.HARD)
        }

    }

    private fun chooseLevel(level: Level) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.general_fragment_container, GameFragment.newInstance(level))
            .addToBackStack(GameFragment.NAME)
            .commit()
    }

    companion object {

        fun newInstanse(): ChooseLevelFragment {
            return ChooseLevelFragment()
        }
    }
}


