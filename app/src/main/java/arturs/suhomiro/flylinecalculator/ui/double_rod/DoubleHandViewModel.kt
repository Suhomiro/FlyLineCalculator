package arturs.suhomiro.flylinecalculator.ui.double_rod

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import arturs.suhomiro.flylinecalculator.Repository
import arturs.suhomiro.flylinecalculator.RepositoryImpl
import arturs.suhomiro.flylinecalculator.WeightData
import arturs.suhomiro.flylinecalculator.ui.interactor.InteractorImpl

class DoubleHandViewModel : ViewModel() {
        private val liveDataToObserve: MutableLiveData<List<WeightData>> = MutableLiveData()
        private val nightModeImageChange: MutableLiveData<Int> = MutableLiveData()
        private val repository: Repository = RepositoryImpl()
        private var imageInteractor = InteractorImpl()

        fun getDataWeight() = liveDataToObserve
        fun getImage() = nightModeImageChange

        fun getImageChange(boolean: Boolean){
                if(boolean) {
                        nightModeImageChange.postValue(imageInteractor.logoNightImage)
                }
        }
        fun getDataFromLocalSource() {
                liveDataToObserve.postValue(repository.getRodWeightFromSingleHand())
        }
}