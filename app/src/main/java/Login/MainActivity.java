package Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import Content.Create_New_Account;
import Content.MainGame;
import com.example.theanimationgame.R;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText etPass;
    TextView tvKetQua,tvFgtPass,tvCrtAccount;
    EditText etUserName;
    CheckBox ckSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLongin);
        etPass = findViewById(R.id.etPass);
        tvKetQua = findViewById(R.id.tvKetQua);
        etUserName = findViewById(R.id.etUserName);
        tvFgtPass =  findViewById(R.id.tvFgtPass);
        tvCrtAccount = findViewById(R.id.tvCrtAccount);
        tvCrtAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Create_New_Account.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(checkTaiKhoan()==true&&checkMatKhau()==true){
                   tvKetQua.setText("ĐĂNG NHẬP THÀNH CÔNG");
                   Intent intent = new Intent(getBaseContext(), MainGame.class);
                   startActivity(intent);
               }
            }
        });
    }
    public boolean checkTaiKhoan(){
        String userPattern = "(([a-z][A-Z][0,9]).{8,})";
        if(etUserName.getText().toString().isEmpty()){
            etUserName.setError("Tài khoản không được bỏ trống");
            return false;
        }
        return true;
    }
    public boolean checkMatKhau(){
        String passPattern= "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,})";
        if(Pattern.matches(passPattern,etPass.getText().toString())&&(etPass.getText().toString()).compareTo((etUserName.getText().toString()))!=0){
            return true;
        }
        else {
            etPass.setError("- Đăng nhập thất bại. Kiểm tra lại mật khẩu\n- Mật khẩu phải khác tên tài khoản và có từ 8 ký tự bao gồm chữ hoa, chữ thường, số và kí tự đặc biệt");
            return false;
        }
    }
}