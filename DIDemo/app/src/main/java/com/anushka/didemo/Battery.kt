package com.anushka.didemo

import android.util.Log
import javax.inject.Inject


 interface Battery {

    fun getPower()
}

class NickelCadmiumBattery @Inject constructor(): Battery {

    override fun getPower() {
        Log.i("MYTAG" , "power from NickelCadmiumBattery")
    }
}
@Module
abstract class NCBatteryModule{

    @Binds
    abstract fun bindsNCBattery(nickelCadmiumBattery: NickelCadmiumBattery):Battery

}
