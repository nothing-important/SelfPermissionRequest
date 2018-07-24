package com.example.administrator.selfpermissionreq;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mBtn = findViewById(R.id.mBtn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestSelfPermissions(new String[]{Manifest.permission.READ_PHONE_STATE}, 100, new PermissionRequestListener() {
                    @Override
                    public void onPermissionGranted(List<String> allGrantedPermission) {
                        Toast.makeText(MainActivity.this, "permission granted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {
                        showSettingDialog(MainActivity.this);
                    }
                });
            }
        });
    }
}
