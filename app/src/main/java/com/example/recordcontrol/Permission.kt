package com.example.recordcontrol

import java.time.LocalDate

data class Permission (val employee: Empleoye,
                       val date: LocalDate,
                       val justification: String,
)