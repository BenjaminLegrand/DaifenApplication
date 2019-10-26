package fr.legrand.daifen.application.data.workers

import android.annotation.SuppressLint
import android.content.Context
import androidx.work.RxWorker
import androidx.work.WorkerParameters
import fr.legrand.daifen.application.data.component.notification.NotificationComponent
import fr.legrand.daifen.application.data.exception.AuthenticationException
import fr.legrand.daifen.application.data.repository.PigeonRepository
import io.reactivex.Single
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class PigeonCheckWorker(appContext: Context, workerParams: WorkerParameters) :
    RxWorker(appContext, workerParams), KoinComponent {

    private val pigeonRepository: PigeonRepository by inject()
    private val notificationComponent: NotificationComponent by inject()

    override fun createWork(): Single<Result> =
        pigeonRepository.getPigeonList().subscribeOn(Schedulers.io()).map {
            if (it.any { !it.unread }) {
                notificationComponent.displayNewPigeonNotification()
            }
            Result.success()
        }.doOnError {
            if (it is AuthenticationException) {
                checkPigeonUpdateAuthErrorReceived()
            }
        }

    @SuppressLint("CheckResult")
    private fun checkPigeonUpdateAuthErrorReceived() {
        pigeonRepository.getPigeonUpdateAuthErrorReceived().subscribeOn(Schedulers.io())
            .subscribeBy(
                onError = {},
                onSuccess = {
                    if (!it) {
                        pigeonRepository.onPigeonUpdateAuthErrorReceived()
                        notificationComponent.displayAuthErrorNotification()
                    }
                }
            )
    }

}