package com.example.newsappinkotlin.ui.destinations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappinkotlin.Adapter.NewsAdapter
import com.example.newsappinkotlin.Model.News
import com.example.newsappinkotlin.R
import com.example.newsappinkotlin.ui.destinations.ViewModel.MyVM
import kotlinx.android.synthetic.main.fragment_saved_items.*

class SavedItemsFragment : Fragment() {

    lateinit var vm: MyVM
    lateinit var adapter:NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_saved_items, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vm = ViewModelProvider(requireActivity()).get(MyVM::class.java)
        adapter= NewsAdapter(mutableListOf(),vm)
        recSaved.adapter=adapter
        recSaved.layoutManager= LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        vm.newsLD.observe(requireActivity(), Observer<News>{
            adapter.add(it)
        })
        vm.newsLiveData.observe(requireActivity(),Observer<News>{
            vm.newsLiveData2=vm.newsLiveData
            vm.newsLiveData= MutableLiveData()
            findNavController().navigate(R.id.action_savedItemsFragment_to_itemDetailsFragment)
        })
    }


}