package com.mustafayigit.kotlinrestexample.util

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

infix fun Context.extToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun <T> Context.extStartActivity(className: Class<T>, bundle: Bundle) {
    val intent = Intent(this, className).putExtra("bundle", bundle)
    startActivity(intent)
}