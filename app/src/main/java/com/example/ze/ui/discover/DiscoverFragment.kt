package com.example.ze.ui.discover

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ze.R
import com.example.ze.constants.Util.Companion.fadeIn
import com.example.ze.databinding.FragmentDiscoverBinding
import com.example.ze.ui.discover.adapters.DiscoverRecyclerViewAdapter
import javax.inject.Inject

class DiscoverFragment @Inject constructor(
    private val discoverAdapter: DiscoverRecyclerViewAdapter
) : Fragment(R.layout.fragment_discover) {

    private var fragmentBinding: FragmentDiscoverBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDiscoverBinding.bind(view)
        fragmentBinding = binding

        binding.appNameTextView.fadeIn(1000)

        val recyclerView = binding.discoverRecyclerView
        recyclerView.adapter = discoverAdapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.visibility = View.VISIBLE

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(-1)) {
                    (requireActivity() as AppCompatActivity).supportActionBar?.show()
                } else {
                    (requireActivity() as AppCompatActivity).supportActionBar?.hide()
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentBinding = null
    }

}