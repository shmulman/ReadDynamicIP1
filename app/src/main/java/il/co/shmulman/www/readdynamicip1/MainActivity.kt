package il.co.shmulman.www.readdynamicip1


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadButton.setOnClickListener {
            statusUpdate.text = "Static IP load button pressed"
            // Read sensors data via HTML file thread
            doAsync{
                val response = URL("http://10.100.102.29/").readText()
                uiThread {
                    outputText.append("$response\n")
                }
            }
        }

        loadDynamicButton.setOnClickListener {
            statusUpdate.text = "Dynamic IP load button pressed"
        }

        clearButton.setOnClickListener {
            statusUpdate.text = "Clear button pressed"
            outputText.text = ""
        }
        
        markButton.setOnClickListener {
            statusUpdate.text = "Mark button pressed"
        }
    }

}
