package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

/**
 * /**
 * Matrix 做常见变换的方式：
 *
 * 创建 Matrix 对象；
 * 调用 Matrix 的 pre/postTranslate/Rotate/Scale/Skew() 方法来设置几何变换；
 * 使用 Canvas.setMatrix(matrix) 或 Canvas.concat(matrix) 来把几何变换应用到 Canvas。
 */
public class Practice07MatrixTranslateView extends View {
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  Bitmap bitmap;
  Point point1 = new Point(200, 200);
  Point point2 = new Point(600, 200);
  Matrix matrix = new Matrix();

  public Practice07MatrixTranslateView(Context context) {
    super(context);
  }

  public Practice07MatrixTranslateView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice07MatrixTranslateView(Context context, @Nullable AttributeSet attrs,
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
    matrix.reset();
    matrix.postTranslate(-100, -100);
    canvas.concat(matrix);
    canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
    canvas.restore();

    canvas.save();
    matrix.reset();
    matrix.postTranslate(100, 100);
    canvas.concat(matrix);
    canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
    canvas.restore();
  }
}
