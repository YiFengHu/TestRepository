package com.example.moneybook.util;

import android.view.View;
import android.view.animation.ScaleAnimation;

public class AnimationUtil {
	
	public static void startViewAppearAnimation(View view) {
		ScaleAnimation starScaleAnimation = new ScaleAnimation(0.3f, 1f, 0.3f,
				1f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
				ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
		starScaleAnimation.setDuration(500);

		ScaleAnimation scaleAnim = starScaleAnimation;
		view.startAnimation(scaleAnim);
	}
	
}
