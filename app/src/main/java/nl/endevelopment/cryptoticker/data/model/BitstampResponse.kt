package nl.endevelopment.cryptoticker.data.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

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