package com.example.gamecompositionnumber.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.gamecompositionnumber.R
import com.example.gamecompositionnumber.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding: FragmentWelcomeBinding
        get() = _binding ?: throw Exception("ViewBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initStepToGameButton()
    }

    private fun initStepToGameButton(){
        binding.btStepToGame.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.general_fragment_container, ChooseLevelFragment.newInstance())
                .addToBackStack(ChooseLevelFragment.FRAGMENT_NAME)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
