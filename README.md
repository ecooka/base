# base

###### 集成网络请求和一些通用UI以及一些公共界面或弹框和功能（例如：GalleryActivity—画廊界面；CameraPhotoDialog—通用的相册选择和打开本地照相机弹框，无需申请权限；PermissionUtil—权限工具类等）；当然，最重要的还是适用MVC、MVP以及MVVM的通用基类和通用的多状态基类；网络请求基于OKGO的二次封装，让网络请求也变得更加简单。

#### 如何使用

* Step1

  ```java
  // 如果module使用MVVM模式在相应的Module中
  android{
  	...
  	dataBinding {
      	enabled = true
  	}    
  }
  ```

  ​


* Step2

  ```
  compile 'cn.ecook:base:0.0.7'
  ```

* Step3

  Base中已经集成了以下第三方库，注意防止冲突，其中 cn.ecook:http:0.0.1 是基于OKGO二次封装的。

  > [cn.ecook:http:0.0.1](https://github.com/ecooka/Http)
  >
  > [com.tbruyelle.rxpermissions2:rxpermissions:0.9.5@aar'](https://github.com/tbruyelle/RxPermissions)
  >
  > [com.github.bumptech.glide:glide:4.2.0'](https://github.com/bumptech/glide)
  >
  > [com.github.chrisbanes:PhotoView:2.0.0](https://github.com/chrisbanes/PhotoView)
  >
  > [com.github.CymChad:BaseRecyclerViewAdapterHelper:2.9.30](https://github.com/CymChad/BaseRecyclerViewAdapterHelper)
  >
  > [com.scwang.smartrefresh:SmartRefreshLayout:1.1.0-alpha-5](https://github.com/scwang90/SmartRefreshLayout)
  >
  > [com.jude:swipebackhelper:3.1.2](https://github.com/Jude95/SwipeBackHelper)

  ​

* Step4 : Base的正确使用

  * MVC模式下使用BaseActivity（BaseFragment雷同）

    > [MVC模式下使用BaseActivity](https://github.com/ecooka/base/blob/master/app/src/main/java/cn/ecook/basedemo/activity/MainActivity.java)

    ​

  * MVP模式下使用BaseActivity（BaseFragment雷同）

    > [MVP模式下使用BaseActivity](https://github.com/ecooka/base/blob/master/app/src/main/java/cn/ecook/basedemo/activity/MVPActivity.java)
    >
    > [MVP的BasePresenter使用](https://github.com/ecooka/base/blob/master/app/src/main/java/cn/ecook/basedemo/presenter/MVPPresent.java)

    ​

  * MVVM模式下使用BaseActivity（BaseFragment雷同）

    > [MVVM模式下使用BaseActivity](https://github.com/ecooka/base/blob/master/app/src/main/java/cn/ecook/basedemo/activity/MVVMActivity.java)
    >
    > [MVVM的BaseViewModel使用](https://github.com/ecooka/base/blob/master/app/src/main/java/cn/ecook/basedemo/viewmodel/MVVMViewModel.java)

    ​

  * 多状态（loading，empty，noNetwork，content）界面使用（BaseStatusActivity和BaseStatusFragment）,BaseStatusActivity包含了TitleBar

    > [多状态控件基于此控件稍作修改](https://github.com/qyxxjd/MultipleStatusView)

    ​

  * 使用和BaseActivity和BaseFragment一样，只是继承BaseStatusActivity和BaseStatusFragment

    > [BaseStatusActivity的使用](https://github.com/ecooka/base/tree/master/app/src/main/java/cn/ecook/basedemo/activity/StatusActivity.java)

    ​

  * 当然，可以使用BaseConfig设置全局的不同状态展示

    > [BaseConfig的相关配置](https://github.com/ecooka/base/tree/master/app/src/main/java/cn/ecook/basedemo/MyApplication.java)

    ​

  * 在BasePresenter或BaseViewModel的实现类中如何切换状态和更新TitleBar

    ```java
    public abstract class BasePresenter {
        protected ITitleBarUi iTitleBar;
        protected IStatusUi iStatus;

        ......
        
        /**
         * 设置状态布局操作接口
         * @param iStatusUi
         */
        public void setIStatusUi(IStatusUi iStatusUi) {
            this.iStatusUi = iStatusUi;
        }

        /**
         * 设置TitleBar操作接口
         * @param iTitleBarUi
         */
        public void setITitleBarUi(ITitleBarUi iTitleBarUi){
            this.iTitleBar = iTitleBar;
        }
    } 
    ```

    ​

  * BaseViewModel继承BasePresenter，BasePresenter中的setIStatusUi是BaseStatusActivity和BaseStatusFragment中重写设置了对应的多状态操作的接口，所以只有继承了BaseStatusActivity或BaseStatusFragment才存在iStatusUi；setITitleBarUi在BaseActivity中调用了，所以只要是BaseActivity的子类都具备iTitleBar，BaseFragment没有对应的逻辑，注意使用；IStatusUi和ITitleBarUi的具体方法参考以下

    > [TitleBar操作接口](https://github.com/ecooka/base/blob/master/base/src/main/java/cn/ecook/base/base/ui/ITitleBarUi.java)
    >
    > [多状态布局操作接口](https://github.com/ecooka/base/blob/master/base/src/main/java/cn/ecook/base/base/ui/IStatusUi.java)

    ​


* Step5 ：权限，通用功能，网络访问

  * 权限申请

    > [权限申请工具类使用](https://github.com/ecooka/base/blob/master/app/src/main/java/cn/ecook/basedemo/activity/PermissionActivity.java)

  * 照相机系统相册使用

    > [照相机系统相册及通用弹框使用](https://github.com/ecooka/base/blob/master/app/src/main/java/cn/ecook/basedemo/activity/CameraPhotoActivity.java)

  * 可缩放，支持下载的图片画廊

    ```java
    GalleryActivity.jumpHere(mContext, holder.getAdapterPosition(), true, getData());
    ```

    > [可缩放，支持下载的图片画廊界面](https://github.com/ecooka/base/blob/master/base/src/main/java/cn/ecook/base/activity/GalleryActivity.java)

  * 网络请求

    > [网络请求，initBizData()内](https://github.com/ecooka/base/blob/master/app/src/main/java/cn/ecook/basedemo/presenter/MVPStatusPresent.java)

