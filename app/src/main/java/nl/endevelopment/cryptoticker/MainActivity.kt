package nl.endevelopment.cryptoticker

import android.app.Activity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import nl.endevelopment.cryptoticker.data.factories.BitstampServiceFactory
import java.util.concurrent.TimeUnit


/**
 * Skeleton of an Android Things activity.
 *
 * Android Things peripheral APIs are accessible through the class
 * PeripheralManagerService. For example, the snippet below will open a GPIO pin and
 * set it to HIGH:
 *
 * <pre>{@code
 * val service = PeripheralManagerService()
 * val mLedGpio = service.openGpio("BCM6")
 * mLedGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW)
 * mLedGpio.value = true
 * }</pre>
 * <p>
 * For more complex peripherals, look for an existing user-space driver, or implement one if none
 * is available.
 *
 * @see <a href="https://github.com/androidthings/contrib-drivers#readme">https://github.com/androidthings/contrib-drivers#readme</a>
 *
 */
class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Observable.fromCallable({ updatePrice("eth", "eur") })
                .repeatWhen({ o -> o.concatMap({ v -> Observable.timer(60, TimeUnit.SECONDS) }) })
                .subscribe()

    }


    private fun updatePrice(symbol: String, currency: String) {

        BitstampServiceFactory.makeBitstampService(BuildConfig.DEBUG)
                .getPrice(symbol, currency)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { response ->
                    price_view.setText("${response.last}")
                    low_view.setText("low: ${response.last}")
                    high_view.setText("high: ${response.high}")
                }

    }
}
