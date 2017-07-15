package seek.zz.uidemo.activity;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import seek.zz.uidemo.R;
import seek.zz.uidemo.imageview.CircleImageView;

public class BookTeacherActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = BookTeacherActivity.class.getSimpleName();


    private ImageView ivBack;
    private TextView tvTitle;

    private CircleImageView civUserIcon;
    private TextView tvUserName;
    private TextView tvUserInfo;

    private TextView tvTotalPrice;
    private RadioButton rgOne;
    private RadioButton rgTwo;
    private RadioButton rgThree;
    private EditText etInputHour;

    private ImageView ivCallPhone;
    private TextView tvBookTeacher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_teacher);

        initViews();

        setOnClick();

    }

    private void setOnClick() {
        ivBack.setOnClickListener(this);
        rgOne.setOnClickListener(this);
        rgTwo.setOnClickListener(this);
        rgThree.setOnClickListener(this);

        ivCallPhone.setOnClickListener(this);

        etInputHour.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i(TAG, "onTextChanged" + s);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i(TAG, "onTextChanged" + s);
                caculatePrice(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i(TAG, "onTextChanged" + s);
            }
        });

        tvBookTeacher.setOnClickListener(this);
    }

    private void caculatePrice(CharSequence s) {
        if (TextUtils.isEmpty(s.toString())){
            s="0";
        }
        Integer hours = Integer.parseInt(s.toString());
        tvTotalPrice.setText("¥" + (hours * 180));

    }

    private void initViews() {
        ivBack = (ImageView) findViewById(R.id.back);
        tvTitle = (TextView) findViewById(R.id.tv_top_title);
        tvTitle.setText("预约老师");

        civUserIcon = (CircleImageView) findViewById(R.id.civ_user_icon);
        tvUserName = (TextView) findViewById(R.id.tv_user_name);
        tvUserInfo = (TextView) findViewById(R.id.tv_user_info);

        tvTotalPrice = (TextView) findViewById(R.id.tv_total_price);
        rgOne = (RadioButton) findViewById(R.id.rg_one);
        rgTwo = (RadioButton) findViewById(R.id.rg_two);
        rgThree = (RadioButton) findViewById(R.id.rg_three);
        etInputHour = (EditText) findViewById(R.id.et_input_hour);

        ivCallPhone = (ImageView) findViewById(R.id.iv_call_phone);
        tvBookTeacher = (TextView) findViewById(R.id.tv_book_teacher);

        tvTotalPrice.setText("¥" + (20 * 180));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.rg_one:
                tvTotalPrice.setText("¥"+ (20*180));
                break;
            case R.id.rg_two:
                tvTotalPrice.setText("¥"+ (180*180));
                break;
            case R.id.rg_three:
                tvTotalPrice.setText("¥"+ (280*180));
                break;
            case R.id.iv_call_phone:
                Toast.makeText(BookTeacherActivity.this, "拨打电话", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_book_teacher:
                Toast.makeText(BookTeacherActivity.this, "预约老师", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
