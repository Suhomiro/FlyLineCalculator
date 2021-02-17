package arturs.suhomiro.flylinecalculator.ui.single_rod

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
import arturs.suhomiro.flylinecalculator.getSingleHandData
import kotlinx.android.synthetic.main.fragment_single.*

class SingleHandFragment : Fragment() {
    private lateinit var singleHandViewModel: SingleHandViewModel

    private val adapter = RecycleAdapterSingle(object : OnViewOnClickListener {

        override fun onItemViewClick(weightData: WeightData) {
            onStart()
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
        singleHandViewModel.getDataWeight().observe(viewLifecycleOwner, Observer { renderData(it) })
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            singleRecycleView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        } else singleRecycleView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)


        singleRecycleView.adapter = adapter
        singleHandViewModel.getImageChange(isDarkThemeOn())
        singleHandViewModel.getImage().observe(viewLifecycleOwner, Observer { renderNightImage(it) })

        val recycleCreated: Animation = AnimationUtils.loadAnimation(context, R.anim.right_to_left)
        singleRecycleView.startAnimation(recycleCreated)
    }


    private fun isDarkThemeOn(): Boolean {
        return resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }

    private fun renderData(it: List<WeightData>?) {
        adapter.setWeight(getSingleHandData())
    }
    private fun renderNightImage(imageRes: Int){
            logoImageView.setImageResource(imageRes)
        }
}