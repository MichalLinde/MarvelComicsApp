package com.mlinde.marvelcomicsapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.clearAllMocks
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule

open class BaseTest {

    @ExperimentalCoroutinesApi
    internal val dispatcher = StandardTestDispatcher()
    @get:Rule
    val rule = InstantTaskExecutorRule()
    @ExperimentalCoroutinesApi
    @Before
    open fun setup() {
        Dispatchers.setMain(dispatcher)
    }
    @ExperimentalCoroutinesApi
    @After
    open fun clean() {
        Dispatchers.resetMain()
        //clearAllMocks()
        unmockkAll()
    }
}