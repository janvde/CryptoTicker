package nl.endevelopment.cryptoticker.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BitstampService {
    @GET("https://www.bitstamp.net/api/v2/ticker/{symbol}{currency}/")
    fun getPrice(@Path("symbol") symbol: String, @Path("currency") currency: String): Single<BitstampResponse>
}

data class BitstampResponse(@SerializedName("high")
                            @Expose
                            val high: String,
                            @SerializedName("last")
                            @Expose
                            val last: String,
                            @SerializedName("timestamp")
                            @Expose
                            val timestamp: String,
                            @SerializedName("bid")
                            @Expose
                            val bid: String,
                            @SerializedName("vwap")
                            @Expose
                            val vwap: String,
                            @SerializedName("volume")
                            @Expose
                            val volume: String,
                            @SerializedName("low")
                            @Expose
                            val low: String,
                            @SerializedName("ask")
                            @Expose
                            val ask: String,
                            @SerializedName("open")
                            @Expose
                            val open: String)