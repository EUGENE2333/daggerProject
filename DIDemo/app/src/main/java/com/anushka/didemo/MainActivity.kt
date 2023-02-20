package com.anushka.didemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
@Inject
lateinit var smartPhone: SmartPhone
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  DaggerSmartPhoneComponent.create()
        //    .inject(this)
      //      smartPhone.makeACallWithRecording()

        ( application as SmartPhoneApplication).smartPhoneComponent
            .inject(this)


//        val smartPhone = SmartPhone(
//            Battery(),
//            SIMCard(ServiceProvider()),
//            MemoryCard()
//        )
//            .makeACallWithRecording()
    }
}

class SmartPhoneApplication:Application(){

    lateinit var smartPhoneComponent: SmartPhoneComponent

    override fun onCreate(){
        smartPhoneComponent = initDagger()
        super.onCreate()
    }
    private fun initDagger():SmartPhoneComponent =
        DaggerSmartPhoneComponent.build()
            .MemoryCardModule(MemoryCardModule(1000))
            .build
}


