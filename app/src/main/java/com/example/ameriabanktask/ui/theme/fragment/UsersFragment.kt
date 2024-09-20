package com.example.ameriabanktask.ui.theme.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ameriabanktask.R
import com.example.ameriabanktask.databinding.FragmentUsersBinding
import com.example.ameriabanktask.network.UsersViewModel
import com.example.ameriabanktask.ui.theme.adapter.UsersListAdapter

class UsersFragment : Fragment(){
    private lateinit var binding: FragmentUsersBinding
    private val viewModel:UsersViewModel by viewModels()
    private val adapter= UsersListAdapter{
    findNavController().navigate(R.id.action_usersFragment_to_userProfileFragment)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getAllUser()

    }

    @Deprecated("Deprecated in Java")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_users, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObserve()

    }



    private fun setupViews() {

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun setupObserve() {
        viewModel.usersLiveData.observe(viewLifecycleOwner) { it ->
            adapter.updateData(it)
        }

    }

    companion object {
        fun newInstance() = UsersFragment()
    }
}