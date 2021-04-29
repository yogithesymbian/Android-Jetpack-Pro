package id.scodeid.androidjetpackpro.utils

import junit.framework.TestCase
import org.junit.Test
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class UtilsTest : TestCase() {

    @Test
    fun testToSimpleString() {
        val dateFormat = SimpleDateFormat("MM/dd/yyyy")
        var date: Date? = null

        try {
            date = dateFormat.parse("02/28/2021")
        } catch (e: ParseException){
            e.printStackTrace()
        }

        assertEquals("Sun, 28 Feb 2021", date?.let { Utils.toSimpleString(it) })
    }
}