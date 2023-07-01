package com.example.bankoflunar

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.bankoflunar.data.repository.DepositRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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
        assertEquals("com.example.bankoflunar", appContext.packageName)
    }

    @Test
    fun shouldProperlyFindDependency() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext
        val app = appContext as BolApplication
        val d = app.getInjectable(DepositRepository::class)
        runBlocking{
            val deposits = d.getDeposits()
            println(deposits)
        }
    }
}