package com.example.newsappinkotlin.ui.destinations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.newsappinkotlin.R
import com.example.newsappinkotlin.ui.destinations.ViewModel.MyVM
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var vm:MyVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm=ViewModelProvider(this).get(MyVM::class.java)
        hideNav()

    }

    //Hiding Navigation Bar and Fixing Crash Error When Navigating Through It.
    private fun hideNav() {
        bottom_nav_view.setupWithNavController(findNavController(R.id.nav_host_fragment_container))
        Navigation.findNavController(this,R.id.nav_host_fragment_container).addOnDestinationChangedListener { _, destination, _ ->
            when{
                destination.id == R.id.splashFragment->{
                    bottom_nav_view.visibility=View.GONE
                }
                destination.id == R.id.itemDetailsFragment->{
                    bottom_nav_view.visibility=View.GONE
                }
                destination.id == R.id.headlinesFragment->{
                    bottom_nav_view.visibility=View.VISIBLE
                    vm.newsLiveData= MutableLiveData()
                }
                destination.id == R.id.savedItemsFragment->{
                    bottom_nav_view.visibility=View.VISIBLE
                    vm.newsLiveData= MutableLiveData()
                }
            }
        }
    }
}