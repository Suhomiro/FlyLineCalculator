package arturs.suhomiro.flylinecalculator.ui.double_rod

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import arturs.suhomiro.flylinecalculator.OnViewOnClickListener
import arturs.suhomiro.flylinecalculator.R
import arturs.suhomiro.flylinecalculator.WeightData
import kotlinx.android.synthetic.main.recycle_view_item.view.*

class RecycleAdapterDouble(var onViewOnClickListener: OnViewOnClickListener): RecyclerView.Adapter<RecycleAdapterDouble.MainViewHolder>() {

    private var weightData: List<WeightData> = listOf()

    fun setWeight(data: List<WeightData>) {
        weightData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycle_view_item, parent, false) as View
        )
    }


    override fun onBindViewHolder(holder: RecycleAdapterDouble.MainViewHolder, position: Int) {
        holder.bind(weightData[position])
    }

    override fun getItemCount(): Int {
        return weightData.size
    }

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(weightData: WeightData) {
            itemView.rodItemWeightTextView.text = weightData.rodWeight.toString()
            itemView.setOnClickListener {
                onViewOnClickListener?.onItemViewClick(weightData) }
        }

    }
}
