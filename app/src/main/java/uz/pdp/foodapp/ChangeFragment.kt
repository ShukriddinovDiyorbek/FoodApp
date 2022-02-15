package uz.pdp.foodapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.pdp.foodapp.db.MyDatabaseHelper
import uz.pdp.foodapp.model.Meal

class ChangeFragment : Fragment() {
    lateinit var root: View
    lateinit var myDatabaseHelper:MyDatabaseHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getActivity()?.setTitle("Taom qo'shish");

        root =  inflater.inflate(R.layout.fragment_change, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        val et_title = root.findViewById<EditText>(R.id.et_title)
        val et_mahsulotlar = root.findViewById<EditText>(R.id.et_mahsulotlar)
        val et_tartib = root.findViewById<EditText>(R.id.et_tartib)
        val change_btn = root.findViewById<Button>(R.id.change_btn)

        change_btn.setOnClickListener {
            if (et_title.text.length>0 ||et_mahsulotlar.text.length>0 ||et_tartib.text.length>0 ){
                val title = et_title.text.toString()
                val product = et_mahsulotlar.text.toString()
                val tartib = et_tartib.text.toString()
                val meal = Meal(title,product,tartib)
                myDatabaseHelper.addMeal(meal)
                Toast.makeText(context, "Succesfully", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(context, "To'liq to'diring", Toast.LENGTH_SHORT).show()
            }
        }

        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        myDatabaseHelper = MyDatabaseHelper(context)
    }
}