package nl.endevelopment.cryptoticker.data.services


import io.reactivex.Single
import nl.endevelopment.cryptoticker.data.model.BitstampResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BitstampService {
    @GET("ticker/{symbol}{currency}/")
    fun getPrice(@Path("symbol") symbol: String, @Path("currency") currency: String): Single<BitstampResponse>
}

