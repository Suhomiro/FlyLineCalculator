package arturs.suhomiro.flylinecalculator.ui.double_rod

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import arturs.suhomiro.flylinecalculator.*
import arturs.suhomiro.flylinecalculator.ui.single_rod.RecycleAdapterSingle
import arturs.suhomiro.flylinecalculator.ui.single_rod.SingleHandViewModel
import kotlinx.android.synthetic.main.fragment_double.*
import kotlinx.android.synthetic.main.fragment_single.*

class DoubleHandFragment : Fragment() {



        private lateinit var doubleHandViewModel: DoubleHandViewModel
        private val weightData: List<WeightData>
            get() {
                return getDoubleHandData()
            }

        private val adapter = RecycleAdapterDouble(object : OnViewOnClickListener {
            override fun onItemViewClick(weightData: WeightData) {
                setGramTextViewDouble.text = weightData.weightGram.toString()
                setGrainTextViewDouble.text = weightData.weightGrain.toString()
                setLoadingGrainsTextViewDouble.text = weightData.loadingGrain.toString()
                setLoadingTextViewGramDouble.text = weightData.loadingGram.toString()
                rodWeightTextViewDouble.text = weightData.rodWeight.toString()
            }

        })

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            return inflater.inflate(R.layout.fragment_double, container, false)
        }
        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)
            doubleHandViewModel = ViewModelProvider(this).get(DoubleHandViewModel::class.java)
            doubleHandViewModel.getDataFromLocalSource()
            doubleHandViewModel.getData().observe(viewLifecycleOwner, Observer { renderData(it) })
            singleRecycleViewDouble.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            singleRecycleViewDouble.adapter = adapter
        }

        private fun renderData(it: List<WeightData>?) {
            adapter.setWeight(getDoubleHandData())
        }
    }