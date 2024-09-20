package com.example.ameriabanktask.ui.theme.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.ameriabanktask.R
import com.example.ameriabanktask.databinding.FragmentUserProfileBinding
import com.example.ameriabanktask.network.UserProfileViewModel



class UserProfileFragment : Fragment() {
    private lateinit var binding: FragmentUserProfileBinding
    private val viewModel: UserProfileViewModel by viewModels()
    //private val args: UserProfileFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewModel.getUserProfile(args)
        observeLiveData()
        setupListener()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }


private fun setupListener(){
    binding.backButton.setOnClickListener{
        findNavController().navigate(R.id.action_userProfileFragment_to_usersFragment)

    }
}
    @SuppressLint("SetTextI18n")
    private fun observeLiveData() {
        viewModel.userLiveData.observe(viewLifecycleOwner) {
            binding.userName.text=it?.name
            binding.followers.text=it?.followers.toString() +" "+ R.string.followers
            binding.following.text=it?.following .toString() + " "+R.string.following
            binding.bio.text=it?.bio +": "+R.string.bio
            Glide.with(requireContext()).load(it?.avatarUrl).into(binding.userImageView)
            binding.gists.text=it?.gists.toString() +": " +R.string.gists
            binding.repository.text=it?.repository.toString()+": "+R.string.repo
            binding.updateAtIfExit.text=it?.update.toString() +": "+R.string.update
        }
    }

    companion object {
        fun newInstance() = UserProfileFragment()
    }
}
