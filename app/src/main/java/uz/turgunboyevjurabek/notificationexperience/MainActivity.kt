package uz.turgunboyevjurabek.notificationexperience

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import uz.turgunboyevjurabek.notificationexperience.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        setContentView(binding.root)

        binding.button.setOnClickListener {
            builderNotification()
        }

    }

    private fun builderNotification(){
        val builder = NotificationCompat.Builder(this, "channelId")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Second Notification ")
            .setContentText("Assalom alekum")
        val notification=builder.build()
        createNotificationChannel()
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(1,notification)
    }

    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val name = "Channel Name"
            val descriptionText = "Channel Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channelId", name, importance).apply {
                description = descriptionText
            }
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}