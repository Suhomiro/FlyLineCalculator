package arturs.suhomiro.flylinecalculator.ui.switch_road


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.RecyclerView
import arturs.suhomiro.flylinecalculator.OnViewOnClickListener
import arturs.suhomiro.flylinecalculator.R
import arturs.suhomiro.flylinecalculator.WeightData
import kotlinx.android.synthetic.main.recycle_view_item.*
import kotlinx.android.synthetic.main.recycle_view_item.view.*

class RecycleAdapterSwitch(var onViewOnClickListener: OnViewOnClickListener): RecyclerView.Adapter<RecycleAdapterSwitch.MainViewHolder>() {
    private var weightData: List<WeightData> = listOf()
    private var currentSelection = -1

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

    override fun onBindViewHolder(holder: RecycleAdapterSwitch.MainViewHolder, position: Int) {
        holder.bind(weightData[position])
        setFadeAnimation(holder.itemView)
        if (currentSelection == position){
            holder.itemView.setBackgroundResource(R.drawable.item_view_press)
        } else holder.itemView.setBackgroundResource(R.drawable.item_view_designe)
    }

    private fun setFadeAnimation(view: View) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 100
        view.startAnimation(anim)
    }

    override fun getItemCount(): Int {
        return weightData.size
    }

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(weightData: WeightData) {
            itemView.rodItemWeightTextView.text = weightData.rodWeight.toString()
            itemView.setBackgroundResource(R.drawable.layout_table_designe)
            itemView.setOnClickListener {
                onViewOnClickListener?.onItemViewClick(weightData)
                if (adapterPosition == RecyclerView.NO_POSITION) return@setOnClickListener;
                notifyItemChanged(currentSelection)
                currentSelection = adapterPosition
                notifyItemChanged(currentSelection)
            }
        }
    }

}
