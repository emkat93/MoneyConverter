package com.example.moneyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true);
        getSupportActionBar()!!.setLogo(R.mipmap.ic_launcher);
        getSupportActionBar()!!.setDisplayUseLogoEnabled(true);

        val convertNum = findViewById<EditText>(R.id.idConvertMoney)
        val rbUSDToYen = findViewById<RadioButton>(R.id.idRBUSDToYen)
        val rbYenToUSD = findViewById<RadioButton>(R.id.idRBYenToUSD)
        val txtResult = findViewById<TextView>(R.id.idResult)
        val convertIt = findViewById<Button>(R.id.idBtnConvert)

        convertIt.setOnClickListener {
            val format = DecimalFormat("###,###,###.##")
            val dblMoney = convertNum.text.toString().toDouble()
            val conversionRate = 103.37
            var convertMoney: Double = 0.00

            if (rbUSDToYen.isChecked){
                if (dblMoney <= 10000){
                    convertMoney = dblMoney * conversionRate
                    txtResult.text = format.format(convertMoney) + " Yen"
                 }else {
                    Toast.makeText(this@MainActivity, "USD must be less than 10000", Toast.LENGTH_LONG).show()
                }
            }

            if (rbYenToUSD.isChecked){
                if (dblMoney <= 10000){
                    convertMoney = dblMoney / conversionRate
                txtResult.text = format.format(convertMoney) + " USD"
                }else {
                Toast.makeText(this@MainActivity, "Yen must be less than 10000", Toast.LENGTH_LONG).show()
                }
            }



        }
    }
}