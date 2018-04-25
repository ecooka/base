package cn.ecook.basedemo.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.ui.BaseActivity;
import cn.ecook.base.listener.SingleClickListener;
import cn.ecook.base.permissions.PermissionNameUtil;
import cn.ecook.base.permissions.PermissionUtil;
import cn.ecook.basedemo.R;

/**
 * @author ciba
 * @date 2018/4/3
 * @description
 */

public class PermissionActivity extends BaseActivity {
    private TextView tvContent;
    private SingleClickListener clickListener = new SingleClickListener() {
        @Override
        public void onSingleClick(View view) {
            switch (view.getId()) {
                case R.id.btnSinglePermission:
                    singlePermission();
                    break;
                case R.id.btnManyPermission:
                    manyPermission();
                    break;
                default:
                    break;
            }
        }
    };
    public static void jumpHere(@NonNull Context context){
        context.startActivity(new Intent(context, PermissionActivity.class));
    }

    @Override
    public int contentView() {
        return R.layout.activity_permission;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        tvContent = (TextView) findViewById(R.id.tvContent);
    }

    @Override
    public void initListener() {
        findViewById(R.id.btnSinglePermission).setOnClickListener(clickListener);
        findViewById(R.id.btnManyPermission).setOnClickListener(clickListener);
    }

    @Override
    public BasePresenter initBasePresenter() {
        return null;
    }

    @Override
    public void initData() {

    }

    /**
     * 申请单个权限
     */
    private void singlePermission() {
        PermissionUtil.requestPermission(this, Manifest.permission.CAMERA, new PermissionUtil.GrantedListener() {
            @Override
            public void granted() {
                // 权限申请成功
                tvContent.setText(PermissionNameUtil.getPermissionName(Manifest.permission.CAMERA) + " 权限申请成功");
            }
        });
    }

    /**
     * 申请多个权限
     */
    private void manyPermission() {
       PermissionUtil.requestPermissions(this, new PermissionUtil.PermissionsListener() {
           @Override
           public void finish(List<String> refusePermissions, List<String> refuseNoAskingPermissions) {
               // 权限申请结束，refusePermissions - 被拒绝的权限集合，refuseNoAskingPermissions - 之前被拒绝的权限集合
               tvContent.setText("被拒绝了 " + (refusePermissions.size() + refuseNoAskingPermissions.size()) + " 个权限");
           }
       }, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_SMS});
    }
}
