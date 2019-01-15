package com.example.saberoueslati.notebook.addnote

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.saberoueslati.notebook.R
import com.example.saberoueslati.notebook.application.di.module.ViewModelFactory
import com.example.saberoueslati.notebook.base.BaseActivity
import com.example.saberoueslati.notebook.databinding.AddNoteScreenBinding
import com.example.saberoueslati.notebook.utils.EventObserver
import com.example.saberoueslati.notebook.utils.OneClickListener
import com.kunzisoft.switchdatetime.SwitchDateTimeDialogFragment
import es.dmoral.toasty.Toasty
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class AddNoteActivity : BaseActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory<AddNoteViewModel>
    lateinit var viewModel: AddNoteViewModel
    private lateinit var binding: AddNoteScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.add_note_activity)

        viewModel = viewModelFactory.get()

        binding.viewModel = viewModel

        binding.done.setOnClickListener(object : OneClickListener() {
            override fun onClicked(it: View) {
                viewModel.saveNoteToDataBase()
                viewModel.logAllNotes()
            }
        })

        binding.goBack.setOnClickListener(object : OneClickListener() {
            override fun onClicked(it: View) {
                onBackPressed()
            }
        })

        binding.reminderButton.setOnClickListener(object : OneClickListener() {
            override fun onClicked(it: View) {
                val dateTimeDialogFragment = SwitchDateTimeDialogFragment.newInstance(
                    "Reminder date",
                    "OK",
                    "Cancel"
                )
                // Assign values
                dateTimeDialogFragment.startAtCalendarView()
                dateTimeDialogFragment.set24HoursMode(true)
                dateTimeDialogFragment.minimumDateTime = GregorianCalendar(
                    Calendar.getInstance().get(Calendar.YEAR),
                    Calendar.getInstance().get(Calendar.MONTH),
                    Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                ).time
                dateTimeDialogFragment.maximumDateTime = GregorianCalendar(2025, Calendar.DECEMBER, 31).time
                dateTimeDialogFragment.setDefaultDateTime(
                    GregorianCalendar(
                        Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                        Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                        Calendar.getInstance().get(Calendar.MINUTE)
                    ).time
                )

                // Define new day and month format
                try {
                    dateTimeDialogFragment.simpleDateMonthAndDayFormat =
                            SimpleDateFormat("dd MMMM", Locale.getDefault())
                } catch (e: SwitchDateTimeDialogFragment.SimpleDateMonthAndDayFormatException) {
                    Log.e("Test", e.message)
                }
                // Set listener
                dateTimeDialogFragment.setOnButtonClickListener(object :
                    SwitchDateTimeDialogFragment.OnButtonClickListener {
                    @SuppressLint("SimpleDateFormat")
                    override fun onPositiveButtonClick(date: Date) {

                        val df = SimpleDateFormat("dd/MMM/yyyy hh:mm")
                        viewModel.setReminderDate(date)
                        binding.reminder.text = df.format(date)
                        binding.reminder.visibility = View.VISIBLE
                    }

                    override fun onNegativeButtonClick(date: Date) {
                        // Date is get on negative button click
                    }
                })

                // Show
                dateTimeDialogFragment.show(supportFragmentManager, "dialog_time")
            }
        })

        viewModel.callBack.observe(this, EventObserver {
            Toasty.success(this, "Note Added Successfully", Toast.LENGTH_SHORT, true).show()
            onBackPressed()
        })

    }
}
