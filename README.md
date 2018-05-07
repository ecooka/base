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

  Base中已经集成了以下第三方库，注意防止冲突

  ![Base中已经集成的第三方库](https://github.com/ecooka/base/blob/master/screenshot/base%20%E9%9B%86%E6%88%90%E7%9A%84%E7%AC%AC%E4%B8%89%E6%96%B9%E5%BA%93.png)

* Step4 : Base的正确使用

  * MVC模式下使用BaseActivity（BaseFragment雷同）

    ```java
    public class MainActivity extends BaseActivity {
      
        @Override
        public int contentView() {
            // 布局文件
            return R.layout.activity_main;
        }

        @Override
        public void initView(@Nullable Bundle savedInstanceState) {
            // 初始化控件
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        }

        @Override
        public void initListener() {
    		// 初始化事件监听
        }

        @Override
        public BasePresenter initBasePresenter() {
            // MVC无需关心此返回值，只要返回null即可
            return null;
        }

        @Override
        public void initData() {
            // 初始化数据
            MainAdapter mainAdapter = new MainAdapter(Arrays.asList(ITEMS));
            mainAdapter.setOnItemClickListener(this);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(mainAdapter);
        }

        @Override
        public boolean canSwipeBack() {
            // 返回是否可以右滑退出Activity
            return false;
        }
    }
    ```

    ​

  * MVP模式下使用BaseActivity（BaseFragment雷同）

    ```java
    // 和MVC用法基本类似，指定BasePresenter
    public class MVPActivity extends BaseActivity<BasePresenter> implements IBaseView {
        @Override
        public int contentView() {
            return 0;
        }

        @Override
        public void initView(@Nullable Bundle savedInstanceState) {

        }

        @Override
        public void initListener() {

        }

        @Override
        public BasePresenter initBasePresenter() {
            // MVP返回BasePresenter的实现类并指定View层接口(第二个参数，IBaseView的实现类)
            // 在BasePresenter的实现类中进行业务操作
            return new MVPPresent(this, this);
        }

        @Override
        public void initData() {

        }
    }
    ```

  * MVVM模式下使用BaseActivity（BaseFragment雷同）

    ```java
    // 使用和MVVM基本一致，指定泛型为BaseViewModel
    public class MVVMActivity extends BaseActivity<BaseViewModel> {
        @Override
        public int contentView() {
            return 0;
        }

        @Override
        public void initView(@Nullable Bundle savedInstanceState) {

        }

        @Override
        public void initListener() {

        }

        @Override
        public BaseViewModel initBasePresenter() {
            // MVVM返回BaseViewModel的实现类
            // 在BaseViewModel的实现类中进行业务操作
            return new MVVMViewModel(this);
        }

        @Override
        public void initData() {

        }
    }
    ```

    ​

