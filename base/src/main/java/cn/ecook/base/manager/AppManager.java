package cn.ecook.base.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import java.lang.ref.WeakReference;
import java.util.Stack;

/**
 * App Activity 管理类
 * @author ciba
 */
public class AppManager {
    private static final String TAG = "AppManager";
    private Stack<WeakReference<Activity>> activityStack = new Stack<>();
    private static AppManager instance;

    private AppManager() {
    }

    public synchronized static AppManager getAppManager() {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(WeakReference<Activity> activity) {
        activityStack.add(activity);
    }

    /**
     * 移除Activity到堆栈
     */
    public void removeActivity(WeakReference<Activity> activity) {
        if (activity != null) {
            activityStack.remove(activity);
        }
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        WeakReference<Activity> activity = activityStack.lastElement();
        return activity == null ? null : activity.get();
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        WeakReference<Activity> activity = activityStack.lastElement();
        finishActivity(activity == null ? null : activity.get());
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (WeakReference<Activity> activity : activityStack) {
            if (activity != null && activity.get() != null && activity.get().getClass().equals(cls)) {
                finishActivity(activity.get());
                break;
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            WeakReference<Activity> activityWeakReference = activityStack.get(i);
            if (null != activityWeakReference) {
                finishActivity(activityWeakReference.get());
            }
        }
        activityStack.clear();
    }

    /**
     * 获取指定的Activity
     *
     * @author kymjs
     */
    public Activity getActivity(Class<?> cls) {
        for (WeakReference<Activity> activity : activityStack) {
            if (activity != null && activity.get() != null && activity.get().getClass().equals(cls)) {
                return activity.get();
            }
        }
        return null;
    }

    /**
     * 获取Activity在栈内的下标
     * @param activity
     * @return
     */
    public int getStackIndex(WeakReference<Activity> activity) {
        if (activity == null) {
            return 0;
        }
        return activityStack.search(activity);
    }

    /**
     * @param activity ：结束这个Activity之后的所有Activity
     */
    public void finishAfterIndexActivity(WeakReference<Activity> activity) {
        finishAfterIndexActivity(getStackIndex(activity));
    }

    /**
     * @param index ：结束index之后的所有Activity
     */
    public void finishAfterIndexActivity(int index) {
        if (index >= activityStack.size()) {
            return;
        }
        for (int i = index + 1, size = activityStack.size(); i < size; i++) {
            WeakReference<Activity> activityWeakReference = activityStack.get(i);
            if (null != activityWeakReference) {
                finishActivity(activityWeakReference.get());
            }
        }
    }

    /**
     * 检查Activity是否已经结束
     */
    public boolean activityIsFinish(Activity activity){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return activity == null || activity.isDestroyed();
        } else {
            return activity == null || activity.isFinishing();
        }
    }

    /**
     * 跳转到应用商城详情页面
     */
    public void jump2AppShopDetail(Context context){
        try {
            Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 退出应用程序
     */
    public void appExit() {
        try {
            finishAllActivity();
            // 杀死该应用进程
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}