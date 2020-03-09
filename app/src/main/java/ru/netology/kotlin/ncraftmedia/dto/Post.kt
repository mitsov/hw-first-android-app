package ru.netology.kotlin.ncraftmedia.dto

class Post(
    val id: Long,
    val author: String,
    val content: String,
    val created: Long,
    var likedByMe: Boolean = false,
    var commentedByMe: Boolean = false,
    var sharedByMe: Boolean = false,
    var likes: Int,
    var comments: Int,
    var shares: Int
)

{
    fun timeAgo (createdSeconds: Long): String{

        val numberOfDays: Int
        val numberOfHours: Int
        val numberOfMinutes: Int

        val seconds: Int = (System.currentTimeMillis() / 1000 - createdSeconds).toInt()

        numberOfDays = seconds / 86400
        numberOfHours = (seconds % 86400 ) / 3600
        numberOfMinutes = ((seconds % 86400 ) % 3600 ) / 60

        val timeAgo = when {

            (numberOfDays == 1) -> "день назад"
            (numberOfDays in 2..30) -> "$numberOfDays д. назад"
            (numberOfDays > 30) -> "больше месяца назад"
            (numberOfHours == 1) -> "час назад"
            (numberOfHours in 2..24) -> "$numberOfHours ч. назад"
            (numberOfMinutes < 1) -> "меньше минуты назад"
            (numberOfMinutes == 1) -> "минуту назад"
            (numberOfMinutes in 2..59) -> "$numberOfMinutes мин. назад"

            else -> "Что-то пошло не так"
        }

        return  timeAgo
    }

}