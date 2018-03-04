package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

/**
 * Camera.rotate*() 三维旋转
 *
 * Camera.rotate*() 一共有四个方法： rotateX(deg) rotateY(deg) rotateZ(deg)rotate(x, y, z)。这四个方法的区别不用我说了吧？
 *
 * canvas.save();
 *
 * camera.rotateX(30); // 旋转 Camera 的三维空间
 * camera.applyToCanvas(canvas); // 把旋转投影到 Canvas
 *
 * canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
 * canvas.restore();
 *
 * Canvas 的几何变换顺序是反的，所以要把移动到中心的代码写在下面，把从中心移动回来的代码写在上面。
 */
public class Practice11CameraRotateView extends View {
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  Bitmap bitmap;
  Point point1 = new Point(200, 100);
  Point point2 = new Point(600, 200);
  Camera camera = new Camera();

  public Practice11CameraRotateView(Context context) {
    super(context);
  }

  public Practice11CameraRotateView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice11CameraRotateView(Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    canvas.save();
    camera.save(); // 保存 Camera 的状态
    camera.rotateX(30); // 旋转 Camera 三维空间
    camera.applyToCanvas(canvas); // 把旋转投影到 Canvas
    camera.restore();  // 恢复 Camera 的状态
    canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
    canvas.restore();

    canvas.save();
    camera.save();
    camera.rotateY(30);
    camera.applyToCanvas(canvas);
    camera.restore();
    canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
    canvas.restore();
  }
}
