package arturs.suhomiro.flylinecalculator.ui.double_rod

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import arturs.suhomiro.flylinecalculator.Repository
import arturs.suhomiro.flylinecalculator.RepositoryImpl
import arturs.suhomiro.flylinecalculator.WeightData

class DoubleHandViewModel : ViewModel() {

        private val liveDataToObserve: MutableLiveData<List<WeightData>> = MutableLiveData()
        private val repository: Repository = RepositoryImpl()

        fun getData() = liveDataToObserve

        fun getDataFromLocalSource() {

                liveDataToObserve.postValue(repository.getRodWeightFromDoubleHand())

        }
    }