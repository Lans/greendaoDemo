package com.ls.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import dbmanager.CommonUtils;
import me.slq.greendao.Note;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.add)
    Button add;
    @InjectView(R.id.delete)
    Button delete;
    @InjectView(R.id.select)
    Button select;
    @InjectView(R.id.textView)
    TextView textView;
    private CommonUtils commonUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        commonUtils = new CommonUtils(this);
    }

    @OnClick({R.id.add, R.id.delete, R.id.select})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                Note note;
                for (int i = 0; i < 5; i++) {
                    note = new Note();
                    note.setContent("add :" + i);
                    note.setText("我是add" + i);
                    commonUtils.insertNote(note);
                }
                break;
            case R.id.delete:
                break;
            case R.id.select:
                List<Note> notes = commonUtils.selectNote();
                StringBuffer dd = new StringBuffer();
                for (Note aa : notes) {
                    dd.append(aa.getText());
                }
                textView.setText(dd.toString());
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.reset(this);
    }
}
