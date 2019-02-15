package nitish.example.com.truthdare;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    public ImageView imageView;
    private Random random = new Random();
    private int lastDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
    }
    public void spin(View view){
        int newDirection = random.nextInt(3600);
        float pivotX = imageView.getWidth()/2;
        float pivotY = imageView.getHeight()/2;
        Animation rotate = new RotateAnimation(lastDirection,newDirection,pivotX,pivotY);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                button.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        lastDirection=newDirection;
        imageView.startAnimation(rotate);
    }
}
