package cn.ecook.base.activity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import cn.ecook.base.R;
import cn.ecook.base.adapter.GalleryPagerAdapter;
import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.ui.BaseActivity;
import cn.ecook.base.listener.SingleClickListener;
import cn.ecook.base.util.FileUtil;
import cn.ecook.base.widget.dialog.EcookLoadingDialog;

/**
 * @author ciba
 * @date 2018/4/3
 * @description ：图片画廊界面
 */

public class GalleryActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private static final String IMAGES = "IMAGES";
    private static final String POSITION = "POSITION";
    private static final String NEED_DOWNLOAD = "NEED_DOWNLOAD";
    private ViewPager viewPager;
    private TextView tvPager;
    private TextView tvSave;
    private MediaScannerConnection scanner;
    private List<String> images;
    private EcookLoadingDialog dialog;
    private boolean needDownload;

    /**
     * 跳转到当前界面
     *
     * @param context      ：上下文
     * @param position     ：默认显示第几个图片
     * @param needDownload ：是否需要显示下载按钮
     * @param images       ：图片地址集合
     */
    public static void jumpHere(Context context, int position, boolean needDownload, List<String> images) {
        Intent intent = new Intent(context, GalleryActivity.class);
        intent.putExtra(IMAGES, (Serializable) images);
        intent.putExtra(POSITION, position);
        intent.putExtra(NEED_DOWNLOAD, needDownload);
        context.startActivity(intent);
    }

    @Override
    public boolean setFullScreen() {
        // 重写BaseActivity的方法，设置当前Activity为全屏状态
        return true;
    }

    @Override
    public int contentView() {
        return R.layout.activity_base_gallery;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tvPager = (TextView) findViewById(R.id.tvPager);
        tvSave = (TextView) findViewById(R.id.tvSave);
    }

    @Override
    public void initListener() {
        viewPager.addOnPageChangeListener(this);
        tvSave.setOnClickListener(new SingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                saveImage();
            }
        });
    }

    @Override
    public BasePresenter initBasePresenter() {
        return null;
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        images = (List<String>) intent.getSerializableExtra(IMAGES);
        int position = intent.getIntExtra(POSITION, 0);
        needDownload = intent.getBooleanExtra(NEED_DOWNLOAD, false);

        scanner = new MediaScannerConnection(this, null);
        scanner.connect();

        setSaveVisible(0);

        GalleryPagerAdapter galleryPagerAdapter = new GalleryPagerAdapter(images);
        galleryPagerAdapter.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        viewPager.setAdapter(galleryPagerAdapter);
        viewPager.setCurrentItem(position);
        tvPager.setText((position + 1) + " / " + images.size());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (scanner != null) {
            // 断开连接
            scanner.disconnect();
            scanner = null;
        }
        dismissLoading();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        // 改变当前图片
        tvPager.setText((position + 1) + " / " + viewPager.getAdapter().getCount());
        setSaveVisible(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 设置保存按钮显示隐藏状态
     * @param position
     */
    private void setSaveVisible(int position) {
        if (position <= 0 || images == null || position >= images.size()) {
            tvSave.setVisibility(View.GONE);
            return;
        }
        String url = images.get(position);
        tvSave.setVisibility(needDownload && url != null && url.startsWith("http") ? View.VISIBLE : View.GONE);
    }

    /**
     * 保存图片到相册
     */
    private void saveImage() {
        int currentItem = viewPager.getCurrentItem();
        if (currentItem < 0 || images == null || currentItem >= images.size()) {
            toast("没有可下载的图片");
            return;
        }
        showLoading();
        String url = images.get(currentItem);
        FileUtil.simpleDownloadFile(this, url, FileUtil.getPhotoRoot(), System.currentTimeMillis() + ".jpg", new FileUtil.FileDownloadCallBack() {
            @Override
            public void failed(String message) {
                toast(message);
                dismissLoading();
            }

            @Override
            public void success(@NonNull File file) {
                if (scanner != null) {
                    scanner.scanFile(file.getPath(), "image/jpeg");
                }
                dismissLoading();
                toast("保存成功");
            }
        });
    }

    /**
     * 展示loading弹框
     */
    private void showLoading() {
        dismissLoading();
        dialog = new EcookLoadingDialog(this);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    /**
     * 隐藏loading弹框
     */
    private void dismissLoading() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }
}
