package au.edu.swin.sdmd.w03_calculations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onStop(){
        super.onStop()
        Log.i("LIFECYCLE", "stopped")
    }
    override fun onResume(){
        super.onResume()
        Log.i("LIFECYCLE", "resumed")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.i("LIFECYCLE", "destroyed")
    }
    override fun onPause(){
        super.onPause()
        Log.i("LIFECYCLE", "paused")
    }
    override fun onStart(){
        super.onStart()
        Log.i("LIFECYCLE", "started")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LIFECYCLE", "created")
        setContentView(R.layout.activity_main)

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val equals = findViewById<Button>(R.id.equals)
        equals.setOnClickListener { _ ->
            val plus = findViewById<RadioButton>(R.id.plus)
            val result:Int
            if (plus.isChecked){
                result = add(number1.text.toString(), number2.text.toString())}
            else{
                result = minus(number1.text.toString(), number2.text.toString())}
            // TODO: show result on the screen
            findViewById<TextView>(R.id.answer).text=result.toString()
        }
    }

    public override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putString("answer", answer.text.toString())

        savedInstanceState.putBoolean("plus", plus.isChecked)
        savedInstanceState.putBoolean("minus", minus.isChecked)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val result = savedInstanceState.getString("answer")
        val plus1 = savedInstanceState.getBoolean("plus")
        val minus1 = savedInstanceState.getBoolean("minus")

        //set value to UI
        answer.setText(result)
        plus.isChecked = plus1
        minus.isChecked = minus1

    }

    // adds two numbers together
    private fun add(number1: String, number2: String) = number1.toInt() + number2.toInt()
    private fun minus(number1: String, number2: String) = number1.toInt() - number2.toInt()

}