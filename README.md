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
  compile 'cn.ecook:base:0.0.5'
  ```

* Step3

  Base中已经集成了以下第三方库

  ![]()