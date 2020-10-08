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
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappinkotlin.Adapter.NewsAdapter
import com.example.newsappinkotlin.Model.News
import com.example.newsappinkotlin.R
import com.example.newsappinkotlin.ui.destinations.ViewModel.MyVM
import kotlinx.android.synthetic.main.fragment_headlines.*

class HeadlinesFragment : Fragment() {

    lateinit var vm: MyVM
    lateinit var adapt: NewsAdapter
    lateinit var lLM: LinearLayoutManager
    var cPage = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_headlines, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vm= ViewModelProvider(requireActivity()).get(MyVM::class.java)
        adapt= NewsAdapter(mutableListOf(),vm)
        lLM= LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rec.adapter=adapt
        rec.layoutManager=lLM
        vm.newsLiveData.observe(requireActivity(), Observer<News>{
            vm.newsLiveData2=vm.newsLiveData
            vm.newsLiveData= MutableLiveData()
            findNavController().navigate(R.id.action_headlinesFragment_to_itemDetailsFragment)
        })
        getArticle()
    }
    fun getArticle() {
        vm.festchN(cPage)
        vm.mutNewsLiveData.observe(requireActivity(),Observer<List<News>>{
            if (it!=null){
                adapt.append(it as List<News>)
            } })
        scrollList()
    }
    fun scrollList(){
        rec.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                var totalP: Int = lLM.itemCount
                var itemViewed: Int = lLM.childCount
                var firstItemV: Int = lLM.findFirstVisibleItemPosition()
                if (itemViewed + firstItemV >= totalP) {
                    rec.removeOnScrollListener(this)
                    cPage++
                    getArticle()
                }
            } })
    }
}