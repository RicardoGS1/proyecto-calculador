package com.example.calculadorfonoma.data.source.remote

import com.example.calculadorfonoma.common.Constant.KEY_API
import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.data.api.ApiService
import com.example.calculadorfonoma.data.dto.Rate
import com.example.calculadorfonoma.data.dto.Rates
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class RemoteDataSourceImplTest
{



    @RelaxedMockK
    private lateinit var apiService: ApiService


    private lateinit var remoteRepositoryImpl: RemoteDataSourceImpl


    @Before
    fun setUp()
    {

        MockKAnnotations.init(this)
        remoteRepositoryImpl = RemoteDataSourceImpl(apiService)

    }

    @After
    fun tearDown()
    {
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getRates() = runTest {

        val rate = Rate(USD = 8.0,
                        NZD = 0.0,
                        LKR = 0.0,
                        CZK = 0.0,
                        JPY = 0.0,
                        PHP = 0.0,
                        KRW = 0.0,
                        BRL = 0.0,
                        HKD = 0.0,
                        RSD = 0.0,
                        MYR = 0.0,
                        VND = 0.0,
                        CAD = 0.0,
                        GBP = 0.0,
                        NOK = 0.0,
                        ILS = 0.0,
                        SEK = 0.0,
                        DKK = 0.0,
                        AUD = 0.0,
                        RUB = 0.0,
                        KWD = 0.0,
                        INR = 0.0,
                        BND = 0.0,
                        EUR = 0.0,
                        ZAR = 0.0,
                        NPR = 0.0,
                        CNY = 0.0,
                        CHF = 0.0,
                        THB = 0.0,
                        PKR = 0.0,
                        KES = 0.0,
                        EGP = 0.0,
                        BDT = 0.0,
                        SAR = 0.0,
                        LAK = 0.0,
                        IDR = 0.0,
                        KHR = 0.0,
                        SGD = 0.0)


        val a = Rates(success = true, timestamp = 1, rates = rate)

        coEvery { apiService.getRates(KEY_API) } returns a

        val values = mutableListOf<NetworkResponseState<Rates>>()

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            remoteRepositoryImpl.getRates().toList(values)

        }

        values.map {

            when (it)
            {

                is NetworkResponseState.Loading ->
                {
                    println("Looooooooooooooooad")
                    assertEquals(it, NetworkResponseState.Loading)
                }

                is NetworkResponseState.Success ->
                {
                    println("okkkkkkkkkkkkkk  " + it.result.rates)
                    assertEquals(it.result, a)
                }


                is NetworkResponseState.Error ->
                {
                    println("eeeeeeeeeeeeeeeerr" + it.exception)
                }
            }


        }

    }
}