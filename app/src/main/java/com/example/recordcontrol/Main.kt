import android.os.Build
import androidx.annotation.RequiresApi
import com.example.recordcontrol.*
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
fun main(){
    val period = Period(initialDate = LocalDate.parse("2022-01-01"),
        finalDate = LocalDate.parse("2022-02-28"),
        description = "Enero - Julio 2022")

    val employee =
        Empleoye(id = 1,
            fullName = "Jennifer Diego Vásquez",
            academicLevel = AcademicLevel.ASSOCIATE,
            curp = "DIVJ001225MOCGSNA6",
            dateOfAdmission = LocalDate.parse("2018-07-04"),
            budgetKey = "00163792012"
        )

    val scheduleDetails =  ArrayList<Schedule.Detail> ()

    scheduleDetails.add(
        Schedule.Detail(dayOfWeek= DayOfWeek.MONDAY,
        checkIn= LocalTime.parse("07:00:00"),
        checkOut= LocalTime.parse("16:00:00")))
    scheduleDetails.add(
        Schedule.Detail(dayOfWeek= DayOfWeek.TUESDAY,
        checkIn= LocalTime.parse("07:00:00"),
        checkOut= LocalTime.parse("15:00:00")))
    scheduleDetails.add(
        Schedule.Detail(dayOfWeek= DayOfWeek.FRIDAY,
        checkIn= LocalTime.parse("08:00:00"),
        checkOut= LocalTime.parse("16:00:00")))


    val schedule = Schedule.Builder(employee = employee, period=period)
        .addOne(
            Schedule.Detail(dayOfWeek = DayOfWeek.WEDNESDAY,
            checkIn = LocalTime.parse("09:00:00"),
            checkOut = LocalTime.parse("15:00:00")))
        .addMany(scheduleDetails)
        .build()

    val permissions = listOf(
        Permission(employee = employee, LocalDate.parse("2022-01-05"),
            justification = "Cita medica")
    )

    val checksInOut= ArrayList<CheckInOut>()
    checksInOut.add(
        CheckInOut(employee = employee,date= LocalDate.parse("2022-01-03"),
            checkIn = LocalTime.parse("07:00:00"),
            checkOut = LocalTime.parse("16:00:00"))
    )
    checksInOut.add(
        CheckInOut(employee = employee,date= LocalDate.parse("2022-01-04"),
            checkIn = LocalTime.parse("07:00:00"),
            checkOut = LocalTime.parse("15:00:00"))
    )
    checksInOut.add(
        CheckInOut(employee = employee,date= LocalDate.parse("2022-01-05"),
            checkIn = LocalTime.parse("09:00:00"),
            checkOut = LocalTime.parse("15:00:00"))
    )
    checksInOut.add(
        CheckInOut(employee = employee,date= LocalDate.parse("2022-01-07"),
            checkIn = LocalTime.parse("08:00:00"),
            checkOut = LocalTime.parse("16:10:00"))
    )

    val incident = Incident(employee = employee, currentSchedule = schedule,
        checksInOut = checksInOut, permissions= permissions,
        initialDate = LocalDate.parse("2022-12-31"),
        finalDate = LocalDate.parse("2022-02-15"))

    println("Employee ${employee.fullName} has ${incident.getAbsences()} absences " )

}