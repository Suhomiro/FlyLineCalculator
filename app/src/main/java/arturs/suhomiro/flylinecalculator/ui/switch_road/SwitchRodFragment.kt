package arturs.suhomiro.flylinecalculator.ui.switch_road

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import arturs.suhomiro.flylinecalculator.*
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
            switchRodViewModel.getDataWeight().observe(viewLifecycleOwner, Observer { renderData(it) })
            if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                switchRecycleView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            } else switchRecycleView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            switchRecycleView.adapter = adapter
            switchRodViewModel.getImageChange(isDarkThemeOn())
            switchRodViewModel.getImage().observe(viewLifecycleOwner, Observer { renderNightImage(it) })
            val recycleCreated: Animation = AnimationUtils.loadAnimation(context, R.anim.right_to_left)
            switchRecycleView.startAnimation(recycleCreated)
        }
    private fun isDarkThemeOn(): Boolean {
        return resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }
    private fun renderNightImage(imageRes: Int){
        logoImageViewSwitch.setImageResource(imageRes)
    }

        private fun renderData(it: List<WeightData>?) {
            adapter.setWeight(getSwitchHandData())
        }
    }