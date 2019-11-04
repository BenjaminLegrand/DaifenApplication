package fr.legrand.daifen.application.data.component.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.main.MainActivity

private const val NEW_PIGEON_NOTIFICATION_ID = 1054
private const val CHANNEL_ID = "DAIFEN_CHANNEL_ID"
private const val CHANNEL_NAME = "DAIFEN_CHANNEL"

class NotificationComponentImpl(
    private val context: Context,
    private val notificationManager: NotificationManager
) : NotificationComponent {
    override fun displayAuthErrorNotification() {
        notificationManager.notify(
            NEW_PIGEON_NOTIFICATION_ID, getBaseNotificationBuilder()
                .setContentText(context.getString(R.string.notification_auth_error))
                .setStyle(
                    NotificationCompat.BigTextStyle()
                        .bigText(context.getString(R.string.notification_auth_error))
                )
                .build()
        )
    }

    override fun displayNewPigeonNotification() {
        notificationManager.notify(
            NEW_PIGEON_NOTIFICATION_ID, getBaseNotificationBuilder()
                .setContentText(context.getString(R.string.new_pigeon_received))
                .setStyle(
                    NotificationCompat.BigTextStyle()
                        .bigText(context.getString(R.string.new_pigeon_received))
                ).setContentIntent(
                    PendingIntent.getActivity(
                        context,
                        0,
                        Intent(
                            context,
                            MainActivity::class.java
                        ).apply { Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP },
                        PendingIntent.FLAG_UPDATE_CURRENT
                    )
                )
                .build()
        )
    }

    private fun getBaseNotificationBuilder(): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, getChannelId())
            .setSmallIcon(R.drawable.daifen_login_logo)
            .setContentTitle(context.getString(R.string.app_name))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
    }

    private fun getChannelId(): String {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_HIGH
                )
            notificationManager.createNotificationChannel(channel)
        }
        return CHANNEL_ID
    }
}