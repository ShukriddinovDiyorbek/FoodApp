package uz.pdp.foodapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.pdp.foodapp.Adapter.CustomAdapter
import uz.pdp.foodapp.db.MyDatabaseHelper
import uz.pdp.foodapp.model.Meal

class MealsFragment : Fragment() {
    lateinit var root: View
    lateinit var recyclerView: RecyclerView
    lateinit var myDatabaseHelper: MyDatabaseHelper
    lateinit var customAdapter: CustomAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getActivity()?.setTitle("Barcha taomlar");

        root = inflater.inflate(R.layout.fragment_meals, container, false)
        recyclerView = root.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context,1)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        customAdapter = CustomAdapter(myDatabaseHelper.getAllMeals(),object :
            CustomAdapter.CutomListener{
            override fun onClick(position: Int, item: Meal) {
                val title = item.name
                val product = item.product
                val tartib = item.tarib
                val bundle = Bundle()
                bundle.putString("title", title)
                bundle.putString("product", product)
                bundle.putString("tartib", tartib)
                findNavController().navigate(R.id.infoFragment, bundle)
            }
        })
        recyclerView.adapter = customAdapter

        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        myDatabaseHelper = MyDatabaseHelper(context)
    }
}