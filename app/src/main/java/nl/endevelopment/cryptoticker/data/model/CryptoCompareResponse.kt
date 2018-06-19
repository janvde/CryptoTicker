package nl.endevelopment.cryptoticker.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CryptoCompareResponse(
        @SerializedName("Data")
        @Expose
        val data: List<DataPoint>,
        @SerializedName("TimeTo")
        @Expose
        val timeTo: Int,
        @SerializedName("TimeFrom")
        @Expose
        val timeFrom: Int
)

data class DataPoint(
        @SerializedName("time")
        @Expose
        val time: Int,
        @SerializedName("close")
        @Expose
        val close: Double,
        @SerializedName("high")
        @Expose
        val high: Double,
        @SerializedName("low")
        @Expose
        val low: Double,
        @SerializedName("open")
        @Expose
        val open: Double,
        @SerializedName("volumefrom")
        @Expose
        val volumefrom: Double,
        @SerializedName("volumeto")
        @Expose
        val volumeto: Double
)