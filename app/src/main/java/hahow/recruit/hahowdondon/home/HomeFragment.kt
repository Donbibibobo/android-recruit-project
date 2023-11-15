package hahow.recruit.hahowdondon.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import hahow.recruit.hahowdondon.databinding.FragmentHomeBinding
import hahow.recruit.hahowdondon.ext.getVmFactory

class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel> { getVmFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel


        val homeListAdapter = HomeListAdapter()
        binding.homeRecyclerView.adapter = homeListAdapter

        viewModel.classListInfo.observe(viewLifecycleOwner) {
            homeListAdapter.submitList(it.data)
        }


        return binding.root
    }
}