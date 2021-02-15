package arturs.suhomiro.flylinecalculator

data class WeightData(
    val rodWeight: Int,
    val weightGram: Double,
    val weightGrain: Double,
    val loadingGram: Double,
    val loadingGrain: Double
) {
    fun isSelected(): Boolean {
        return true
    }
}

fun getSingleHandData(): List<WeightData> {
    return listOf(
        WeightData(1, 3.9, 60.00, 0.39, 6.00),
        WeightData(2, 5.2, 80.00, 0.39, 6.00),
        WeightData(3, 6.5, 100.00, 0.39, 6.00),
        WeightData(4, 7.8, 120.00, 0.39, 6.00),
        WeightData(5, 9.1, 140.00, 0.39, 6.00),
        WeightData(6, 10.4, 160.00, 0.52, 8.00),
        WeightData(7, 12.02, 180.00, 0.52, 8.00),
        WeightData(8, 13.65, 210.00, 0.52, 8.00),
        WeightData(9, 15.6, 240.00, 0.65, 10.00),
        WeightData(10, 18.2, 280.00, 0.65, 10.00),
        WeightData(11, 21.45, 330.00, 0.78, 12.00),
        WeightData(12, 24.7, 380.00, 0.78, 12.00),
        WeightData(13, 29.25, 450.00, 0.98, 15.00),
        WeightData(14, 32.5, 500.00, 0.98, 15.00),
        WeightData(15, 35.75, 550.00, 0.39, 6.00)
    )
}
    fun getSwitchHandData(): List<WeightData>{
        return listOf(
            WeightData(3, 9.75,150.00,1.62, 25.00),
            WeightData(4, 13.0,200.00,1.62, 25.00),
            WeightData(5, 16.25,250.00,1.62, 25.00),
            WeightData(6, 17.9,275.00,1.62, 25.00),
            WeightData(7, 21.1,325.00,1.62, 25.00),
            WeightData(8, 24.4,375.00,1.62, 25.00),
            WeightData(9, 29.25,450.00,1.62, 25.00),
            WeightData(10, 30.9,475.00,1.62, 25.00)
        )
    }
    fun getDoubleHandData(): List<WeightData>{
        return listOf(
            WeightData(5, 19.5,300.00,1.62, 25.00),
            WeightData(6, 26.2,400.00,1.62, 25.00),
            WeightData(7, 29.25,40.00,1.62, 25.00),
            WeightData(8, 35.75,550.00,1.95, 30.00),
            WeightData(9, 42.25,650.00,1.95, 30.00),
            WeightData(10, 45.5,700.00,3.25, 50.00)
        )
    }

