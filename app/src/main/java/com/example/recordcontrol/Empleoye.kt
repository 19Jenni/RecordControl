package com.example.recordcontrol

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

data class Empleoye(
    val id: Long,
    val fullName:String,
    val academicLevel: AcademicLevel,
    val curp:String,
    val dateOfAdmission: LocalDate,
    val budgetKey: String
){
    @RequiresApi(Build.VERSION_CODES.O)
    fun getSeniority():Int{
        val currentYear = LocalDate.now().year
        val currentMonth = LocalDate.now().monthValue
        val currentDay = LocalDate.now().dayOfMonth
        val yearOfBirth = dateOfAdmission.year
        val monthOfBirth = dateOfAdmission.monthValue
        val dayOfBirth = dateOfAdmission.dayOfMonth
        val year = currentYear - yearOfBirth
        return (if (currentMonth<monthOfBirth ||
            (currentMonth==monthOfBirth && currentDay<dayOfBirth ))
            year - 1
        else
            year)
    }
    fun getGenre()=curp.substring(10,11)
}
