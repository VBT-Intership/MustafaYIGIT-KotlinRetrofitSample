package com.mustafayigit.kotlinrestexample.util

import android.content.Context
import android.widget.Toast

infix fun Context.extToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}