package fr.legrand.daifen.application.data.workers

import android.content.Context
import androidx.work.RxWorker
import androidx.work.WorkerParameters
import fr.legrand.daifen.application.data.component.notification.NotificationComponent
import fr.legrand.daifen.application.data.repository.ContentRepository
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class PigeonCheckWorker(appContext: Context, workerParams: WorkerParameters) :
    RxWorker(appContext, workerParams), KoinComponent {

    private val contentRepository: ContentRepository by inject()
    private val notificationComponent: NotificationComponent by inject()

    override fun createWork(): Single<Result> =
        contentRepository.getPigeonList().map {
            if(it.any { it.unread }){
                notificationComponent.displayNewPigeonNotification()
            }
            Result.success()
        }

}