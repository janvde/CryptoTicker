package nl.endevelopment.cryptoticker.data.services

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.reactivex.Single
import nl.endevelopment.cryptoticker.data.model.CryptoCompareResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoCompareService {
    @GET("histominute?fsym={symbol}&tsym={currency}&limit={minutes}&aggregate=3&e=Kraken")
    fun getHistoryMinutes(@Path("symbol") symbol: String,
                          @Path("currency") currency: String,
                          @Path("minutes") minutes: Int): Single<CryptoCompareResponse>
}