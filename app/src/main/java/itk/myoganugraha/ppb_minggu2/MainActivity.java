package itk.myoganugraha.ppb_minggu2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button countUp, reset;
    private Context mContext;
    private Toast mtoast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;


        mShowCount = (TextView) findViewById(R.id.show_count);
        countUp = (Button) findViewById(R.id.button_count);


        countUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCount++;
                if(mShowCount != null)
                    mShowCount.setText(Integer.toString(mCount));
                showToast();
            }
        });

        reset = (Button) findViewById(R.id.button_reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCount = 0;
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
}
