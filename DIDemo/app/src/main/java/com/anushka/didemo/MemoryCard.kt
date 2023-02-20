package com.anushka.didemo

import android.util.Log
import javax.inject.Inject

class MemoryCard{
    init {
        Log.i("MYTAG","Memory Card Constructed")
    }

    fun getSpaceAvailablity(){
        Log.i("MYTAG","Memory space available")
    }
}


@Module
class MemoryCardModule(val memorySize: Int){

    @Provides
    fun providesMemoryCard(){
        Log.i("MYTAG", "size of the memory is $memorySize")
        return MemoryCard()
    }
}