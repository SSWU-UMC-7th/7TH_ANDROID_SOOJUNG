<<<<<<<< HEAD:app/src/androidTest/java/com/example/umc_study/ExampleInstrumentedTest.kt
package com.example.umc_study
========
package com.example.umc_practice
>>>>>>>> main-jiyeong:app/src/androidTest/java/com/example/umc_practice/ExampleInstrumentedTest.kt

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
<<<<<<<< HEAD:app/src/androidTest/java/com/example/umc_study/ExampleInstrumentedTest.kt
        assertEquals("com.example.umc_study", appContext.packageName)
========
        assertEquals("com.example.umc_practice", appContext.packageName)
>>>>>>>> main-jiyeong:app/src/androidTest/java/com/example/umc_practice/ExampleInstrumentedTest.kt
    }
}