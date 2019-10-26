package fr.legrand.daifen.application.data.component.background

import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import fr.legrand.daifen.application.data.workers.PigeonCheckWorker
import java.util.concurrent.TimeUnit

private const val PIGEON_CHECK_TIMER = 15L //in min

class BackgroundComponentImpl(
    private val workManager: WorkManager
) : BackgroundComponent {

    override fun init() {
        startPigeonChecker()
    }

    private fun startPigeonChecker() {
        val pigeonCheckRequest = PeriodicWorkRequestBuilder<PigeonCheckWorker>(
            PIGEON_CHECK_TIMER,
            TimeUnit.MINUTES
        ).setInitialDelay(PIGEON_CHECK_TIMER, TimeUnit.MINUTES).build()
        workManager.enqueue(pigeonCheckRequest)
    }
}