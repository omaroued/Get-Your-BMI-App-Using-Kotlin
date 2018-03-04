package cf.slownet.www.getyourbmi

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buNext(view: View){
        try {
            var lenght:String=etLenght.text.toString()
            var weight:String=etWeight.text.toString()
            var BMI=weight.toDouble()/(lenght.toDouble()*lenght.toDouble())
            if (BMI<18.5){
                var intent=Intent(this,under::class.java)
                startActivity(intent)
            }else if (BMI>=18.5 && BMI<24.9){
                var intent=Intent(this,normal::class.java)
                startActivity(intent)
            }else if (BMI>=24.9 && BMI<29.9){
                var intent=Intent(this,over::class.java)
                startActivity(intent)
            }else{
                var intent=Intent(this,obese::class.java)
                startActivity(intent)
            }
        }catch (ex:Exception){
            Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
        }
    }
}
