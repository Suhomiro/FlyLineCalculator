package arturs.suhomiro.flylinecalculator.ui.single_rod

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import arturs.suhomiro.flylinecalculator.*
import kotlinx.android.synthetic.main.fragment_single.*
import kotlinx.android.synthetic.main.recycle_view_item.*
import kotlinx.coroutines.selects.select


class SingleHandFragment : Fragment() {

    private lateinit var singleHandViewModel: SingleHandViewModel
   private val weightData: List<WeightData>
       get() {
           return getSingleHandData()
       }

    private val adapter = RecycleAdapterSingle(object : OnViewOnClickListener {

        override fun onItemViewClick(weightData: WeightData) {


            setGramTextView.text = weightData.weightGram.toString()
            setGrainTextView.text = weightData.weightGrain.toString()
            setLoadingGrainsTextView.text = weightData.loadingGrain.toString()
            setLoadingTextViewGram.text = weightData.loadingGram.toString()
            rodWeightTextView.text = weightData.rodWeight.toString()

        }

    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_single, container, false)

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        singleHandViewModel = ViewModelProvider(this).get(SingleHandViewModel::class.java)
        singleHandViewModel.getDataFromLocalSource()
        singleHandViewModel.getData().observe(viewLifecycleOwner, Observer { renderData(it) })
        singleRecycleView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        singleRecycleView.adapter = adapter

    }


    private fun renderData(it: List<WeightData>?) {
        adapter.setWeight(getSingleHandData())
    }
}