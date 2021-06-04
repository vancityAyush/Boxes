package com.ak11.boxes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ak11.boxes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, RatingBar.OnRatingBarChangeListener {

    ActivityMainBinding binding;
    CheckBox[] checkBoxes;

    SeekBar seekBar;
    RatingBar ratingBar;

    RadioGroup radioGroup;
    RadioButton[] radioButtons ;

    TextView txtSeekbar, txtRatingBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        seekBar = binding.seekBar;
        ratingBar = binding.ratingBar;
        radioGroup = binding.radioGroup;
        checkBoxes = new CheckBox[]{binding.checkBox1, binding.checkBox2, binding.checkBox3, binding.checkBox4,
                binding.checkBox5, binding.checkBox6, binding.checkBox7, binding.checkBox8};
        radioButtons = new RadioButton[]{binding.radioButton1, binding.radioButton2, binding.radioButton3, binding.radioButton4};
        txtSeekbar = binding.txtSeekBar;
        txtRatingBar = binding.txtRatingBar;

        for(CheckBox cb : checkBoxes){
            cb.setOnCheckedChangeListener(this);
        }

        seekBar.setOnSeekBarChangeListener(this);
        ratingBar.setOnRatingBarChangeListener(this);

        radioGroup.setOnCheckedChangeListener(this);



    }


    //CHECKBOXES
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(isChecked){
            Toast.makeText(this,buttonView.getText()+" is checked!",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,buttonView.getText()+" is unchecked!",Toast.LENGTH_SHORT).show();

        }

    }


    //SEEKBAR
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(fromUser){
            txtSeekbar.setText(String.format("Current Seekbar Value %d",progress));
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(this,"Seekbar Started!!!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(this,"Seekbar Stopped!",Toast.LENGTH_SHORT).show();

    }

    //RATING BAR
    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        if(fromUser){
                String str = String.format("Rating is %.1f out of %d",rating,ratingBar.getNumStars());
                txtRatingBar.setText(str);
        }
    }


    //RADIOGROUP
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        switch (checkedId){
//            case R.id.radioButton1:
//                Toast.makeText(this,radioButtons[0].getText()+" is checked",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.radioButton2:
//                Toast.makeText(this,radioButtons[1].getText()+" is checked",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.radioButton3:
//                Toast.makeText(this,radioButtons[2].getText()+" is checked",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.radioButton4:
//                Toast.makeText(this,radioButtons[3].getText()+" is checked",Toast.LENGTH_SHORT).show();
//                break;
//
//        }
        RadioButton rb = findViewById(checkedId);
        Toast.makeText(this,rb.getText()+" is checked",Toast.LENGTH_SHORT).show();

    }
}