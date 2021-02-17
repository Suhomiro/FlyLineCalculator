package arturs.suhomiro.flylinecalculator

interface Repository {
   fun getRodWeightFromSingleHand(): List<WeightData>
   fun getRodWeightFromSwitchHand(): List<WeightData>
   fun getRodWeightFromDoubleHand(): List<WeightData>

}