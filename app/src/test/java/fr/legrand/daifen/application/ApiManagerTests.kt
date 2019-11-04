package fr.legrand.daifen.application

import androidx.test.core.app.ApplicationProvider
import fr.legrand.daifen.application.data.di.dataModules
import fr.legrand.daifen.application.data.exception.AuthenticationException
import fr.legrand.daifen.application.data.manager.api.ApiManager
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ApiManagerTests : KoinTest {

    private val apiManager: ApiManager by inject()

    @Before
    fun init() {
        startKoin {
            androidContext(ApplicationProvider.getApplicationContext())
            modules(dataModules)
        }
    }

    @After
    fun destroy() {
        stopKoin()
    }

    @Test
    fun `check login`() {
        val obs =
            apiManager.login(BuildConfig.DAIFEN_TEST_LOGIN, BuildConfig.DAIFEN_TEST_PASSWORD).test()
        obs.assertNoErrors()
        obs.assertComplete()
    }

    @Test
    fun `check login and get pigeons`() {
        val obs =
            apiManager.login(BuildConfig.DAIFEN_TEST_LOGIN, BuildConfig.DAIFEN_TEST_PASSWORD).test()
        obs.assertNoErrors()
        obs.assertComplete()

        val pigeonListObs = apiManager.getPigeonList(1).test()
        pigeonListObs.assertNoErrors()
    }

    @Test
    fun `check pigeons call bad cookie`() {
        val pigeonListObs = apiManager.getPigeonList(1).test()
        pigeonListObs.assertError(AuthenticationException::class.java)
    }

    @Test
    fun `check login and get orders`() {
        val obs =
            apiManager.login(BuildConfig.DAIFEN_TEST_LOGIN, BuildConfig.DAIFEN_TEST_PASSWORD).test()
        obs.assertNoErrors()
        obs.assertComplete()

        val ordersObs = apiManager.getRoundOrders(1).test()
        ordersObs.assertNoErrors()
    }

    @Test
    fun `check login and get realm`() {
        val obs =
            apiManager.login(BuildConfig.DAIFEN_TEST_LOGIN, BuildConfig.DAIFEN_TEST_PASSWORD).test()
        obs.assertNoErrors()
        obs.assertComplete()

        val realmObs = apiManager.getRealm().test()
        realmObs.assertNoErrors()
    }


}