package arturs.suhomiro.flylinecalculator.ui.single_rod

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import arturs.suhomiro.flylinecalculator.Repository
import arturs.suhomiro.flylinecalculator.RepositoryImpl
import arturs.suhomiro.flylinecalculator.WeightData

class SingleHandViewModel : ViewModel() {
    private val liveDataToObserve: MutableLiveData<List<WeightData>> = MutableLiveData()
    private val repository: Repository = RepositoryImpl()


    fun getData() = liveDataToObserve


    fun getDataFromLocalSource() {

                    liveDataToObserve.postValue(repository.getRodWeightFromSingleHand())
    }
}