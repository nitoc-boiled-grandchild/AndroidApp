package com.github.kazu_yamy.remindcell

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_weekset.*
import kotlinx.android.synthetic.main.activity_dateset.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import android.content.Intent
import kotlinx.android.synthetic.main.activity_tag.*
import kotlinx.android.synthetic.main.activity_weekset.button2


class MainActivity : AppCompatActivity() {
    companion object {
        val day1 = arrayOf("月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日", "日曜日")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        showDate()

        button3.setOnClickListener {
            registration()
        }

        Button.setOnClickListener {
            showDatePicker()
        }

        Button1.setOnClickListener {
                showWeekPicker1()
        }


    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showDate(){
        val calendar: Calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"), Locale.JAPAN)

        val current = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日")
        val formatted = current.format(formatter)

        textView5.text= formatted

        when (calendar.get(Calendar.DAY_OF_WEEK)) {
            1 -> {
                textView8.text = "日曜日"
                textView8.setTextColor(Color.RED)
            }
            2 -> {
                textView8.text = "月曜日"
                textView8.setTextColor(Color.BLACK)
            }
            3 -> {
                textView8.text = "火曜日"
                textView8.setTextColor(Color.MAGENTA)
            }
            4 -> {
                textView8.text = "水曜日"
                textView8.setTextColor(Color.CYAN)
            }
            5 -> {
                textView8.text = "木曜日"
                textView8.setTextColor(Color.GREEN)
            }
            6 -> {
                textView8.text = "金曜日"
                textView8.setTextColor(Color.YELLOW)
            }
            else -> {
                textView8.text = "土曜日"
                textView8.setTextColor(Color.BLUE)
            }
        }
    }

    private fun showDatePicker() {
        val calendar: Calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"), Locale.JAPAN)
        val year1 = calendar.get(Calendar.YEAR)
        val month1 = calendar.get(Calendar.MONTH)
        val date1 = calendar.get(Calendar.DATE)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                setContentView(R.layout.activity_dateset)
                textView9.text = "${year}年${month+1}月${dayOfMonth}日の持ち物"
            },
            year1,
            month1,
            date1
        )
        datePickerDialog.show()
    }

    private fun showWeekPicker1() {
        val dialog = AlertDialog.Builder(this)
            .setTitle("曜日の選択")
            .setItems(day1) { _, which ->
                setContentView(R.layout.activity_weekset)
                textView4.text = "${day1[which]}の持ち物"
                button2.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
            .setNegativeButton("閉じる",null)
            .create()
        dialog.show()
    }

    private fun registration() {
        setContentView(R.layout.activity_tag)

        button5.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
