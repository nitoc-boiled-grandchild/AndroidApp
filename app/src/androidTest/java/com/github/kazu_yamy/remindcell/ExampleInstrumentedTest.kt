package com.github.kazu_yamy.remindcell

import androidx.test.platform.app.InstrumentationRegistry

import org.junit.Test

import org.junit.Assert.*

class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.github.kazu_yamy.myapplication105", appContext.packageName)
    }
}