package arturs.suhomiro.flylinecalculator.ui.switch_road

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
import kotlinx.android.synthetic.main.fragment_single.*
import kotlinx.android.synthetic.main.fragment_switch.*

class SwitchRodFragment : Fragment() {


        private lateinit var switchRodViewModel: SwitchRodViewModel
        private val weightData: List<WeightData>
            get() {
                return getSingleHandData()
            }

        private val adapter = RecycleAdapterSwitch(object : OnViewOnClickListener {
            override fun onItemViewClick(weightData: WeightData) {
                setGramTextViewSwitch.text = weightData.weightGram.toString()
                setGrainTextViewSwitch.text = weightData.weightGrain.toString()
                setLoadingGrainsTextViewSwitch.text = weightData.loadingGrain.toString()
                setLoadingTextViewGramSwitch.text = weightData.loadingGram.toString()
                rodWeightTextViewSwitch.text = weightData.rodWeight.toString()
            }

        })

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            return inflater.inflate(R.layout.fragment_switch, container, false)
        }
        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)
            switchRodViewModel = ViewModelProvider(this).get(SwitchRodViewModel::class.java)
            switchRodViewModel.getDataFromLocalSource()
            switchRodViewModel.getData().observe(viewLifecycleOwner, Observer { renderData(it) })
            singleRecycleViewSwitch.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            singleRecycleViewSwitch.adapter = adapter
        }

        private fun renderData(it: List<WeightData>?) {
            adapter.setWeight(getSwitchHandData())
        }
    }