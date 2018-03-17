package xyz.mayahiro.animatedvectordrawablesample

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.graphics.drawable.Animatable2Compat
import android.support.graphics.drawable.AnimatedVectorDrawableCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<AppCompatImageView>(R.id.image_view)
        val drawable = imageView.drawable as AnimatedVectorDrawableCompat
        drawable.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
            override fun onAnimationEnd(drawable: Drawable?) {
                imageView.post { (drawable as AnimatedVectorDrawableCompat).start() }
            }
        })
        drawable.start()
    }
}
