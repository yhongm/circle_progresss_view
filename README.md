# a simple circle progress 一个简单的圆形进度条
## 效果
  </br> 
  <img src="/preview/preview.jpg">

  ## 使用方法
  
  <com.yhongm.circle_progress_core.CircleProgressView
        android:id="@+id/circleprogress"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_centerInParent="true"
        custom:bgColor="#00ff00"
        custom:current="10"
        custom:progressColor="#ff0000"
        custom:total="100"></com.yhongm.circle_progress_core.CircleProgressView>
		
#### bgColor 进度条背景色
#### progressColor 进度条颜色
#### total 进度条最大值
#### current 进度条当前值

### CircleProgressView.setCurrentProgress 方法设置当前进度