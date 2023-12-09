import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class DigitalClockActivity : AppCompatActivity() {

    private lateinit var digitalClockTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_digital_clock)

        digitalClockTextView = findViewById(R.id.digitalClockTextView)

        // Update the digital clock every second
        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            override fun run() {
                updateDigitalClock()
                handler.postDelayed(this, 1000)
            }
        })
    }

    private fun updateDigitalClock() {
        val currentTime = Calendar.getInstance().time
        val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val formattedTime: String = sdf.format(currentTime)

        digitalClockTextView.text = formattedTime
    }
}
