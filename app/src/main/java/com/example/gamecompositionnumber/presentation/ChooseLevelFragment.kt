package com.example.gamecompositionnumber.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gamecompositionnumber.R
import com.example.gamecompositionnumber.databinding.FragmentChooseLevelBinding
import com.example.gamecompositionnumber.domain.entities.Level
import java.util.concurrent.Executor


class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
    get() = _binding ?: throw Exception("ViewBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTestLevelButton()
        initEasyLevelButton()
        initNormalLevelButton()
        initHardLevelButton()
    }

    private fun initTestLevelButton(){
        binding.btTestLevel.setOnClickListener {
            launchGameMode(Level.TEST)
        }
    }

    private fun initEasyLevelButton(){
        binding.btEasyLevel.setOnClickListener {
            launchGameMode(Level.EASY)
        }
    }

    private fun initNormalLevelButton(){
        binding.btNormalLevel.setOnClickListener {
            launchGameMode(Level.NORMAL)
        }
    }

    private fun initHardLevelButton(){
        binding.btHardLevel.setOnClickListener {
            launchGameMode(Level.HARD)
        }
    }

    private fun launchGameMode(level: Level){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.general_fragment_container, GameFragment.newInstance(level))
            .addToBackStack(GameFragment.FRAGMENT_NAME)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val FRAGMENT_NAME = "choose_level_fragment"

        fun newInstance(): ChooseLevelFragment =
            ChooseLevelFragment()
    }


}