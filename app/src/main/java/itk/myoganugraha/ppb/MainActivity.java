package itk.myoganugraha.ppb;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0, mCount1;
    private TextView mShowCount;
    private Button countUp, countShow;
    private Context mContext;
    private Toast mtoast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        if(savedInstanceState != null) {
            mCount = savedInstanceState.getInt("NilainyaNih");
        }

        mShowCount = (TextView) findViewById(R.id.show_count);


        //tombol menambahkan nilai mCount
        countUp = (Button) findViewById(R.id.button_count);
        countUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCount++;
                if(mShowCount != null)
                    mShowCount.setText(Integer.toString(mCount));
            }
        });


        //tombol menampilkan toast nilai mCount
        countShow = (Button) findViewById(R.id.button_reset);
        countShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShowCount.setText(Integer.toString(mCount));
                showToast();
            }
        });


    }

    private void showToast() {
        if(mtoast != null){
            mtoast.cancel();
        }
        mtoast = Toast.makeText(mContext, "now count :  " + mCount, Toast.LENGTH_SHORT);
        mtoast.show();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putInt("NilainyaNih", mCount);
        super.onSaveInstanceState(savedInstanceState);
    }
}