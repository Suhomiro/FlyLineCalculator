package arturs.suhomiro.flylinecalculator.ui.double_rod

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
import arturs.suhomiro.flylinecalculator.OnViewOnClickListener
import arturs.suhomiro.flylinecalculator.R
import arturs.suhomiro.flylinecalculator.WeightData
import arturs.suhomiro.flylinecalculator.getDoubleHandData
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
            doubleHandViewModel.getDataWeight().observe(viewLifecycleOwner, Observer { renderData(it) })
            if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                doubleRecycleView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            } else doubleRecycleView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            doubleRecycleView.adapter = adapter
            doubleHandViewModel.getImageChange(isDarkThemeOn())
            doubleHandViewModel.getImage().observe(viewLifecycleOwner, Observer { renderNightImage(it) })

            val recycleCreated: Animation = AnimationUtils.loadAnimation(context, R.anim.right_to_left)
            doubleRecycleView.startAnimation(recycleCreated)
        }
    private fun isDarkThemeOn(): Boolean {
        return resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }
    private fun renderNightImage(imageRes: Int){
        logoImageViewDouble.setImageResource(imageRes)
    }
        private fun renderData(it: List<WeightData>?) {
            adapter.setWeight(getDoubleHandData())
        }
    }