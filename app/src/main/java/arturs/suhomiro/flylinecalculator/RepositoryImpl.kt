package arturs.suhomiro.flylinecalculator

class RepositoryImpl: Repository {
    override fun getRodWeightFromSingleHand(): List<WeightData> {
        return getSingleHandData()
    }

    override fun getRodWeightFromSwitchHand(): List<WeightData> {
        return getSwitchHandData()
    }

    override fun getRodWeightFromDoubleHand(): List<WeightData> {
        return getDoubleHandData()
    }
}