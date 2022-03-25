package com.example.atv2mobile

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class ActivityIdade : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_idade)

        val btnDatePicker:Button = findViewById(R.id.btnDatePicker)
        val tvSelectedDate:TextView = findViewById(R.id.tvSelectedDate)

        btnDatePicker.setOnClickListener{view ->
            clickDatePicker(view) }


    }

    fun clickDatePicker(view: View){

        val tvSelectedDate:TextView = findViewById(R.id.tvSelectedDate)
        val tvAgeInDays:TextView = findViewById(R.id.tvAgeInDays)
        val tvAgeInMinutes:TextView = findViewById(R.id.tvAgeInMinutes)

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{
                view, selectedYear, selectedMonth, selectedDayOfMonth ->
            Toast.makeText(this,"The chosen year is $selectedYear, the month is ${selectedMonth+1} and the day is $selectedDayOfMonth",
                Toast.LENGTH_SHORT).show()
            val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
            val tvSelectedDate:TextView = findViewById(R.id.tvSelectedDate)

            tvSelectedDate.setText(selectedDate)

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val theDate = sdf.parse(selectedDate)

            val selectedDateInMinutes = theDate!!.time /60000

            val selectedDateInDays = theDate!!.time / 86400000

            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

            val currentDateInMinutes = currentDate!!.time /60000

            val currenteDateInDays = currentDate!!.time / 86400000

            val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

            val differenceInDays = currenteDateInDays - selectedDateInDays

            tvAgeInMinutes.setText(differenceInMinutes.toString())

            tvAgeInDays.setText(differenceInDays.toString())
        }, year, month, day)

        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()
    }
}
