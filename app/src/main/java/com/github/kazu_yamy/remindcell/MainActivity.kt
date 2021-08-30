package com.github.kazu_yamy.remindcell

import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_week.*
import kotlinx.android.synthetic.main.activity_weekset.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import android.content.Intent


class MainActivity : AppCompatActivity() {



    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        Date()

        Button.setOnClickListener {
            showDatePicker()
        }

        Button1.setOnClickListener {
            showWeekPicker()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun Date(){
        val calendar: Calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"), Locale.JAPAN);

        val current = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日")
        val formatted = current.format(formatter)

        textView5.text= formatted

        val day = calendar.get(Calendar.DAY_OF_WEEK)
        if (day == 1) {
            textView8.text = "日曜日"
            textView8.setTextColor(Color.RED)
        }else if(day == 2) {
            textView8.text = "月曜日"
            textView8.setTextColor(Color.BLACK)
        }else if(day == 3) {
            textView8.text = "火曜日"
            textView8.setTextColor(Color.MAGENTA)
        }else if(day == 4) {
            textView8.text = "水曜日"
            textView8.setTextColor(Color.CYAN)
        }else if(day == 5) {
            textView8.text = "木曜日"
            textView8.setTextColor(Color.GREEN)
        }else if(day == 6) {
            textView8.text = "金曜日"
            textView8.setTextColor(Color.YELLOW)
        }else {
            textView8.text = "土曜日"
            textView8.setTextColor(Color.BLUE)
        }
    }

    private fun showDatePicker() {


        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener() { view, year, month, dayOfMonth ->
                textView.text = "選択した日付は「${year}/${month + 1}/${dayOfMonth}」です"
            },
            2021,
            7,
            25//ここ今日の日付でやりたいんだけどできないから数字で代用してる
        )
        datePickerDialog.show()
    }

    private fun showWeekPicker() {
        setContentView(R.layout.activity_week)

        Button2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        Button11.setOnClickListener {
            setContentView(R.layout.activity_weekset)

            textView4.text = "月曜日の持ち物"

            button2.setOnClickListener {
                showWeekPicker()
            }
        }
        Button12.setOnClickListener {
            setContentView(R.layout.activity_weekset)

            textView4.text = "火曜日の持ち物"

            button2.setOnClickListener {
                showWeekPicker()
            }
        }
        Button13.setOnClickListener{
            setContentView(R.layout.activity_weekset)

            textView4.text = "水曜日の持ち物"

            button2.setOnClickListener {
                showWeekPicker()
            }
        }
        Button21.setOnClickListener{
            setContentView(R.layout.activity_weekset)

            textView4.text = "木曜日の持ち物"

            button2.setOnClickListener {
                showWeekPicker()
            }
        }
        Button22.setOnClickListener{
            setContentView(R.layout.activity_weekset)

            textView4.text = "金曜日の持ち物"

            button2.setOnClickListener {
                showWeekPicker()
            }
        }
        Button31.setOnClickListener{
            setContentView(R.layout.activity_weekset)

            textView4.text = "土曜日の持ち物"

            button2.setOnClickListener {
                showWeekPicker()
            }
        }
        Button32.setOnClickListener{
            setContentView(R.layout.activity_weekset)

            textView4.text = "日曜日の持ち物"

            button2.setOnClickListener {
                showWeekPicker()
            }
        }
    }
}
