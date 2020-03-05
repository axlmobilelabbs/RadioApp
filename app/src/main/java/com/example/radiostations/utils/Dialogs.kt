package com.example.radiostations.utils

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.example.radiostations.utils.Constants.DIALOG_OK

class Dialogs (val context: Context, val title: String,val message: String) {
    companion object Factory {
        fun createAlertDialog(context: Context, title:String ,message: String) {
            val dialogBuilder = AlertDialog.Builder(context)
            dialogBuilder.setMessage(message)
                .setCancelable(true)
                .setNegativeButton(DIALOG_OK, DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })
            val alert = dialogBuilder.create()
            alert.setTitle(title)
            alert.show()
        }
    }
}