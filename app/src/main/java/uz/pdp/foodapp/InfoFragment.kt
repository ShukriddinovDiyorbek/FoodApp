package uz.pdp.foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InfoFragment : Fragment() {
    lateinit var root: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root =  inflater.inflate(R.layout.fragment_info, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        val title_tv = root.findViewById<TextView>(R.id.title_tv)
        val product_tv = root.findViewById<TextView>(R.id.product_tv)
        val tartib_tv = root.findViewById<TextView>(R.id.tartib_tv)

        if (arguments != null){
            val bundle = requireArguments()
            val title = bundle.getString("title")
            val product = bundle.getString("product")
            val tartib = bundle.getString("tartib")

            title_tv.setText(title)
            product_tv.setText(product)
            tartib_tv.setText(tartib)
        }

        return root
    }
}