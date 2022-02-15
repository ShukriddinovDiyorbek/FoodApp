package uz.pdp.foodapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment() {
    lateinit var root: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root =  inflater.inflate(R.layout.fragment_home, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        val menu_btn = root.findViewById<Button>(R.id.menu_btn)
        val add_btn = root.findViewById<Button>(R.id.add_btn)

        menu_btn.setOnClickListener {
            findNavController().navigate(R.id.mealsFragment)
        }
        add_btn.setOnClickListener {
            findNavController().navigate(R.id.changeFragment)
        }
        return root
    }
}