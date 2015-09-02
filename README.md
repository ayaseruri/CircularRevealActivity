# CircularRevealActivityLib
this lib brings android circularreveal activity transition on android4.0+

<img src="https://github.com/ayaseruri/CircularRevealActivity/blob/master/demoapk/demo.gif" alt="gif" style="width: 360px;"/>

[DemoApk](https://github.com/ayaseruri/CircularRevealActivity/blob/master/demoapk/demo-debug.apk?raw=true)

 first of all,you must disable system default activity transition by overridePendingTransition(0, 0) or other method;

## You just need 3 steps：
1. add to your app build.gradle

  ```java
  repositories {
      maven {
          url "https://jitpack.io"
      }
  }
  ```
## Gradle
  ```java
  dependencies {
      ...
      compile 'andy.ayaseruri.circularrevealactivity:lib:1.0.0'
      compile 'com.github.ozodrukh:CircularReveal:1.1.1'

  }
  ```

  ## Maven
  ```java
  <groupId>andy.ayaseruri.circularrevealactivity</groupId>
  <artifactId>lib</artifactId>
  <version>1.0.0</version>
  ```

2. the activity that you want to open with circularreveal effect must extends the **CircularRevealActivity** and you must use **setContentView(View yourView)** or **setContentView(int yourLayoutId)** to set your activity's layout;

3. the activity's theme that you want to open with circularreveal effect must have the following tags:
```xml
<item name="android:windowBackground">@android:color/transparent</item>
<item name="android:windowIsTranslucent">true</item>
```

## how to set circularreveal start point:
### there are two methods to set start point:
1. you may use setStartPoint(int x, int y) in CircularRevealActivity,this method must be called before setContentView method;

2. you can also use intent like:
```java
Intent intent = new Intent(MainActivity.this, MyCircularRevealActivity.class);
intent.putExtra("start_point", int[2] clickPoint);
startActivity(intent);
overridePendingTransition(0, 0);
```
you can use setCircularRevealDuration() to set duration.
## Thank to
[CircularReveal](https://github.com/ozodrukh/CircularReveal)
