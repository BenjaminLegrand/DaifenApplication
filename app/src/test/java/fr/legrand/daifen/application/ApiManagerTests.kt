package fr.legrand.daifen.application

import fr.legrand.daifen.application.data.di.dataModules
import fr.legrand.daifen.application.data.entity.remote.PigeonRemoteEntity
import fr.legrand.daifen.application.data.manager.api.ApiManager
import io.reactivex.observers.TestObserver
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog
import retrofit2.HttpException

@RunWith(RobolectricTestRunner::class)
class ApiManagerTests : KoinTest {

    private val apiManager: ApiManager by inject()

    @Before
    fun init() {
        ShadowLog.stream = System.out
        startKoin { modules(dataModules) }
    }

    @After
    fun destroy() {
        stopKoin()
    }

    @Test
    fun `check login`() {
        val pigeonListSingle = apiManager.login(BuildConfig.DAIFEN_TEST_LOGIN, BuildConfig.DAIFEN_TEST_PASSWORD)
        val subscriber = TestObserver<String>()

        pigeonListSingle.subscribe(subscriber)
        subscriber.assertNoErrors()
        subscriber.assertValue { it.isNotEmpty() }
    }

    @Test
    fun `check login and get pigeons`() {
        val loginSingle = apiManager.login(BuildConfig.DAIFEN_TEST_LOGIN, BuildConfig.DAIFEN_TEST_PASSWORD)
        val loginSubscriber = TestObserver<String>()

        loginSingle.subscribe(loginSubscriber)
        val cookie = loginSubscriber.values().first()
        val pigeonListSingle = apiManager.getPigeonList(cookie)
        val pigeonSubscriber = TestObserver<List<PigeonRemoteEntity>>()

        pigeonListSingle.subscribe(pigeonSubscriber)
        pigeonSubscriber.assertNoErrors()
    }

    @Test
    fun `check pigeons call bad cookie`() {
        val pigeonListSingle = apiManager.getPigeonList("zefpokzefpo")
        val subscriber = TestObserver<List<PigeonRemoteEntity>>()

        pigeonListSingle.subscribe(subscriber)
        subscriber.assertError(HttpException::class.java)
    }


}