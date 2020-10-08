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
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.newsappinkotlin.Model.News
import com.example.newsappinkotlin.R
import com.example.newsappinkotlin.ui.destinations.ViewModel.MyVM
import kotlinx.android.synthetic.main.card.view.*
import kotlinx.android.synthetic.main.fragment_item_details.*

class ItemDetailsFragment : Fragment() {


    lateinit var vm: MyVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_item_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vm = ViewModelProvider(requireActivity()).get(MyVM::class.java)
        vm.newsLiveData2.observe(requireActivity(), Observer {
            Glide.with(frameLayout2).load("${it.image}").transform(CenterCrop()).into(img)
            newstitle.text=it.title
            des.text=it.description
            site.text=it.url
            time.text=it.author
        })

        esc.setOnClickListener {
            findNavController().navigate(R.id.action_itemDetailsFragment_to_headlinesFragment)
        }
        imageView2.setOnClickListener(){
            vm.getnld()
            findNavController().navigate(R.id.action_itemDetailsFragment_to_savedItemsFragment)
        }


    }
}