package com.example.recordcontrol

import java.time.LocalDate

fun hasPermission(employee: Empleoye, date: LocalDate, permissions: List<Permission>): Boolean {
    val permission = permissions.firstOrNull { it.date == date && it.employee == employee }
    return (permission != null)
}
